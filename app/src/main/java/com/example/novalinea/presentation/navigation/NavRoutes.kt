package com.example.novalinea.presentation.navigation

import com.example.novalinea.R
import com.example.novalinea.common.Constants.ABOUT_APP_SCREEN
import com.example.novalinea.common.Constants.ABOUT_APP_SCREEN_ROUTE
import com.example.novalinea.common.Constants.CHAT_SCREEN_ROUTE
import com.example.novalinea.common.Constants.CREATE_SCREEN_ROUTE
import com.example.novalinea.common.Constants.EDIT_PROFILE_SCREEN
import com.example.novalinea.common.Constants.EDIT_PROFILE_SCREEN_ROUTE
import com.example.novalinea.common.Constants.HOME_SCREEN
import com.example.novalinea.common.Constants.HOME_SCREEN_ROUTE
import com.example.novalinea.common.Constants.LOGIN_SCREEN
import com.example.novalinea.common.Constants.LOGIN_SCREEN_ROUTE
import com.example.novalinea.common.Constants.MESSAGES_SCREEN
import com.example.novalinea.common.Constants.MESSAGES_SCREEN_ROUTE
import com.example.novalinea.common.Constants.PROFILE_SCREEN_ROUTE
import com.example.novalinea.common.Constants.PROJECT_SCREEN_ROUTE
import com.example.novalinea.common.Constants.REGISTER_SCREEN
import com.example.novalinea.common.Constants.REGISTER_SCREEN_ROUTE
import com.example.novalinea.common.Constants.THEMES_SCREEN
import com.example.novalinea.common.Constants.THEMES_SCREEN_ROUTE
import com.example.novalinea.common.Constants.VERIFY_EMAIL_SCREEN
import com.example.novalinea.common.Constants.VERIFY_EMAIL_SCREEN_ROUTE
import com.example.novalinea.common.Constants.VIEWING_PHOTO_SCREEN_ROUTE

sealed class BottomNavRoute(val route: String, val title: String, val icon_default: Int, val icon_selected: Int) {
	object Home: BottomNavRoute(HOME_SCREEN_ROUTE, HOME_SCREEN, R.drawable.ic_home_outline, R.drawable.ic_home_fill)
	object Messages: BottomNavRoute(MESSAGES_SCREEN_ROUTE, MESSAGES_SCREEN, R.drawable.ic_messages_outline, R.drawable.ic_messages_fill)
	object Profile: BottomNavRoute(PROFILE_SCREEN_ROUTE, PROFILE_SCREEN_ROUTE, R.drawable.ic_person_outline, R.drawable.ic_person_fill)
}

sealed class HomeNavRoute(val route: String, val title: String) {
	object Project: HomeNavRoute(PROJECT_SCREEN_ROUTE, PROJECT_SCREEN_ROUTE)
	object Create: HomeNavRoute(CREATE_SCREEN_ROUTE, CREATE_SCREEN_ROUTE)
}

sealed class MessagesNavRoute(val route: String, val title: String) {
	object Chat: MessagesNavRoute(CHAT_SCREEN_ROUTE, CHAT_SCREEN_ROUTE)
}

sealed class ProfileNavRoute(val route: String, val title: String) {
	object ViewingPhoto: ProfileNavRoute(VIEWING_PHOTO_SCREEN_ROUTE, VIEWING_PHOTO_SCREEN_ROUTE)
	object EditProfile: ProfileNavRoute(EDIT_PROFILE_SCREEN_ROUTE, EDIT_PROFILE_SCREEN)
	object Themes: ProfileNavRoute(THEMES_SCREEN_ROUTE, THEMES_SCREEN)
	object AboutApp: ProfileNavRoute(ABOUT_APP_SCREEN_ROUTE, ABOUT_APP_SCREEN)
}

sealed class AuthNavRoute(val route: String, val title: String) {
	object Login: AuthNavRoute(LOGIN_SCREEN_ROUTE, LOGIN_SCREEN)
	object Register: AuthNavRoute(REGISTER_SCREEN_ROUTE, REGISTER_SCREEN)
	object VerifyEmail: AuthNavRoute(VERIFY_EMAIL_SCREEN, VERIFY_EMAIL_SCREEN_ROUTE)
}