package com.example.projectunion.presentation.screens.profile.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainDataUser(
	name: String?,
	description: String?
) {
	name?.let { name ->
		Text(
			text = name,
			style = MaterialTheme.typography.h6
		)
	}

	description?.let { description ->
		Spacer(modifier = Modifier.height(5.dp))
		Text(
			text = description,
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 30.dp),
			textAlign = TextAlign.Center,
			style = MaterialTheme.typography.body2
		)
	}
}