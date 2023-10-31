package com.example.activitieslifecycle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var name: EditText
    private lateinit var age: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        button = findViewById(R.id.button)
        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextAge)

        button.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)

//            val textName: String = name.text.toString()
            val textAge: Int = age.text.toString().toInt()

//            intent.putExtra(EXTRA_NAME, textName)
//            intent.putExtra(EXTRA_AGE, textAge)

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${textAge}"))
//            val intent = Intent(Intent.ACTION_DIAL)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
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