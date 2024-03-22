package com.hackathon.trojan_horse_mobile.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.components.BasicText
import com.hackathon.trojan_horse_mobile.components.CustomColorTitleText
import com.hackathon.trojan_horse_mobile.components.CustomImage
import com.hackathon.trojan_horse_mobile.components.CustomImageButton
import com.hackathon.trojan_horse_mobile.components.ProfileBox
import com.hackathon.trojan_horse_mobile.components.StaticProfile

@Composable
fun ProfileScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.whitee)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Spacer(modifier = Modifier.width(310.dp))
                    CustomImageButton(width = 30, height = 30, imageResourceID = R.drawable.arrow_right_from_bracket_solid, onClick = {Log.d("Logoutbt", "logout")})
                }

                Spacer(modifier = Modifier.height(50.dp))
                StaticProfile()

                ProfileBox(
                    name = "sdfsdf",
                    email = "sdfsdf",
                    studentId = "03-2223-043014",
                    section = "UP-FC1-BSIT2-03"
                )

            }
        }
    }
}
