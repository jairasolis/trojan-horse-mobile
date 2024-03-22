package com.hackathon.trojan_horse_mobile.validation

object SignInValidation {
    private const val MIN_ID_NUMBER_LENGTH = 12
    private const val MIN_PASSWORD_LENGTH = 6
    private const val MIN_NAME_LENGTH = 4


    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("^\\S+@\\S+\\.\\S+\$")
        return emailRegex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() && password.length >= MIN_PASSWORD_LENGTH
    }

}
