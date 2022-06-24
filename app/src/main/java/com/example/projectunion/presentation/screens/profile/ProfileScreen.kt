package com.example.projectunion.presentation.screens.profile

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectunion.common.Constants.TAG
import com.example.projectunion.domain.model.Response
import com.example.projectunion.presentation.components.loader.Loader
import com.example.projectunion.presentation.screens.profile.components.ProfileTopBar

@Composable
fun ProfileScreen(
	navController: NavController,
	viewModel: ProfileViewModel = hiltViewModel()
) {
	when(val state = viewModel.state.observeAsState(Response.Success(false)).value) {
		is Response.Loading -> Loader()
		is Response.Success -> {

		}
		is Response.Error -> Log.d(TAG, state.message)
	}

	Scaffold(
		topBar = { ProfileTopBar(navController) },
	) {

	}
}