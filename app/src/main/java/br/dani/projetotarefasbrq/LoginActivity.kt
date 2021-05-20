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
import androidx.core.content.ContextCompat.startActivity

class LoginActivity : AppCompatActivity() {


    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var btn_login: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()


         btn_login = findViewById(R.id.btn_login)
        val btn_login = findViewById<AppCompatButton>(R.id.btn_login)
        btn_loginsetOnClickListener {
            validarLogin(it.context)
        }
        }



    }

    private fun validarLogin(context: Context) {
        var txtPassword = findViewById<TextView>(R.id.editText3)
        var txtEmail = findViewById<TextView>(R.id.editText2)

        if (txtEmail.text.isNullOrEmpty() || txtPassword.text.isNullOrEmpty()) {
            txtPassword.setError("Ambos os campos devem ser preenchidos")
            txtEmail.setError("Ambos os campos devem ser preenchidos")
        }else if (txtPassword.text.length < 5) {
            txtPassword.setError("A sua senha esta muito curta, tem certeza que esta correta?")
        }
        else{
            val intent = Intent(ctx, MainActivity::class.java)
            startActivity(intent)


    }


}
}








