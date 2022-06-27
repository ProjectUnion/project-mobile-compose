package com.example.projectunion.presentation.screens.project.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projectunion.presentation.components.image_painter.ImagePainter

@Composable
fun SliderImagesProject(
	images: List<String>
) {
	if (images.isNotEmpty()) {
		Box(
			modifier = Modifier
				.height(250.dp)
				.fillMaxWidth(),
			contentAlignment = Alignment.Center,
		) {
			ImagePainter(
				imageUrl = images[0],
				onClick = {}
			)
		}
	}
}