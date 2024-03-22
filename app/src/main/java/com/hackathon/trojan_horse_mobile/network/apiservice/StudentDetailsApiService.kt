package com.hackathon.trojan_horse_mobile.network.apiservice

import com.hackathon.trojan_horse_mobile.network.apimodel.StudentDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentDetailsApiService {
    @GET("students/{id}")
    suspend fun studentDetails(@Path("id") id: Int): Response<StudentDetailsResponse>
}