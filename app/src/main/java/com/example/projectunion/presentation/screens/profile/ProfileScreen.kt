package com.example.projectunion.presentation.screens.profile

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectunion.R
import com.example.projectunion.common.Constants.ARGUMENT_PROJECT_ID_KEY
import com.example.projectunion.common.Constants.ARGUMENT_PROJECT_PRICE_KEY
import com.example.projectunion.common.Constants.ARGUMENT_USER_ID_KEY
import com.example.projectunion.common.Constants.ERROR_BY_GET_PROFILE
import com.example.projectunion.common.Constants.ERROR_BY_GET_PROJECTS
import com.example.projectunion.common.Constants.TAG
import com.example.projectunion.common.Constants.TITLE_NO_PROJECTS
import com.example.projectunion.domain.model.Response
import com.example.projectunion.presentation.components.error.Error
import com.example.projectunion.presentation.screens.home.components.ShimmerLoaderProjects
import com.example.projectunion.presentation.navigation.MainNavRoute
import com.example.projectunion.presentation.screens.home.components.ProjectItem
import com.example.projectunion.presentation.screens.profile.components.ProfileInformation
import com.example.projectunion.presentation.screens.profile.components.ProfileTopBar
import com.example.projectunion.presentation.screens.profile.components.ShimmerLoaderProfile

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
	userID: String,
	navController: NavController,
	viewModel: ProfileViewModel = hiltViewModel()
) {
	val stateProfile = viewModel.stateProfile.observeAsState(Response.Success(null)).value
	val stateProjects = viewModel.stateProjects.observeAsState(Response.Success(emptyList())).value
	val statePhoto = viewModel.statePhoto.observeAsState(Response.Success(null)).value
	val photoProfile = viewModel.photoProfile.observeAsState(null).value

	var countProjects = 0
	val listState = rememberLazyListState()

	Scaffold(
		topBar = { ProfileTopBar(navController) }
	) {
		LazyColumn(
			state = listState,
			modifier = Modifier
				.fillMaxSize()
				.background(colorResource(id = R.color.background_tape))
		) {
			item() {
				when(stateProfile) {
					is Response.Loading -> ShimmerLoaderProfile()
					is Response.Error -> {
						Log.d(TAG, stateProfile.message)
						Box(
							modifier = Modifier.height(250.dp)
						) {
							Error(message = ERROR_BY_GET_PROFILE) {
								viewModel.getProfileData(userID)
							}
						}
					}
					is Response.Success -> {
						stateProfile.data?.let { user ->
							ProfileInformation(
								user = user,
								photoProfile = photoProfile,
								statePhoto = statePhoto,
								countProjects = countProjects,
								navController = navController,
								onChangePhoto = { uri ->
									viewModel.updatePhoto(uri)
								}
							)
						}
					}
				}
			}
			item() {
				Spacer(modifier = Modifier.height(5.dp))
			}

			when(stateProjects) {
				is Response.Loading -> {
					item {
						ShimmerLoaderProjects()
					}
				}
				is Response.Error -> {
					Log.d(TAG, stateProjects.message)
					item {
						Box(
							modifier = Modifier.padding(top = 50.dp)
						) {
							Error(
								message = ERROR_BY_GET_PROJECTS,
								background = colorResource(id = R.color.background_tape)
							) {
								viewModel.getProjects(userID)
							}
						}
					}
				}
				is Response.Success -> {
					countProjects = stateProjects.data.size

					if (stateProjects.data.isEmpty()) {
						item() {
							Column(
								modifier = Modifier.fillMaxSize(),
								horizontalAlignment = Alignment.CenterHorizontally
							) {
								Text(
									modifier = Modifier.padding(top = 50.dp),
									text = TITLE_NO_PROJECTS,
									style = MaterialTheme.typography.body2
								)
							}
						}
					}
					else {
						items(stateProjects.data) { project ->
							ProjectItem(
								project = project,
								openProfile = {
									navController.navigate(
										MainNavRoute.Profile.route + "?${ARGUMENT_USER_ID_KEY}=${project.creatorID}"
									)
								},
								openProject = {
									navController.navigate(
										MainNavRoute.Project.route
												+ "?${ARGUMENT_PROJECT_ID_KEY}=${project.id}"
												+ "&${ARGUMENT_PROJECT_PRICE_KEY}=${project.price}"
												+ "&$ARGUMENT_USER_ID_KEY=${project.creatorID}"
									)
								}
							)
						}
					}
				}
			}
		}
	}
}