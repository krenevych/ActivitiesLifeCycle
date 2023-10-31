package com.example.activitieslifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var textView: TextView

    private var retrofitObject: RetrofitObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            val key = "8d241653a684f6a80b82"
//            val key = "8d241653a684f6a80b82asd4"
//            val key = "331b30e8019a2c359e9c"
            retrofitObject?.get(key, object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    val body = response.body()
                    textView.text = body.toString()
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.e(TAG, "Retrofit: $t")
                }

            })
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

        retrofitObject = RetrofitObject("https://api.npoint.io/")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")

        retrofitObject = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "CCCCCC"
        const val EXTRA_NAME = "name"
        const val EXTRA_AGE = "age"
    }
}