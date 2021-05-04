package com.example.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.databinding.ActivitySongListBinding

private const val SONG_KEY = "song"

class SongListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongListBinding
    private var clickedSong: Song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root) }
        title = "All Songs"
        val songs = SongDataProvider.getAllSongs()

        with(binding) {
            val adapter = SongListAdapter(songs)
            rvListOfSongs.adapter = adapter

            if(savedInstanceState != null) {
                clickedSong = savedInstanceState.getParcelable<Song>(SONG_KEY)
                val song = clickedSong
                if (song != null) {
                    clMiniPlayer.visibility = View.VISIBLE
                    tvMiniSongTitle.text = root.context.getString(R.string.miniplayer_song, song.title, song.artist)
                }
            }

            adapter.onSongClickListener = { song ->
                clickedSong = song
                clMiniPlayer.visibility = View.VISIBLE
                tvMiniSongTitle.text = root.context.getString(R.string.miniplayer_song, song.title, song.artist)
            }

            clMiniPlayer.setOnClickListener {
                val song = clickedSong
                if (song != null) {
                    navigateToPlayerActivity(this@SongListActivity, song)
                }
            }

            btnShuffle.setOnClickListener {
                adapter.updateSongs(songs.toMutableList().shuffled())
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(SONG_KEY, clickedSong)
        super.onSaveInstanceState(outState)
    }
}