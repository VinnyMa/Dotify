package com.example.dotify

import android.app.Application
import com.example.dotify.model.User
import com.example.dotify.repository.DataRepository

class DotifyApplication: Application() {

    var user: User = User(
        username = "Pandaman",
        firstName = "Panda",
        lastName = "man",
        hasNose = true,
        platform = 8.5,
        profilePicURL = "https://raw.githubusercontent.com/VinnyMa/Dotify/hw3/app/src/main/res/drawable/pandaman.png"
    )

    lateinit var dataRepo: DataRepository

    override fun onCreate() {
        super.onCreate()

        dataRepo = DataRepository()
    }
}
