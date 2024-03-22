package com.hackathon.trojan_horse_mobile.network.apimodel

data class SignInRequest(
    val email: String,
    val password: String
)

data class SignInResponse(
    val message: String,
)