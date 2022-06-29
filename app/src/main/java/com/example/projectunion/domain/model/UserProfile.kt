package com.example.projectunion.domain.model

import java.util.*

data class UserProfile (
	var id: String? = null,
	var name: String? = null,
	var email: String? = null,
	var description: String = "",
	var photo: String? = null,
	var follows: List<String> = emptyList(),
	var followings: List<String> = emptyList(),
	var createdAt: Date? = null
)