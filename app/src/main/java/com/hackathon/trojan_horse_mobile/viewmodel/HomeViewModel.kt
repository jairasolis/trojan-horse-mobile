package com.hackathon.trojan_horse_mobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.trojan_horse_mobile.network.apimodel.ActivitiesResponse
import com.hackathon.trojan_horse_mobile.network.apimodel.RoomsResponse
import com.hackathon.trojan_horse_mobile.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val homeRepository = HomeRepository()

    private val _rooms = MutableLiveData<List<RoomsResponse>>()
    val rooms: LiveData<List<RoomsResponse>> = _rooms

    fun fetchRooms(){
        viewModelScope.launch {
            try {
                val response = homeRepository.getRooms()
                if (response.isSuccessful){
                    val details = response.body()
                    details?.let {
                        _rooms.value = listOf(it)
                        Log.d("HomeViewModel", "Fetched rooms: $details")
                    }
                } else {
                    Log.e("HomeViewModel", "Failed to fetch rooms: ${response.code()}")
                    // Handle error response
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error fetching rooms: ${e.message}", e)
                // Handle network exceptions
            }
        }
    }
}