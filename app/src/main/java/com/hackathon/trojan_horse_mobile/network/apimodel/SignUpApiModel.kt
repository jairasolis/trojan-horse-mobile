package com.hackathon.trojan_horse_mobile.network.apimodel

data class SignUpRequest(
    val name: String,
    val email: String,
    val studentnum: String,
    val section: String,
    val password: String,
    val confirm_password: String
)

data class SignUpResponse(
    val message: String
)