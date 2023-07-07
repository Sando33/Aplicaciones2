package com.example.evaluacion2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast

import androidx.core.widget.addTextChangedListener
import com.example.evaluacion2.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {




    private lateinit var b: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.email.editText?.addTextChangedListener{ text ->
            b.btnlogin.isEnabled = validateEmailPassword(text.toString(),b.txtpassword.editText?.text.toString())
        }
        b.txtpassword.editText?.addTextChangedListener{ text ->
            b.btnlogin.isEnabled = validateEmailPassword(b.email.editText?.text.toString(),text.toString())
        }

        b.btnlogin.setOnClickListener {
            val initial = Intent(this, Menu::class.java)
            startActivity(initial)
            finish()
        }
    }

    private fun validateEmailPassword(email:String, password:String):Boolean{
        val validateEmail = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val validatePassword = password.length >= 6
        return validateEmail && validatePassword
    }
}