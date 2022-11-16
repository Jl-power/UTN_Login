package com.example.utn_login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.utn_login.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            isEmpty()
        }
    }

    private fun isUser() {

        val preferences: SharedPreferences = getSharedPreferences(
            "my_preferences", MODE_PRIVATE
        )

        if(binding.inputUser.text.toString() !=
            preferences.getString("user",resources.getString(R.string.data_user))
            && binding.inputUser.text.toString().isNotEmpty())
            Snackbar.make(binding.inputUser,resources.getString(R.string.error_message_user),
                BaseTransientBottomBar.LENGTH_SHORT).apply {
                view.background = resources.getDrawable(R.drawable.round_corner, null)
            }.show()

        if(binding.inputPass.text.toString() != preferences.getString(
                "password",resources.getString(R.string.data_pass))
            && binding.inputPass.text.toString().isNotEmpty())
            Snackbar.make(binding.inputPass,resources.getString(R.string.error_message_pass),
                BaseTransientBottomBar.LENGTH_SHORT).apply {
                view.background = resources.getDrawable(R.drawable.round_corner, null)
            }.show()

        if ((binding.inputUser.text.toString() == preferences.getString(
                "user",resources.getString(R.string.data_user)))
            && (binding.inputPass.text.toString() == preferences.getString(
                "password",resources.getString(R.string.data_pass)))){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun isEmpty(){

        if((TextUtils.isEmpty(binding.inputUser.text.toString())) ||
                TextUtils.isEmpty((binding.inputPass.text.toString())))
            Snackbar.make(binding.inputUser,resources.getString(R.string.error_empty),
                BaseTransientBottomBar.LENGTH_SHORT).apply {
                view.background = resources.getDrawable(R.drawable.round_corner, null)
            }.show()

        if (!(TextUtils.isEmpty(binding.inputUser.text.toString())) &&
            !TextUtils.isEmpty(binding.inputPass.text.toString())){ isUser()}
    }

}