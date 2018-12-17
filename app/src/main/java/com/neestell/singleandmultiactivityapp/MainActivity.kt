package com.neestell.singleandmultiactivityapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.activity_main.*
import singlemultiple.neestell.com.singleandmultiactivityapp.R

class MainActivity : AppCompatActivity() {

    companion object {
        val navigator = Navigator(true, 15);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSingleTest.setOnClickListener {
            MainActivity.navigator.rewind()
            startActivity(Intent(this@MainActivity, HostActivity::class.java))
        }

        buttonMultipleTest.setOnClickListener {
            MainActivity.navigator.rewind()

            startActivity(Intent(this@MainActivity, ChildActivity::class.java))
        }

        checkboxAutoplay.setOnClickListener{
            (it as CheckedTextView).toggle()
            MainActivity.navigator.autoplay = it.isChecked
        }
    }
}
