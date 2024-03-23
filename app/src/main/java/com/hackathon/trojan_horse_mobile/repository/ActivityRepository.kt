package com.hackathon.trojan_horse_mobile.repository

import com.hackathon.trojan_horse_mobile.network.RetrofitInstance
import com.hackathon.trojan_horse_mobile.network.apimodel.Activities
import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import retrofit2.Response

class ActivityRepository {
    private val activityApiService = RetrofitInstance.activityApiService

    suspend fun getActivities(): Response<ActivitiesResponse> {
        return activityApiService.getActivities()
    }


}