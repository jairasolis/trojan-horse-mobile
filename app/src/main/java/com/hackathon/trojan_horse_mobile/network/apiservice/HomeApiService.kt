package com.hackathon.trojan_horse_mobile.network.apiservice

import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import com.hackathon.trojan_horse_mobile.network.apimodel.RoomsResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiService {
    @GET("rooms")
    suspend fun getRooms(): Response<RoomsResponse>
}