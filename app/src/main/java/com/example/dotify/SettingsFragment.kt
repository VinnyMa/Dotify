package com.example.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dotify.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private val safeArgs: SettingsFragmentArgs by navArgs()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(inflater)
        val receivedSong = safeArgs.song
        val playCount = safeArgs.playCount

        with(binding) {
            btnProfile.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalProfileFragment())
            }
            btnAbout.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalAboutFragment())
            }
            btnProfileStats.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalStatisticsFragment(receivedSong, playCount))
            }
        }

        return binding.root
    }
}