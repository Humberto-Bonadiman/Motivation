package com.kotlin.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.motivation.infra.MotivationConstants
import com.kotlin.motivation.R
import com.kotlin.motivation.infra.SecurityPreferrences
import com.kotlin.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val id: Int? = view?.id
        if (id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name.length > 3) {
            SecurityPreferrences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            finish()
        } else {
            Toast.makeText(this, getString(R.string.validation_mandatory_name), Toast.LENGTH_SHORT)
                .show()
        }
    }
}