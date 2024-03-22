package com.hackathon.trojan_horse_mobile.network

import com.hackathon.trojan_horse_mobile.network.apiservice.ActivityApiService
import com.hackathon.trojan_horse_mobile.network.apiservice.HomeApiService
import com.hackathon.trojan_horse_mobile.network.apiservice.SignInApiService
import com.hackathon.trojan_horse_mobile.network.apiservice.SignUpApiService
import com.hackathon.trojan_horse_mobile.network.apiservice.StudentDetailsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://127.0.0.1:8000/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val activityApiService: ActivityApiService by lazy {
        retrofit.create(ActivityApiService::class.java)
    }

    val homeApiService: HomeApiService by lazy {
        retrofit.create(HomeApiService::class.java)
    }

    val signInApiService: SignInApiService by lazy {
        retrofit.create(SignInApiService::class.java)
    }

    val signUpApiService: SignUpApiService by lazy {
        retrofit.create(SignUpApiService::class.java)
    }

    val studentDetailsApiService: StudentDetailsApiService by lazy {
        retrofit.create(StudentDetailsApiService::class.java)
    }

}