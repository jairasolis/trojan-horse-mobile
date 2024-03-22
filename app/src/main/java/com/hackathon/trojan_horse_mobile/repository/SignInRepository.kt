package com.hackathon.trojan_horse_mobile.repository

import com.hackathon.trojan_horse_mobile.model.SignIn
import com.hackathon.trojan_horse_mobile.network.RetrofitInstance
import com.hackathon.trojan_horse_mobile.network.apimodel.SignInRequest
import com.hackathon.trojan_horse_mobile.network.apimodel.SignInResponse
import retrofit2.Response

class SignInRepository {
    private val signInApiService = RetrofitInstance.signInApiService

    suspend fun signIn(credentials: SignIn): Response<SignInResponse> {
        val signInRequest = SignInRequest(credentials.email, credentials.password)
        return signInApiService.signIn(signInRequest)
    }
}