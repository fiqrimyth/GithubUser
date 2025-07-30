package id.fiqridhan.githubuser.domain.usecase.get_user

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import kotlinx.coroutines.flow.Flow

interface GetGithubUserByUserNameUseCase {
    suspend fun getGithubUserByUserName(username: String): Flow<NetworkResult<GithubUser>>
}