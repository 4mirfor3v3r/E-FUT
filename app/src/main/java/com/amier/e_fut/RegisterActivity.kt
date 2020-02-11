package com.amier.e_fut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amier.e_fut.database.SQLiteHelper
import com.amier.e_fut.model.Users
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_btn_login.setOnClickListener { onBackPressed() }

        register_btn_regist.setOnClickListener { performRegister() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.transition_from_right,R.anim.transition_to_left)
        finish()
    }

    private fun performRegister() {
        if (register_et_name.text!!.isNotEmpty() && register_et_email.text!!.isNotEmpty()&& register_et_password.text!!.isNotEmpty()&& register_et_telp.text!!.isNotEmpty()){
            val name = register_et_name.text.toString()
            val email = register_et_email.text.toString()
            val password = register_et_password.text.toString()
            val telp = register_et_email.text.toString()
            val data = Users(null, name, email, password, telp)
            val b = SQLiteHelper(this).addData(data)
            if (b){
                val i = Intent(this,MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(i)
                overridePendingTransition(R.anim.transition_from_right,R.anim.transition_to_left)
            }else{
                Toast.makeText(this,"Ups, Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Harap isi email dan password", Toast.LENGTH_SHORT).show()
        }
    }
}
