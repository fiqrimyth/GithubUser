package id.fiqridhan.githubuser.domain.repository

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun getUser(username: String): Flow<NetworkResult<GithubUser>>

    suspend fun getUserFollowers(username: String): Flow<NetworkResult<List<GithubUser>>>

    suspend fun getUserFollowing(username: String): Flow<NetworkResult<List<GithubUser>>>
}