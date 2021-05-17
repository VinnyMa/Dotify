package com.example.dotify

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ericchee.songdataprovider.Song
import com.example.dotify.databinding.ActivityPlayerBinding
import com.example.dotify.databinding.ActivitySettingsBinding

private const val SONG_KEY = "song"

fun launchSettingsActivity(context: Context, song: Song, playCount: Int) = with(context){
    startActivity(Intent(this, SettingsActivity::class.java).apply {
        putExtra(SONG_KEY, song)
        putExtra("playCount", playCount)
    })
}

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private val navController by lazy { findNavController(R.id.navHost) }

    private val dotifyApp: DotifyApplication by lazy { application as DotifyApplication }
    private val dataRepo by lazy { dotifyApp.dataRepo }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Settings"
        binding = ActivitySettingsBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
//            val song = intent.extras?.getParcelable<Song>(SONG_KEY)

            navController.setGraph(R.navigation.nav_graph, intent.extras)

        }
//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp() = navController.navigateUp()
}