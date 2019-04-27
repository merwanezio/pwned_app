package com.dzdoes.pwned

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dzdoes.tv.utils.AppExecutors
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnSwipeListener {

            if(!search())
                btn_send.morphToCircle()
        }




    }

    private fun search() :Boolean{

        if(!validEmail(et_email.text.toString()))
            return false

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://haveibeenpwned.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val pwned = retrofit.create(PwnedService::class.java)


        var email = et_email.text.toString()
        AppExecutors.instance.networkIO().execute {
            val e = pwned.getAllBraches(email).execute()
            Log.e("result",e.raw().toString())
            runOnUiThread {
                showResult(e.body())
            }
        }

        btn_send.showResultIcon(true)


        return true
    }

    private fun validEmail(email:String): Boolean {
        if(email.equals(""))
            return false



        return true
    }


    private fun showResult(body: List<Breach>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
