package com.example.projectunion.data.authentication

import com.example.projectunion.domain.model.Response
import com.example.projectunion.domain.model.UserLogin
import com.example.projectunion.domain.model.UserRegister
import kotlinx.coroutines.flow.Flow

interface Authentication {

	fun authorized(): Boolean
	fun loginByEmail(userData: UserLogin): Flow<Response<Boolean>>
	fun registerByEmail(userData: UserRegister): Flow<Response<Boolean>>
	fun logout(): Flow<Response<Boolean>>
}