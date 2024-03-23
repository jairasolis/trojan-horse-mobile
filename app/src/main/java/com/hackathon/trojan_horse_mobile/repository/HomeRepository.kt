package com.hackathon.trojan_horse_mobile.repository

import com.hackathon.trojan_horse_mobile.network.RetrofitInstance
import com.hackathon.trojan_horse_mobile.network.RetrofitInstance.homeApiService
import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import com.hackathon.trojan_horse_mobile.network.apimodel.RoomsResponse
import retrofit2.Response

class HomeRepository {
    private val homeRepository = RetrofitInstance.homeApiService

    suspend fun getRooms(): Response<RoomsResponse> {
        return homeApiService.getRooms()
    }
}