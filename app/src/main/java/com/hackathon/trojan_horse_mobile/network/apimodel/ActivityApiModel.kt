package com.hackathon.trojan_horse_mobile.network.apimodel

data class Activities(
    val current_time: String,
    val classrooms: String
)

data class ActivitiesResponse(
    val results: List<Activities>
)