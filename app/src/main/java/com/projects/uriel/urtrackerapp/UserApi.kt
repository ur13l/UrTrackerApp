package com.projects.uriel.urtrackerapp

import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by uriel on 11/07/17.
 */
interface UserApi {

    @POST("user/login")
    fun login(
            @Query("email") email : String,
            @Query("password") password : String
    )
}