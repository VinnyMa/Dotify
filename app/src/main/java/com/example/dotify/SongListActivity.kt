package com.example.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.databinding.ActivitySongListBinding

class SongListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root) }
        this.title = "All Songs"
        val songs = SongDataProvider.getAllSongs()

        with(binding) {
            val adapter = SongListAdapter(songs)
            rvListOfSongs.adapter = adapter

            adapter.onSongClickListener = { song ->
                clMiniPlayer.visibility = View.VISIBLE
                tvMiniSongTitle.text = root.context.getString(R.string.miniplayer_song, song.title, song.artist)
                clMiniPlayer.setOnClickListener{
                    navigateToPlayerActivity(this@SongListActivity, song)
                }
            }

            btnShuffle.setOnClickListener {
                adapter.updateSongs(songs.toMutableList().shuffled())
            }


        }
    }
}