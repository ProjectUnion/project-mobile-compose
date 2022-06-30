package com.example.projectunion.presentation.screens.profile.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectunion.common.Constants.ARGUMENT_USER_DESCRIPTION_KEY
import com.example.projectunion.common.Constants.ARGUMENT_USER_ID_KEY
import com.example.projectunion.common.Constants.ARGUMENT_USER_NAME_KEY
import com.example.projectunion.common.Constants.AUTHENTICATION_ROUTE
import com.example.projectunion.common.Constants.USER
import com.example.projectunion.domain.model.Response
import com.example.projectunion.domain.model.UserProfile
import com.example.projectunion.presentation.navigation.MainNavRoute

@Composable
fun ProfileInformation(
	user: UserProfile,
	photoProfile: String?,
	statePhoto: Response<String?>,
	countProjects: Int,
	navController: NavController,
	onChangePhoto: (Uri) -> Unit,
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(Color.White),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		user.id?.let { id ->
			AvatarUser(
				id = id,
				photo = photoProfile,
				statePhoto = statePhoto,
				onChangePhoto = onChangePhoto
			)
		}

		MainDataUser(
			name = user.name,
			description = user.description
		)

		Spacer(modifier = Modifier.height(15.dp))
		ParamsUser(
			countProjects = countProjects,
			follows = user.follows.size,
			followings = user.followings.size)

		Spacer(modifier = Modifier.height(15.dp))
		user.id?.let { id ->
			ActionsUser(
				id = id,
				onClick = {
					when(USER.id) {
						id -> {
							navController.popBackStack()
							navController.navigate(
								MainNavRoute.EditProfile.route
										+ "?${ARGUMENT_USER_ID_KEY}=${id}"
										+ "&${ARGUMENT_USER_NAME_KEY}=${user.name}"
										+ "&${ARGUMENT_USER_DESCRIPTION_KEY}=${user.description}"
							)
						}
						null -> navController.navigate(AUTHENTICATION_ROUTE)
						else -> {
							navController.navigate(
								MainNavRoute.Chat.route
										+ "?${ARGUMENT_USER_ID_KEY}=${id}"
										+ "&${ARGUMENT_USER_NAME_KEY}=${user.name}"
							)
						}
					}
				}
			)
		}

		Spacer(modifier = Modifier.height(15.dp))
	}
}