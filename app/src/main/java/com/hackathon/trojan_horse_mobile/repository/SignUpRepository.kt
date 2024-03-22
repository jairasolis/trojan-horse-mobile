package com.hackathon.trojan_horse_mobile.repository

import com.hackathon.trojan_horse_mobile.model.SignUp
import com.hackathon.trojan_horse_mobile.network.RetrofitInstance
import com.hackathon.trojan_horse_mobile.network.apimodel.SignUpRequest
import com.hackathon.trojan_horse_mobile.network.apimodel.SignUpResponse
import retrofit2.Response

class SignUpRepository {
    private val signUpApiService = RetrofitInstance.signUpApiService


    suspend fun signUp(signUpRequest: SignUp): Response<SignUpResponse> {
        val request = SignUpRequest(
            signUpRequest.name,
            signUpRequest.email,
            signUpRequest.studentnum,
            signUpRequest.section,
            signUpRequest.password,
            signUpRequest.confirm_password
        )
        return signUpApiService.signUp(request)
    }
}