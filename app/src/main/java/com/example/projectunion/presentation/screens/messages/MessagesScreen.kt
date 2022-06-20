package com.example.projectunion.presentation.screens.messages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectunion.R
import com.example.projectunion.common.Constants.MESSAGES_SCREEN
import com.example.projectunion.presentation.components.top_bar.TopBar

@Composable
fun MessagesScreen() {
	Scaffold(
		topBar = { TopBar(MESSAGES_SCREEN) },
	) {
		Search()
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(top = 170.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "Пока нет диалогов",
				style = TextStyle(
					color = Color.Gray,
					fontSize = 15.sp
				)
			)
		}
	}
}

@Composable
fun Search() {
	val searchText = remember {
		mutableStateOf("")
	}

	TextField(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight(align = Alignment.CenterVertically)
			.height(65.dp)
			.padding(horizontal = 10.dp, vertical = 5.dp),
		value = searchText.value,
		onValueChange = {value -> searchText.value = value},
		placeholder = { Text(stringResource(id = R.string.search_field)) },
		singleLine = true,
		leadingIcon = { Icon(
			imageVector = Icons.Default.Search,
			contentDescription = "Search chat")
		},
		textStyle = TextStyle(fontSize = 16.sp),
		shape = RoundedCornerShape(10.dp),
		colors = TextFieldDefaults.textFieldColors(
			textColor = Color.Gray,
			disabledTextColor = Color.Transparent,
			backgroundColor = colorResource(id = R.color.app_background),
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent
		)
	)
}