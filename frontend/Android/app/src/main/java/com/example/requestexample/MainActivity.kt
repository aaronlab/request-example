package com.example.requestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var server: RetrofitService? = null
    private val url = "http://192.168.0.5:4000"  // Your IP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        server = retrofit.create(RetrofitService::class.java)

        button.setOnClickListener {
            val message = editText.text.toString()

            server?.sendMessage(message)?.enqueue(object: Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    Log.i("test", "Fail")
                }

                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    Log.i("test", "Success")
                }
            })

        }
    }
}
