package id.fiqridhan.githubuser.data.repository

import id.fiqridhan.githubuser.common.NetworkResult
import id.fiqridhan.githubuser.data.remote.GithubApi
import id.fiqridhan.githubuser.data.remote.dto.toGithubUser
import id.fiqridhan.githubuser.data.remote.dto.toGithubUserFollowers
import id.fiqridhan.githubuser.data.remote.dto.toGithubUserFollowings
import id.fiqridhan.githubuser.di.IoDispatcher
import id.fiqridhan.githubuser.domain.model.GithubUser
import id.fiqridhan.githubuser.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GithubRepository {

    override suspend fun getUser(username: String): Flow<NetworkResult<GithubUser>> = flow {
        try {
            val response = githubApi.getGithubUser(username)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                emit(NetworkResult.Success(body.toGithubUser()))
            } else {
                emit(NetworkResult.Error(code = response.code(), message = response.message()))
            }
        } catch (e: HttpException) {
            emit(NetworkResult.Error(code = e.code(), message = e.message()))
        } catch (e: Throwable) {
            emit(NetworkResult.Exception(e))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getUserFollowers(username: String): Flow<NetworkResult<List<GithubUser>>> =
        flow {
            try {
                val response = githubApi.getGithubUserFollowers(username)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    emit(NetworkResult.Success(body.toGithubUserFollowers()))
                } else {
                    emit(NetworkResult.Error(code = response.code(), message = response.message()))
                }
            } catch (e: HttpException) {
                emit(NetworkResult.Error(code = e.code(), message = e.message()))
            } catch (e: Throwable) {
                emit(NetworkResult.Exception(e))
            }
        }.flowOn(ioDispatcher)

    override suspend fun getUserFollowing(username: String): Flow<NetworkResult<List<GithubUser>>> =
        flow {
            try {
                val response = githubApi.getGithubUserFollowings(username)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    emit(NetworkResult.Success(body.toGithubUserFollowings()))
                } else {
                    emit(NetworkResult.Error(code = response.code(), message = response.message()))
                }
            } catch (e: HttpException) {
                emit(NetworkResult.Error(code = e.code(), message = e.message()))
            } catch (e: Throwable) {
                emit(NetworkResult.Exception(e))
            }
        }.flowOn(ioDispatcher)
}
