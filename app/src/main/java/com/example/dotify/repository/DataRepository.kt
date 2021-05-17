package com.example.dotify.repository


import com.example.dotify.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * https://raw.githubusercontent.com/echeeUW/codesnippets/master/user_info.json
 */

class DataRepository {

    private val userData = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserData::class.java)

    suspend fun getUser(): User = userData.getUser()

    }


interface UserData {
    @GET("echeeUW/codesnippets/master/user_info.json")
    suspend fun getUser(): User
}

