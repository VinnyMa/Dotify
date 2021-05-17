package com.example.dotify

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.dotify.databinding.FragmentProfileBinding
import com.example.dotify.repository.DataRepository
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var dotifyApp: DotifyApplication
    private lateinit var dataRepo: DataRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)

        dotifyApp = context.applicationContext as DotifyApplication
        dataRepo = dotifyApp.dataRepo
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        with(binding) {
            btnRefresh.setOnClickListener {
                lifecycleScope.launch {
                    runCatching {
                        Toast.makeText(activity, "loading...", Toast.LENGTH_SHORT).show()

                        dotifyApp.user = dataRepo.getUser()
                        tvName.text = dotifyApp.user.username
                        loadImage()

                    }.onFailure { Toast.makeText(activity, "Error in fetching User Data", Toast.LENGTH_SHORT).show() }
                }
            }
        }
        return binding.root
    }

    private fun loadImage() {
        with(binding) {
            ivProfilePic.load(dotifyApp.user.profilePicURL)
        }
    }

}