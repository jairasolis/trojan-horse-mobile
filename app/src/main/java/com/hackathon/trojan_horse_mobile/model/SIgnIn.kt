package com.hackathon.trojan_horse_mobile.model

data class SignIn(
    val email: String,
    val password: String
)
data class StudentDetails(
    val id: Int,
    val name: String,
    val email: String,
    val studentnum: String,
    val section: String,
)