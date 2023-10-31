package com.example.activitieslifecycle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitieslifecycle.MainActivity.Companion.EXTRA_AGE
import com.example.activitieslifecycle.MainActivity.Companion.EXTRA_NAME

class SecondActivity : AppCompatActivity() {
    private lateinit var buttonReturnToFirstActivity: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonReturnToFirstActivity = findViewById(R.id.button2)
        buttonReturnToFirstActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        textView = findViewById(R.id.secActivitytextView)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        textView.text = "name = $name, age = $age"

        Log.d("XXXX", "name = $name, age = $age")
    }
}