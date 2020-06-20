package ru.redmadrobot.digitalhackaton_2.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.redmadrobot.digitalhackaton_2.App

object ApiClient {
    private const val BASE_URL = "https://breathtaking.herokuapp.com/"

    private val retrofit: Retrofit by lazy(LazyThreadSafetyMode.NONE) {
        val okHttpClient = createOkHttpClient()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                App.authToken?.let { token ->
                    val requestWithToken = request.newBuilder()
                        .addHeader("Authorization", "Token ${token.value}")
                        .build()
                    return@addInterceptor chain.proceed(requestWithToken)
                }
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun createService(): ApiService = retrofit.create(ApiService::class.java)
}
