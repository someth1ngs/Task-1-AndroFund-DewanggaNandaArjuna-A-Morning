package com.example.task_1_androfund_dewangganandaarjuna_a_morning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.task_1_androfund_dewangganandaarjuna_a_morning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv:TextView
    private lateinit var etPesan:EditText
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv = findViewById(R.id.textView)
        etPesan = findViewById(R.id.edt_pesan)

        binding.fragment1Btn.setOnClickListener{
            replaceFragment(Fragment1())
        }

        binding.fragment2Btn.setOnClickListener {
            replaceFragment(Fragment2())
        }

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Selamat Datang $username\nIngin menulis sesuatu?"

        val btnImplicit: Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_implicit -> {
                val message = etPesan.text.toString()
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                startActivity(intent)

                val intent2 = Intent()
                intent2.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent2)
                finish()
            }
        }
    }

}