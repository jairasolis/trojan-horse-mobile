package com.hackathon.trojan_horse_mobile.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.components.AvailableClassroomsBox
import com.hackathon.trojan_horse_mobile.components.BasicText
import com.hackathon.trojan_horse_mobile.components.CustomColorTitleText
import com.hackathon.trojan_horse_mobile.components.Dropdown

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.bg)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Spacer(modifier = Modifier.height(30.dp))

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                CustomColorTitleText(
                    text = "Classroom",
                    R.color.blacky,
                    26,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(20.dp))

                Dropdown()
            }
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                AvailableClassroomsBox()
            }
        }
    }
}
@Preview
@Composable
fun HomePrev() {
    HomeScreen(navController = rememberNavController())
}