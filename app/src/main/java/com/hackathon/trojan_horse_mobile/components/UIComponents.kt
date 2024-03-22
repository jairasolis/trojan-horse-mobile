package com.hackathon.trojan_horse_mobile.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.navigation.BottomNavItem
import com.hackathon.trojan_horse_mobile.navigation.Screen



@Composable
fun LogoImage() {
    Image(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
        ,

        painter = painterResource(id = R.drawable.logo),
        contentDescription = "App Logo"
    )
}
@Composable
fun TitleText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.pale_green)
        )
    )
}

@Composable
fun BasicText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.edit_text_gray)
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    keyboardType: KeyboardType,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = colorResource(id = R.color.edit_text_gray),
                focusedLabelColor = colorResource(id = R.color.edit_text_gray),
                containerColor = colorResource(id = R.color.background_color),
            ),
            modifier = Modifier
                .width(300.dp)
                .height(60.dp),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 18.sp),
            label = { Text(title) },
            placeholder = { Text(title) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError
        )
        if (isError && !errorMessage.isNullOrBlank()) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(start = 12.dp),
                color = Color.Red
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextPassword(
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column {
        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.eye_solid)
        else
            painterResource(id = R.drawable.eye_slash_solid)

        TextField(
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = colorResource(id = R.color.edit_text_gray),
                focusedLabelColor = colorResource(id = R.color.edit_text_gray),
                containerColor = colorResource(id = R.color.background_color),
            ),
            modifier = Modifier
                .width(300.dp)
                .height(60.dp),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 18.sp),
            label = { Text(title) },
            placeholder = { Text(title) },
            isError = isError,

            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
                if (isError && !errorMessage.isNullOrBlank()) {
                    Text(
                        text = errorMessage,
                        modifier = Modifier.padding(start = 12.dp),
                        color = Color.Red
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
}

@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
//    validation: () -> Boolean,
) {
    var buttonClicked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            buttonClicked = true
            if (enabled) {
                onClick()
            }
        },
        enabled = enabled,
        modifier = Modifier
            .width(220.dp)
            .height(45.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.pale_green))
    ) {
        ButtonText(text = text)
    }
//    if (buttonClicked && !validation()) {
//        Text(text = errorText, color = Color.Red)
//    }
}

@Composable
fun ButtonText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.background_color),
        )
    )
}

@Composable
fun ClickableNavigationText(
    normalText: String,
    clickableText: String,
    navigateTo: String,
    navController: NavController
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        BasicText(text = normalText)
        Spacer(modifier = Modifier.width(5.dp))
        ClickableText(
            text = AnnotatedString(clickableText),
            onClick = {
                navController.navigate(navigateTo)
            },
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.pale_green)
            )
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RestrictedApi")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.HomeItems,
        BottomNavItem.ActivityItems,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute !in listOf(
            Screen.AuthRoute.route,
            Screen.SignInScreen.route, Screen.SignUpScreen.route)) {
        var selectedItem by rememberSaveable {
            mutableIntStateOf(0)
        }
        NavigationBar (
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
            containerColor = colorResource(id = R.color.white),
        ){
            items.forEachIndexed{ index, item ->
                NavigationBarItem(
                    selected = (selectedItem == index),
                    icon = { Icon(
                        painterResource(id = item.selectedIcon),
                        contentDescription = null
                    ) },
                    onClick = {
                        if (selectedItem != index){
                            if (navController.currentBackStack.value.size >= 2) {
                                navController.popBackStack()
                            }
                            selectedItem = index
                            navController.navigate(item.route){
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(id = R.color.selected_nav_icon),
                        indicatorColor = colorResource(id = R.color.white),
                        unselectedIconColor = colorResource(id = R.color.unselected_nav_icon),
                    )
                )
            }
        }
    }
}

@Composable
fun CustomImage(width: Int, height: Int, imageResourceID: Int) {
    Image(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
        ,
        painter = painterResource(id = imageResourceID),
        contentDescription = "Image"
    )
}

@Composable
fun CustomImageLogo(width: Int, height: Int, imageResourceID: Int, circleColor: Color) {
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .background(circleColor, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = imageResourceID),
            contentDescription = "Image"
        )
    }
}
