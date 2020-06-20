package ru.redmadrobot.digitalhackaton_2.data

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.redmadrobot.digitalhackaton_2.ideas.list.data.IdeaOffer

interface ApiService {
    @POST(Endpoints.AUTH_LOGIN)
    fun login(@Body usernameAndPassword: LoginRequest): Single<AuthToken>

    @GET(Endpoints.IDEAS_LIST)
    fun allIdeas(): Single<ResponseWithResult<IdeaOffer>>
}
