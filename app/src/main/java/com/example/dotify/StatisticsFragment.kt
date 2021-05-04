package com.example.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.dotify.databinding.FragmentAboutBinding
import com.example.dotify.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {
    private val safeArgs: StatisticsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStatisticsBinding.inflate(inflater)
        with(binding) {
            val song = safeArgs.song

            tvPlayCount.text = "Play count: ${safeArgs.playCount.toString()}"
            ivAlbumCover.setImageResource(song.largeImageID)
        }
        return binding.root
    }
}