package com.hackathon.trojan_horse_mobile.uistate

data class SignUpState (
    val email: String = "",
    val password: String = "",
    val isFormValid: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)