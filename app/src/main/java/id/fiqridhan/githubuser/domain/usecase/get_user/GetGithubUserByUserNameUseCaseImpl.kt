package id.fiqridhan.githubuser.domain.usecase.get_user

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import id.fiqridhan.githubuser.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGithubUserByUserNameUseCaseImpl @Inject constructor(
    private val githubRepository: GithubRepository
) : GetGithubUserByUserNameUseCase {

    override suspend fun getGithubUserByUserName(username: String): Flow<NetworkResult<GithubUser>> {
        return githubRepository.getUser(username = username)
    }
}