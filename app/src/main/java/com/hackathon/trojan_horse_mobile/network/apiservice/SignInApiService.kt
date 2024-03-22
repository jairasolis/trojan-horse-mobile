package com.hackathon.trojan_horse_mobile.network.apiservice

import com.hackathon.trojan_horse_mobile.network.apimodel.SignInRequest
import com.hackathon.trojan_horse_mobile.network.apimodel.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {
    @POST("/auth/student/login")
    suspend fun signIn(@Body signInRequest: SignInRequest): Response<SignInResponse>
}