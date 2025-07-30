package id.fiqridhan.githubuser.domain.usecase.get_following

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import kotlinx.coroutines.flow.Flow

interface GetFollowingsUseCase {
    suspend fun getFollowingsByUserName(username: String): Flow<NetworkResult<List<GithubUser>>>
}