package com.hackathon.trojan_horse_mobile.network.apiservice

import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ActivityApiService {
    @GET("activities")
    suspend fun getActivities(): Response<ActivitiesResponse>
}