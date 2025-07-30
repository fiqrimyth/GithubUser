package id.fiqridhan.githubuser.presentation.home

import id.fiqridhan.githubuser.domain.model.GithubUser

sealed interface HomeScreenUiState {
    data object Empty : HomeScreenUiState
    data object Loading : HomeScreenUiState
    data class Success(val data: GithubUser) : HomeScreenUiState
    data class Error(val error: String? = null) : HomeScreenUiState
}