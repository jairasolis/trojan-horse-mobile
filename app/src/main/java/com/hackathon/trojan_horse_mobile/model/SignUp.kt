package com.hackathon.trojan_horse_mobile.model

data class SignUp(
    val name: String,
    val email: String,
    val studentnum: String,
    val section: String,
    val password: String,
    val confirm_password: String
)
