package com.example.task_1_androfund_dewangganandaarjuna_a_morning

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.squareup.picasso.Picasso



class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var history:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)
//        val imageUrl = "https://w0.peakpx.com/wallpaper/218/861/HD-wallpaper-s20-ultra-android-circuit-board-galaxy-motherboard-s20-ultra-tech.jpg"
//        Picasso.get().load(imageUrl).into(backgroundImageView)

        history = findViewById(R.id.history)
        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if (bundle != null) {
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

    fun goToRegister(v: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(etUsername.text.toString(), etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}
