package ru.redmadrobot.digitalhackaton_2.data

internal object Endpoints {
    private const val API_V1 = "api/v1/"

    private const val AUTH = "auth/rest-auth/"
    const val AUTH_LOGIN = "$AUTH/login/"
    const val AUTH_LOGOUT = "$AUTH/logout/"

    private const val IDEAS = "ideas/"
    const val IDEAS_COMMENT = "$IDEAS/comment/"
    const val IDEAS_LIST = "$IDEAS/ideas/"
    const val IDEAS_CREATE = "$IDEAS/ideas/"


}
