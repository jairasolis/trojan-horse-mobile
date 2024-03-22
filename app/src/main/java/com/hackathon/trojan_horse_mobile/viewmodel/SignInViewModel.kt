package com.hackathon.trojan_horse_mobile.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.hackathon.trojan_horse_mobile.model.SignIn
import com.hackathon.trojan_horse_mobile.model.StudentDetails
import com.hackathon.trojan_horse_mobile.navigation.Screen
import com.hackathon.trojan_horse_mobile.network.apimodel.StudentDetailsResponse
import com.hackathon.trojan_horse_mobile.repository.SignInRepository
import com.hackathon.trojan_horse_mobile.sharedprefs.AuthManager
import com.hackathon.trojan_horse_mobile.uistate.SignInState
import com.hackathon.trojan_horse_mobile.validation.SignInValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel(private val navController: NavHostController): ViewModel() {
    private val signInRepository = SignInRepository()
    private val StudentDetailsViewModel = StudentDetailsViewModel(navController)


    private val _uiState = MutableStateFlow(SignInState())
    val uiState: StateFlow<SignInState> = _uiState

    fun onEmailChanged(email: String) {
        val uiState = _uiState.value.copy(email = email)
        _uiState.value = uiState.updateValidationState()
    }

    fun onPasswordChanged(password: String) {
        val uiState = _uiState.value.copy(password = password)
        _uiState.value = uiState.updateValidationState()
    }

    private fun SignInState.updateValidationState(): SignInState {
        val isIdNumberValid = SignInValidation.isEmailValid(email)
        val isPasswordValid = SignInValidation.isPasswordValid(password)
        return copy(isFormValid = isIdNumberValid && isPasswordValid)
    }

    fun signIn() {
        val credentials = SignIn(_uiState.value.email, _uiState.value.password)
        viewModelScope.launch {
            val response = signInRepository.signIn(credentials)

            if (response.isSuccessful) {
                val signInResponse = response.body()

                if (signInResponse != null) {
                    val studentData = signInResponse.data

                    val id = studentData.id
                    val name = studentData.name
                    val studentnum = studentData.studentnum
                    val email = studentData.email
                    val section = studentData.section


//                    val studentDetails = StudentDetails(
//                        id.toString(),
//                        name,
//                        email,
//                        studentnum,
//                        section
//                    )

                    Log.d(
                        "SignInViewModel",
                        "Sign-in successful. User ID: $id, Student ID: $studentnum, Email: $email, Name: $name, Section: $section"
                    )
                    if (AuthManager.isLoggedIn()) {
                        StudentDetailsViewModel.getStudentDetails(id)
                        navController.navigate(Screen.HomeScreen.route)
                    } else {
                        Toast.makeText(
                            navController.context,
                            "Sign-in failed. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        navController.context,
                        "Sign-in failed. Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    navController.context,
                    "Sign-in failed. Please try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}