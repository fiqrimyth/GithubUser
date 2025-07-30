package id.fiqridhan.githubuser.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.fiqridhan.githubuser.common.Constants
import id.fiqridhan.githubuser.data.remote.GithubApi
import id.fiqridhan.githubuser.data.repository.GithubRepositoryImpl
import id.fiqridhan.githubuser.domain.repository.GithubRepository
import id.fiqridhan.githubuser.domain.usecase.get_followers.GetFollowersUseCase
import id.fiqridhan.githubuser.domain.usecase.get_followers.GetFollowersUseCaseImpl
import id.fiqridhan.githubuser.domain.usecase.get_following.GetFollowingsUseCase
import id.fiqridhan.githubuser.domain.usecase.get_following.GetFollowingsUseCaseImpl
import id.fiqridhan.githubuser.domain.usecase.get_user.GetGithubUserByUserNameUseCase
import id.fiqridhan.githubuser.domain.usecase.get_user.GetGithubUserByUserNameUseCaseImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class DataLayerModule {
        @Binds
        abstract fun bindGithubRepository(
            githubRepositoryImpl: GithubRepositoryImpl
        ): GithubRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class DomainLayerModule {
        @Binds
        abstract fun bindGetGithubUserByUserName(
            getGithubUserByUserNameUseCase: GetGithubUserByUserNameUseCaseImpl
        ): GetGithubUserByUserNameUseCase

        @Binds
        abstract fun bindGetFollowersUseCase(
            getFollowersUseCase: GetFollowersUseCaseImpl
        ): GetFollowersUseCase

        @Binds
        abstract fun bindGetFollowingsUseCase(
            getFollowingsUseCase: GetFollowingsUseCaseImpl
        ): GetFollowingsUseCase
    }
}