package id.fiqridhan.githubuser.domain.usecase.get_followers

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import id.fiqridhan.githubuser.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFollowersUseCaseImpl @Inject constructor(
    private val githubRepository: GithubRepository
) : GetFollowersUseCase {

    override suspend fun getFollowersByUserName(username: String): Flow<NetworkResult<List<GithubUser>>> {
        return githubRepository.getUserFollowers(username = username)
    }
}