package br.dani.projetotarefasbrq

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {


    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var btn_login: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()


        editText3 = findViewById(R.id.editText3)
        btn_login = findViewById(R.id.btn_login)


        ////////////////// //botão entrar --> ir para MainActivity

        val btn_login = findViewById<AppCompatButton>(R.id.btn_login)
        btn_login.setOnClickListener {


        }


    }
}








