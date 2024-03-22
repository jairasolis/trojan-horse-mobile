package com.hackathon.trojan_horse_mobile.uistate

data class SignUpState (
    val name: String = "",
    val email: String = "",
    val studentnum: String = "",
    val section: String = "",
    val password: String = "",
    val confirm_password: String = "",
    val isFormValid: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)