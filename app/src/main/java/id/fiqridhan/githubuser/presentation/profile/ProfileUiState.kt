package id.fiqridhan.githubuser.presentation.profile

import id.fiqridhan.githubuser.domain.model.GithubUser

data class ProfileUiState(
    val isLoading: Boolean = false,
    val data: GithubUser? = null,
    val error: Boolean = false,
    val searchString: String = ""
)