package com.amier.e_fut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amier.e_fut.model.Items
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Items>("items")
        if (data != null) {
            detail_iv.setBackgroundResource(data.image!!)
        }
    }
}
