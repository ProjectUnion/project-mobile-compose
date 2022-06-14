package com.example.projectunion.data.repository

import com.example.projectunion.domain.model.Response.*
import com.example.projectunion.domain.model.UserLogin
import com.example.projectunion.domain.model.UserRegister
import com.example.projectunion.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
	private val auth: FirebaseAuth
) : AuthRepository {

	override fun authorized(id: String): Boolean {
		return true
	}

	override fun loginByEmail(userData: UserLogin) = flow {
		try {
			emit(Loading)
			auth.signInWithEmailAndPassword(userData.email, userData.password)
			emit(Success(true))
		} catch (e: Exception) {
			emit(Error(e.message ?: e.toString()))
		}
	}

	override fun registerByEmail(userData: UserRegister): Boolean {
		return true
	}

}