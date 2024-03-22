package com.hackathon.trojan_horse_mobile.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.components.ActivitiesBox
import com.hackathon.trojan_horse_mobile.components.AvailableClassroomsBox
import com.hackathon.trojan_horse_mobile.components.BasicText
import com.hackathon.trojan_horse_mobile.components.CustomColorTitleText
import com.hackathon.trojan_horse_mobile.components.Dropdown

@Composable
fun ActivitiesScreen (navController: NavHostController){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.bg)
    ) {
        Column (
        ){
            Spacer(modifier = Modifier.height(30.dp))

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(30.dp))

                CustomColorTitleText(
                        text = "Activities",
                    R.color.blacky,
                    26,
                    fontWeight = FontWeight.Medium
                )
            }
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                ActivitiesBox()
            }
        }
    }
}
@Preview
@Composable
fun ActsPrev() {
    ActivitiesScreen(navController = rememberNavController())
}