package com.hackathon.trojan_horse_mobile.network.apimodel

data class Activities(
    val title: String,
    val description: String
)

data class ActivitiesResponse(
    val results: List<Activities>
)