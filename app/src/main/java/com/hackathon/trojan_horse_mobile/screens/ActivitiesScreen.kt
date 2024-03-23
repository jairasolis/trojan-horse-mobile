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
fun ActivitiesScreen(navController: NavHostController) {
    // List of activity titles
    val activityTitles = listOf(
        "P2 Group Activity",
        "Create Portfolio",
        "Github Repository",
        "Answer the Following Questions:",
        "Activity 5 Title",
        "Activity 6 Title",
        "Activity 7 Title",
        "Activity 8 Title",
        "Activity 9 Title",
        "Activity 10 Title"
    )

    // List of activity instructions
    val activityInstructions = listOf(
        "Research and Development (one-to-one relationship)",
        "1. Create your portfolio (Make it simple and creative).\n" +
                "2. Upload it to Github and make it a live website\n" +
                "3. Make sure to have the link and attach it. (Not in the comment).",
        "1. Create a Google Doc, and make sure to make it public access.\n" +
                "2. Inside the Google Docs, add the ff:\n" +
                "- Github Repository for API\n" +
                "- Github Repository for Website\n" +
                "- Github Repository for Mobile\n" +
                "3. Upload the Google Docs here in our GCR.",
        "As a student during the martial law period, what strategies would you have employed to continue learning and pursuing education despite the restrictions and censorship imposed by the government?As a student during the martial law period, what actions would you have taken to ensure the protection and safety of your fellow students who were targeted for their activism or dissent?",
        "For Lesson 25 and 26, Just Do PRACTICE EXERCISE.\n" +
                "Ensure that your work meets the following quality requirements:\n" +
                "\n" +
                "   a. Provide clear and bright images of your completed activities. Avoid any blurriness or low lighting that may hinder visibility.",
        "For Lesson 21 AND 22, Just PRACTICE EXERCISE\n" +
                "Ensure that your work meets the following quality requirements:\n" +
                "\n" +
                "   a. Provide clear and bright images of your completed activities. Avoid any blurriness or low lighting that may hinder visibility.",
        "Activity 7 Instructions",
        "Activity 8 Instructions",
        "Activity 9 Instructions",
        "Activity 10 Instructions"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.bg)
    ) {
        Column {
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                // Pass the lists of activity titles and instructions to ActivitiesBox
                ActivitiesBox(activityTitles = activityTitles, activityInstructions = activityInstructions)
            }
        }
    }
}
@Composable
fun ActsPrev() {
    ActivitiesScreen(navController = rememberNavController())
}