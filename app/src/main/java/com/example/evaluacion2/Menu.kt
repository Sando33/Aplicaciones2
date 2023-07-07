package com.example.evaluacion2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluacion2.databinding.ActivityLoginBinding
import com.example.evaluacion2.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private lateinit var b: ActivityMenuBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(b.root)

            b.btncamara.setOnClickListener {

                val initial = Intent(this, Camara::class.java)
                startActivity(initial)
                finish()
            }

            b.btnmapa.setOnClickListener {

                val initial = Intent(this, MapActivity::class.java)
                startActivity(initial)
                finish()
            }
            b.btninfo.setOnClickListener {

                val initial = Intent(this, Info::class.java)
                startActivity(initial)
                finish()
            }
    }
}