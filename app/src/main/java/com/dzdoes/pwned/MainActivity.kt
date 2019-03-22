package com.dzdoes.pwned

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dzdoes.tv.utils.AppExecutors
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gson = GsonBuilder()
            .setLenient()
            .create()


        val retrofit = Retrofit.Builder()

            .baseUrl("https://haveibeenpwned.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val pwned = retrofit.create(PwnedService::class.java)



        btn_send.setOnClickListener(View.OnClickListener {
            var email = et_email.text.toString()
            AppExecutors.instance.networkIO().execute {
               val e = pwned.getAllBraches(email).execute()
                Log.e("result",e.raw().toString())

                runOnUiThread {
                    showResult(e.body())
                }

            }
        })

    }

    private fun showResult(body: List<Breach>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
