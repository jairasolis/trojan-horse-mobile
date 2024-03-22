package com.hackathon.trojan_horse_mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.components.ClickableNavigationText
import com.hackathon.trojan_horse_mobile.components.CustomImage
import com.hackathon.trojan_horse_mobile.components.CustomImageLogo
import com.hackathon.trojan_horse_mobile.components.EditText
import com.hackathon.trojan_horse_mobile.components.EditTextPassword
import com.hackathon.trojan_horse_mobile.components.LogoImage
import com.hackathon.trojan_horse_mobile.components.RoundedButton
import com.hackathon.trojan_horse_mobile.components.TitleText
import com.hackathon.trojan_horse_mobile.navigation.Screen

@Composable
fun SignUpScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background_color)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            CustomImage(width = 170, height = 170, imageResourceID = R.drawable.logo)
            Spacer(modifier = Modifier.height(20.dp))
            TitleText(text = stringResource(R.string.hey_there))
            Spacer(modifier = Modifier.height(40.dp))

            EditText(
                value = "",
                onValueChange = {},
                title = "Name",
                keyboardType = KeyboardType.Number,
                errorMessage = "Must be in XX-XXXX-XXXXX format"
            )
            EditText(
                value = "",
                onValueChange = {},
                title = "Email",
                keyboardType = KeyboardType.Number,
                errorMessage = "Must be in XX-XXXX-XXXXX format"
            )
            EditText(
                value = "",
                onValueChange = {},
                title = "Student Number",
                keyboardType = KeyboardType.Number,
                errorMessage = "Must be in XX-XXXX-XXXXX format"
            )
            EditText(
                value = "",
                onValueChange = {},
                title = "Section",
                keyboardType = KeyboardType.Number,
                errorMessage = "Must be in XX-XXXX-XXXXX format"
            )
            Spacer(modifier = Modifier.height(5.dp))

            EditTextPassword(
                value = "",
                onValueChange = {},
                title = "Password",
                isError = false,
            )

            EditTextPassword(
                value = "",
                onValueChange = {},
                title = "Confirm Password",
                isError = false,
            )



            Spacer(modifier = Modifier.height(30.dp))

            RoundedButton(
                text = stringResource(R.string.sign_in),
                onClick = {
//                    if (uiState.isFormValid) {
//                        viewModel.signIn()
//                    } else {
//                        showErrorDialog = true
//                    }
                },
                enabled = true,
//                validation = {uiState.isFormValid},
//                errorText = "Please fill in all required fields"

            )

            Spacer(modifier = Modifier.height(30.dp))

            ClickableNavigationText(
                normalText = "Already have an account?",
                clickableText = "SIGN IN!",
                navigateTo =  Screen.SignInScreen.route,
                navController = navController
            )
        }
    }
}

@Preview
@Composable
fun SignUpPrev() {
    SignUpScreen(navController = rememberNavController())
}
