package com.hackathon.trojan_horse_mobile.app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.navigation.NavController
import com.hackathon.trojan_horse_mobile.components.BottomNavigationBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    Surface (modifier = Modifier
        .fillMaxSize(),
        color = colorResource(id = R.color.white)
    ){
        AppUI()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppUI() {
    val navController = rememberNavController()

    Scaffold (
        containerColor = colorResource(id = R.color.whitee),
        bottomBar = { BottomNavigationBar(navController) }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
        ){
            NavController(navController)
        }
    }
}

