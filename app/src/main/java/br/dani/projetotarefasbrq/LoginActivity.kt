package br.dani.projetotarefasbrq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        //toolbar da tela de Login
      val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)





    //botão entrar da tela de Login
   val btn_login = findViewById<AppCompatButton>(R.id.btn_login)



         btn_login.setOnClickListener{
            openNextActivity()
        }
    }

      fun openNextActivity() {
      val intent = Intent(this, MainActivity::class.java)
       startActivity(intent)
  }

}
