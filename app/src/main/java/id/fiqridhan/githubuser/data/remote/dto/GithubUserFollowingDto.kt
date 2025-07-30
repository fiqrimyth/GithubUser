package id.fiqridhan.githubuser.data.remote.dto

class GithubUserFollowingDto : ArrayList<GithubUserDto>()

fun GithubUserFollowingDto.toGithubUserFollowings() = this.map { it.toGithubUser() }