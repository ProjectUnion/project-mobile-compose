package com.example.novalinea.presentation.components.search_field

import com.example.novalinea.common.Constants.FIELD_INVALID
import com.example.novalinea.presentation.components.fields_state.TextFieldState

class SearchState: TextFieldState(
	validator = ::searchValid,
	errorMessage = ::searchErrorMessage
) {
}

private fun searchValid(search: String) = search.isNotEmpty()

private fun searchErrorMessage() = FIELD_INVALID