package com.neestell.singleandmultiactivityapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.neestell.singleandmultiactivityapp.MainActivity.Companion.navigator
import singlemultiple.neestell.com.singleandmultiactivityapp.R

class HostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        navigator.navigate(supportFragmentManager)
    }

    override fun onBackPressed() {
        if (navigator.goBack)
            navigator.navigate(supportFragmentManager).let {
                finishActivityIfLast()
            }
    }

    private fun finishActivityIfLast() {
        if (supportFragmentManager.backStackEntryCount == 1 && navigator.goBack)
            finish()

    }
}
