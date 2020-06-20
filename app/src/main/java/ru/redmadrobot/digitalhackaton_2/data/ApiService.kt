package ru.redmadrobot.digitalhackaton_2.data

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Endpoints.AUTH_LOGIN)
    fun login(@Body usernameAndPassword: LoginRequest): Single<AuthToken>
}
