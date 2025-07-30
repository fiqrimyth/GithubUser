package id.fiqridhan.githubuser.presentation.followerswings

import id.fiqridhan.githubuser.domain.model.GithubUser

sealed interface FollowersFollowingsUiState {
    data object Loading : FollowersFollowingsUiState
    data class Success(val data: List<GithubUser>) : FollowersFollowingsUiState
    data class Error(val error: String? = null) : FollowersFollowingsUiState
}
