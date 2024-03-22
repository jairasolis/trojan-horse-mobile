package com.hackathon.trojan_horse_mobile.network.apimodel

data class StudentDetailsResponse(
    val student: StudentDetails
)

data class StudentDetails(
    val id: Int,
    val name: String,
    val email: String,
    val studentnum: String,
    val section: String,
)