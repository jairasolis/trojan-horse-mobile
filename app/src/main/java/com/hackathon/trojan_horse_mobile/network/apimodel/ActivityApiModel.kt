package com.hackathon.trojan_horse_mobile.network.apimodel

data class Activities(
    val activity_title: String,
    val activity_instructions: String
)

data class ActivitiesResponse(
    val results: List<Activities>
)