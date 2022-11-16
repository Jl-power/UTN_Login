package com.example.utn_login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.utn_login.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottieAnim.animate()
            .translationY(-2500f)
            .setDuration(1000)
            .setStartDelay(4000)

        Handler(Looper.getMainLooper()).postDelayed({
            val preferences : SharedPreferences = getSharedPreferences(
                "my_preferences", MODE_PRIVATE)

            if(preferences.getString("user",resources.getString(R.string.data_user))?.isEmpty() == true){
                preferences.edit().apply() {
                    putString("user", resources.getString(R.string.data_user))
                    putString("password", resources.getString(R.string.data_pass))
                    commit()
                }
            }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
        },5000)
    }
}