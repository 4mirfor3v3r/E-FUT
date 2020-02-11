package com.amier.e_fut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amier.e_fut.database.SQLiteHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_register.setOnClickListener { startActivity(Intent(this,RegisterActivity::class.java));overridePendingTransition(R.anim.transition_from_left,R.anim.transition_to_right) }

        login_btn_login.setOnClickListener { performLogin() }
    }

    private fun performLogin() {
        if (login_et_email.text!!.isNotEmpty()&& login_et_password.text!!.isNotEmpty()){
            val email = login_et_email.text.toString()
            val password = login_et_password.text.toString()
            val a = SQLiteHelper(this).verify(email,password)
            if (a){
                val i = Intent(this,MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(i)
//                overridePendingTransition()
            }else{
                Toast.makeText(this,"Ups, Email atau password salah",Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Harap isi email dan password",Toast.LENGTH_SHORT).show()
        }
    }
}
