package com.hackathon.trojan_horse_mobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import com.hackathon.trojan_horse_mobile.network.apimodel.StudentDetailsResponse
import com.hackathon.trojan_horse_mobile.repository.StudentDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudentDetailsViewModel(private val navController: NavController): ViewModel() {
    private val studentDetailsRepository = StudentDetailsRepository()

    private val _studentDetails = MutableLiveData<List<StudentDetailsResponse>>()
    val studentDetails: LiveData<List<StudentDetailsResponse>> = _studentDetails

    fun getStudentDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = studentDetailsRepository.getStudentDetails(id)
                if (response.isSuccessful){
                    val details = response.body()
                    details?.let {
                        _studentDetails.value = listOf(it)
                    }
                    if (details != null){
                        val id = details.student.id
                        val name = details.student.name
                        val email = details.student.email
                        val studentnum = details.student.studentnum
                        val section = details.student.section

                        Log.d(
                            "StudentDetailsViewModel",
                            "Get successful. , User ID: $id, Student ID: $studentnum, Email: $email, Name: $name, section: $section"
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("StudentDetailsViewModel", "Error fetching student details: ${e.message}", e)
            }
        }
    }
}