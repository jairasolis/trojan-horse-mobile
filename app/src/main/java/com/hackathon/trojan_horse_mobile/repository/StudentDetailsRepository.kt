package com.hackathon.trojan_horse_mobile.repository

import com.hackathon.trojan_horse_mobile.network.RetrofitInstance
import com.hackathon.trojan_horse_mobile.network.apimodel.StudentDetailsResponse
import retrofit2.Response

class StudentDetailsRepository {
    private val studentDetailsApiService = RetrofitInstance.studentDetailsApiService

    suspend fun getStudentDetails(id: Int): Response<StudentDetailsResponse> {
        return studentDetailsApiService.studentDetails(id)
    }
}