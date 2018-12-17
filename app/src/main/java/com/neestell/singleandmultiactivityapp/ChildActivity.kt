package com.neestell.singleandmultiactivityapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.neestell.singleandmultiactivityapp.MainActivity.Companion.navigator
import kotlinx.android.synthetic.main.l_content.*
import singlemultiple.neestell.com.singleandmultiactivityapp.R

class ChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        recyclerItems.adapter = ItemsAdapter()

        buttonGo.setOnClickListener { navigator.navigate(this) }

        buttonGo.visibility = if (navigator.autoplay) View.INVISIBLE else View.VISIBLE;
    }

    override fun onResume() {
        super.onResume()
        if (navigator.autoplay)
            navigator.navigate(this)
    }
}
