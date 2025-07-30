package id.fiqridhan.githubuser.domain.usecase.get_following

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.domain.model.GithubUser
import id.fiqridhan.githubuser.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFollowingsUseCaseImpl @Inject constructor(
    private val githubRepository: GithubRepository
) : GetFollowingsUseCase {
    override suspend fun getFollowingsByUserName(username: String): Flow<NetworkResult<List<GithubUser>>> {
        return githubRepository.getUserFollowing(username = username)
    }
}