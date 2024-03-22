package com.hackathon.trojan_horse_mobile.validation

object SignUpValidation {
    private const val MIN_ID_NUMBER_LENGTH = 12
    private const val MIN_PASSWORD_LENGTH = 6
    private const val MIN_NAME_LENGTH = 4

    fun isValid(name: String): Boolean {
        return name.isNotEmpty() && name.length >= SignUpValidation.MIN_NAME_LENGTH
    }
    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("^\\S+@\\S+\\.\\S+\$")
        return emailRegex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() && password.length >= SignUpValidation.MIN_PASSWORD_LENGTH
    }

    fun isIdNumberValid(idNumber: String): Boolean {
        if (idNumber.length < SignUpValidation.MIN_ID_NUMBER_LENGTH) {
            return false
        }
        val idNumberRegex = Regex("\\d{2}-\\d{4}-\\d{5,6}")
        return idNumberRegex.matches(idNumber)
    }

    fun isConfirmPasswordValid(password: String, confirm_password: String): Boolean {
        return password == confirm_password
    }
}