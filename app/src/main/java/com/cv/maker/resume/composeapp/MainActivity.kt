package com.cv.maker.resume.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            MaterialTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = true)
                    systemUiController.setNavigationBarColor(Color.Transparent, darkIcons = true)
                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Home(navController)
                    }
                    composable("stream") {
                        Stream(navController)
                    }
                    composable("basic") {
                        val painter = painterResource(id = R.drawable.img)
                        val description = "I'm checking app"
                        val title = "I'm checking app"
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(16.dp)
                        ) {
                            Basic(
                                navController,
                                painter = painter,
                                contentDescription = description,
                                title = title
                            )
                        }
                    }

                    composable("styling_text") {
                        TextStyling(navController)
                    }
                    composable("state") {
                        State(navController)
                    }
                    composable("fields_btns") {
                        FieldsButtonsEtc(navController)
                    }

                }
            }





        }
    }
}

