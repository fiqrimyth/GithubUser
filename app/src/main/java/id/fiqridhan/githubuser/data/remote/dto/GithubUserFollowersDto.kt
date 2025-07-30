package id.fiqridhan.githubuser.data.remote.dto

class GithubUserFollowersDto : ArrayList<GithubUserDto>()

fun GithubUserFollowersDto.toGithubUserFollowers() = this.map {
    it.toGithubUser()
}