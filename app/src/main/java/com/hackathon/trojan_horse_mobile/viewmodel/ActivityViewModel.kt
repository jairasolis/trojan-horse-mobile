package com.hackathon.trojan_horse_mobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import com.hackathon.trojan_horse_mobile.repository.ActivityRepository
import kotlinx.coroutines.launch

class ActivityViewModel: ViewModel() {
    private val activityRepository = ActivityRepository()

    private val _activities = MutableLiveData<List<ActivitiesResponse>>()
    val activities: LiveData<List<ActivitiesResponse>> = _activities

    fun fetchActivities(){
        viewModelScope.launch {
            try {
                val response = activityRepository.getActivities()
                if (response.isSuccessful){
                    val details = response.body()
                    details?.let {
                        _activities.value = listOf(it)
                        Log.d("ActivityViewModel", "Fetched activities: $details")
                    }
                } else {
                    Log.e("ActivityViewModel", "Failed to fetch activities: ${response.code()}")
                    // Handle error response
                }
            } catch (e: Exception) {
                Log.e("ActivityViewModel", "Error fetching activities: ${e.message}", e)
                // Handle network exceptions
            }
        }
    }

}