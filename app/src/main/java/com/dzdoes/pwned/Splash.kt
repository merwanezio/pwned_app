package com.dzdoes.pwned

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val i = Intent(this, MainActivity::class.java)

        startActivity(i)

        finish()
    }


}
