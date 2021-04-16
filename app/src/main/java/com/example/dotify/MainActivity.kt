package com.example.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var playCount = Random.nextInt(0, 1000)
    private lateinit var tvPlayCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvPlayCount = findViewById(R.id.tvPlayCount)
        tvPlayCount.text = "${playCount.toString()} plays"

    }

    fun playClick(view: View) {
        playCount++
        tvPlayCount.text = "${playCount.toString()} plays"

    }

    fun prevClick(view: View) {
        Toast.makeText(this, "Skipping to previous track", Toast.LENGTH_SHORT).show()
    }

    fun nextClick(view: View) {
        Toast.makeText(this, "Skipping to next track", Toast.LENGTH_SHORT).show()
    }

    fun changeUser(view: View) {
        var btnChangeUser = findViewById<Button>(R.id.btnChangeUser)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val etUsername = findViewById<EditText>(R.id.etUsername)

        if (btnChangeUser.text == "Change User") {
            btnChangeUser.text = "Apply"
            tvUsername.visibility = View.INVISIBLE
            etUsername.visibility = View.VISIBLE

        } else {
            val newUsername = etUsername.text.toString()
            if (newUsername.trim().isNotEmpty()) {
                btnChangeUser.text = "Change User"
                tvUsername.text = etUsername.text
                tvUsername.visibility = View.VISIBLE
                etUsername.visibility = View.INVISIBLE
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
            }
        }
    }

}