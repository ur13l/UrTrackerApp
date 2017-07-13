package com.projects.uriel.urtrackerapp.api

import com.projects.uriel.urtrackerapp.model.User
import retrofit2.Call
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
    ) : Call<Response<User>>

    @POST("user/register")
    fun register(
            @Query("email") email : String,
            @Query("password") password : String,
            @Query("name") name : String
    ) : Call<Response<User>>
}