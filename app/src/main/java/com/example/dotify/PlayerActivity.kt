package com.example.dotify

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import com.ericchee.songdataprovider.Song
import com.example.dotify.databinding.ActivityPlayerBinding
import kotlin.random.Random

private const val COUNT_VALUE_KEY = "COUNT_VALUE_KEY"

fun navigateToPlayerActivity(context: Context, song: Song) {
    val intent = Intent(context, PlayerActivity::class.java)
    val bundle = Bundle()

    bundle.putParcelable("song", song)

    intent.putExtras(bundle)

    context.startActivity(intent)
}

class PlayerActivity : AppCompatActivity() {
    private var playCount = Random.nextInt(0, 1000)
    private lateinit var binding: ActivityPlayerBinding
    private lateinit var tvPlayCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            val song: Song? = intent.getParcelableExtra<Song>("song")
            tvSongTitle.text = song?.title
            tvArtist.text = song?.artist
            if(savedInstanceState != null) {
                playCount = savedInstanceState.getInt(COUNT_VALUE_KEY)
            }
            if (song != null) {
                ivAlbumCover.setImageResource(song.largeImageID)
            }
            btnSettings.setOnClickListener {
                if (song != null) {
                    launchSettingsActivity(this@PlayerActivity, song, playCount)
                }
            }
            btnPlay.setOnClickListener{
                playCount++
                tvPlayCount.text = "${playCount.toString()} plays"
            }
            btnNext.setOnClickListener { Toast.makeText(this@PlayerActivity, "Skipping to next track", Toast.LENGTH_SHORT).show() }
            btnPrevious.setOnClickListener { Toast.makeText(this@PlayerActivity, "Skipping to previous track", Toast.LENGTH_SHORT).show() }
        }
        tvPlayCount = findViewById(R.id.tvPlayCount)
        tvPlayCount.text = "${playCount.toString()} plays"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_VALUE_KEY, playCount)
        super.onSaveInstanceState(outState)
    }

}