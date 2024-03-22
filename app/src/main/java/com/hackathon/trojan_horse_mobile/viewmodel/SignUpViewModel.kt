package com.hackathon.trojan_horse_mobile.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hackathon.trojan_horse_mobile.model.SignUp
import com.hackathon.trojan_horse_mobile.navigation.Screen
import com.hackathon.trojan_horse_mobile.repository.SignUpRepository
import com.hackathon.trojan_horse_mobile.uistate.SignInState
import com.hackathon.trojan_horse_mobile.uistate.SignUpState
import com.hackathon.trojan_horse_mobile.validation.SignInValidation
import com.hackathon.trojan_horse_mobile.validation.SignUpValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(private val navController: NavHostController): ViewModel() {
    private val signUpRepository = SignUpRepository()

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState
    fun onNameChanged(name: String) {
        val uiState = _uiState.value.copy(name = name)
        _uiState.value = uiState.updateValidationState()
    }
    fun onEmailChanged(email: String) {
        val uiState = _uiState.value.copy(email = email)
        _uiState.value = uiState.updateValidationState()

    }
    fun onStudentNumChanged(studentnum: String) {
        val uiState = _uiState.value.copy(studentnum = studentnum)
        _uiState.value = uiState.updateValidationState()

    }

    fun onSectionChanged(section: String) {
        val uiState = _uiState.value.copy(section = section)
        _uiState.value = uiState.updateValidationState()

    }
    fun onPasswordChanged(password: String) {
        val uiState = _uiState.value.copy(password = password)
        _uiState.value = uiState.updateValidationState()
    }

    fun onConfirmPasswordChanged(confirm_password: String) {
        val uiState = _uiState.value.copy(confirm_password = confirm_password)
        _uiState.value = uiState.updateValidationState()

    }

    private fun SignUpState.updateValidationState(): SignUpState {
        val isNameValid = SignUpValidation.isValid(name)
        val isEmailValid = SignUpValidation.isEmailValid(email)
        val isStudentNumValid = SignUpValidation.isIdNumberValid(studentnum)
        val isSectionValid = SignUpValidation.isValid(section)
        val isPasswordValid = SignUpValidation.isPasswordValid(password)
        val isConfirmPasswordValid = SignUpValidation.isConfirmPasswordValid(password, confirm_password)
        return copy(isFormValid =
        isEmailValid
                && isPasswordValid
                && isNameValid
                && isSectionValid
                && isStudentNumValid
                && isConfirmPasswordValid
        )
    }
    fun signUp() {
        val signUpData = SignUp(
            name = _uiState.value.name,
            email = _uiState.value.email,
            studentnum = _uiState.value.studentnum,
            section = _uiState.value.section,
            password = _uiState.value.password,
            confirm_password = _uiState.value.confirm_password,
        )
        viewModelScope.launch {
            try {
                // make api call to sign up
                val response = signUpRepository.signUp(signUpData)
                Log.d("SignUpResponse", "Response: ${response.message()}")
                Toast.makeText(navController.context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.SignInScreen.route)
            } catch (e: Exception) {
                Log.e("SignUpResponse", "Exception: ${e.message}")
                Toast.makeText(navController.context, "Sign Up Failed. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}