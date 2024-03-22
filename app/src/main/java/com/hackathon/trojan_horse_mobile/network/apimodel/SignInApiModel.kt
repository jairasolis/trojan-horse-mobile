package com.hackathon.trojan_horse_mobile.network.apimodel

data class SignInRequest(
    val email: String,
    val password: String
)

data class SignInResponse(
    val message: String,
    val data: StudentData
)

data class StudentData(
    val id: Int,
    val name: String,
    val studentnum: String,
    val email: String,
    val section: String
)