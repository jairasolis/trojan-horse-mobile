package com.hackathon.trojan_horse_mobile.network.apimodel

data class Rooms(
    val start_time: String,
    val end_time: String,
    val teacher_id: String,
    val subject_id: String,
    val student_program: String,
    val year_level: Int,
    val block_number: List<String>,
//    val block_number.*: String,
)

data class RoomsResponse(
    val results: List<Rooms>
)