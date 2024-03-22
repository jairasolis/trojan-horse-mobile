package com.hackathon.trojan_horse_mobile.network.apiservice

import com.hackathon.trojan_horse_mobile.network.apimodel.SignUpRequest
import com.hackathon.trojan_horse_mobile.network.apimodel.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpApiService {
    @POST("/auth/student/register")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>
}