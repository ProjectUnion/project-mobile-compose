package com.example.projectunion.presentation.components.top_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectunion.presentation.navigation.Router

@Composable
fun TopBar(
    title: String,
    externalRouter: Router
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                Alignment.Center
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp
                    )
                )
            }
        },
        /*navigationIcon = {
            IconButton(
                onClick = {
                    if (isAuth)
                        externalRouter.navigateTo(MainNavRoute.Profile.route)
                    else
                        externalRouter.navigateTo(AUTHENTICATION_ROUTE)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person icon",
                    tint = Color.Black
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    externalRouter.navigateTo(MainNavRoute.Notifications.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications icon",
                    tint = Color.Black
                )
            }
            IconButton(
                onClick = {
                    externalRouter.navigateTo(MainNavRoute.Search.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon",
                    tint = Color.Black
                )
            }
        },*/
        backgroundColor = Color.White,
        elevation = 1.dp
    )
}