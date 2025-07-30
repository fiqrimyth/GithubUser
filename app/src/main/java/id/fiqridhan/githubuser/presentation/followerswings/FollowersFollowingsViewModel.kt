package id.fiqridhan.githubuser.presentation.followerswings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.usecase.get_followers.GetFollowersUseCase
import id.fiqridhan.githubuser.domain.usecase.get_following.GetFollowingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowersFollowingsViewModel @Inject constructor(
    private val getFollowersUseCase: GetFollowersUseCase,
    private val getFollowingsUseCase: GetFollowingsUseCase
) : ViewModel() {

    private var _usersListState =
        MutableStateFlow<FollowersFollowingsUiState>(FollowersFollowingsUiState.Loading)
    val usersListState: StateFlow<FollowersFollowingsUiState> = _usersListState.asStateFlow()

    fun getFollowersFollowings(username: String, title: String) {
        viewModelScope.launch {
            (if (title == "followers") {
                getFollowersUseCase.getFollowersByUserName(username)
            } else {
                getFollowingsUseCase.getFollowingsByUserName(username)
            }).collect { result ->
                when (result) {
                    is NetworkResult.Error -> {
                        _usersListState.value = FollowersFollowingsUiState.Error(
                            error = result.message ?: "An unexpected error"
                        )
                    }

                    is NetworkResult.Exception -> {
                        _usersListState.value = FollowersFollowingsUiState.Error(
                            error = result.e.localizedMessage ?: "An unexpected error"
                        )
                    }

                    is NetworkResult.Success -> {
                        _usersListState.value = FollowersFollowingsUiState.Success(
                            data = result.data
                        )
                    }
                }
            }
        }
    }
}