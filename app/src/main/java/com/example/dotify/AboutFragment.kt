package com.example.dotify

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dotify.databinding.FragmentAboutBinding
import com.example.dotify.databinding.FragmentProfileBinding

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater)
        binding.tvVersionNum.text = "Version: ${BuildConfig.VERSION_NAME}"

        return binding.root
    }
}