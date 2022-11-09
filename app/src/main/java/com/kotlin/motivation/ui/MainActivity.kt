package com.kotlin.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.kotlin.motivation.infra.MotivationConstants
import com.kotlin.motivation.R
import com.kotlin.motivation.data.Mock
import com.kotlin.motivation.infra.SecurityPreferrences
import com.kotlin.motivation.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide navigation bar
        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        // Events
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmoticon.setOnClickListener(this)
        binding.imageLight.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        val listId = listOf(
            R.id.image_all,
            R.id.image_emoticon,
            R.id.image_light,
        )

        when (view.id) {
            in listId -> {
                handleFilter(view.id)
            }
            R.id.button_new_phrase -> {
                handleNextPhrase()
            }
            R.id.text_user_name -> {
                startActivity(Intent(this, UserActivity::class.java))
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun handleUserName() {
        val name = SecurityPreferrences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = returnName(name)
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmoticon.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageLight.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_emoticon -> {
                binding.imageEmoticon.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.EMOTICON
            }
            R.id.image_light -> {
                binding.imageLight.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.LIGHT
            }
        }
    }

    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId, Locale.getDefault().language)
    }

    private fun returnName(name: String): String {
        val hello = getString(R.string.hello_kotlin)
        return "$hello $name!"
    }
}