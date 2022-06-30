package com.example.projectunion.presentation.screens.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectunion.R
import com.example.projectunion.common.Constants.ARGUMENT_USER_ID_KEY
import com.example.projectunion.common.Constants.MESSAGE_FIELD
import com.example.projectunion.common.Constants.TAG
import com.example.projectunion.domain.model.Response
import com.example.projectunion.presentation.navigation.MainNavRoute
import com.example.projectunion.presentation.screens.chat.components.ChatTopBar
import com.example.projectunion.presentation.screens.chat.components.MessageField
import com.example.projectunion.presentation.screens.chat.components.MessageItem

@Composable
fun ChatScreen(
	userId: String,
	userName: String,
	navController: NavController,
	viewModel: ChatViewModel = hiltViewModel()
) {
	val statePhoto = viewModel.statePhoto.observeAsState(null).value

	when(val state = viewModel.stateGet.observeAsState(Response.Success(false)).value) {
		is Response.Loading -> Log.d(TAG, "Loading")
		is Response.Success -> {
			Log.d(TAG, "Success get messages")
		}
		is Response.Error -> Log.d(TAG, state.message)
	}

	when(val state = viewModel.stateSend.observeAsState(Response.Success(false)).value) {
		is Response.Loading -> Log.d(TAG, "Loading")
		is Response.Success -> {
			if (state.data) {
				Log.d(TAG, "Success send message")
			}
		}
		is Response.Error -> Log.d(TAG, state.message)
	}

	Scaffold(
		topBar = {
			ChatTopBar(
				title = userName,
				photo = statePhoto,
				onClickBack = { navController.popBackStack() },
				onClickUser = {
					navController.navigate(
						MainNavRoute.Profile.route + "?${ARGUMENT_USER_ID_KEY}=${userId}"
					)
				}
			)
		},
		bottomBar = {
			MessageField(
				value = viewModel.message.text,
				onValueChange = {
					viewModel.message.text = it
				},
				placeholder = MESSAGE_FIELD,
				isPlaceholderVisible = viewModel.message.text.isEmpty(),
				onSend = {
					if (viewModel.message.text.isNotEmpty())
						viewModel.sendMessage()
				}
			)
		}
	) { innerPadding ->
		Box(
			modifier = Modifier.padding(innerPadding)
		) {
			LazyColumn(
				modifier = Modifier
					.fillMaxSize()
					.background(colorResource(id = R.color.app_background))
			) {
				item() {
					Spacer(modifier = Modifier.height(10.dp))
					MessageItem(
						message = "Hello",
						time = 1656530759224,
						locationArrangement = Arrangement.Start
					)
					Spacer(modifier = Modifier.height(10.dp))
				}
			}
		}
	}
}