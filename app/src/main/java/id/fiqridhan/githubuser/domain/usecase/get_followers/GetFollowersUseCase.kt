package id.fiqridhan.githubuser.domain.usecase.get_followers

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import kotlinx.coroutines.flow.Flow

interface GetFollowersUseCase {
    suspend fun getFollowersByUserName(username: String): Flow<NetworkResult<List<GithubUser>>>
}