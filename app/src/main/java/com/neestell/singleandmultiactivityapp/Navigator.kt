package com.neestell.singleandmultiactivityapp

import android.app.Service
import android.content.Intent
import android.os.BatteryManager
import android.os.Handler
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import singlemultiple.neestell.com.singleandmultiactivityapp.R


/**
 * Copyright © 2018 Rosberry. All rights reserved.
 *
 * Created by neestell on 07.11.2018.
 */
class Navigator(var autoplay: Boolean, val maxScreens: Int) {
    val handler = Handler()
    var countOpenScreens = 0
    val newScreenDelay = 500L
    var goBack = false

    fun navigate(fm: FragmentManager) {
        if (hasNext()) {
            next(fm)
        } else
            previous(fm)
    }

    private fun next(fm: FragmentManager) {
        handler.postDelayed({
            fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.contentView, MainFragment.newInstance(), MainFragment.TAG)
                .addToBackStack(MainFragment.TAG)
                .commit()
            countOpenScreens += 1
        }, getDelay())
    }

    fun navigate(activity: AppCompatActivity) {
        if (hasNext())
            next(activity)
        else
            previous(activity)
    }

    private fun next(activity: AppCompatActivity) {
        handler.postDelayed({
            activity.startActivity(
                    Intent(activity, ChildActivity::class.java))
            countOpenScreens += 1
        }, getDelay())
    }

    fun previous(fm: FragmentManager) {
        goBack = true
        handler.postDelayed({
            fm.popBackStackImmediate()
            countOpenScreens -= 1
        }, getDelay())
    }

    private fun previous(activity: AppCompatActivity) {
        goBack = true
        handler.postDelayed({
            activity.finish()
            countOpenScreens -= 1
        }, getDelay())
    }

    private fun getDelay() = if (autoplay) newScreenDelay else 0

    fun hasNext() = countOpenScreens < maxScreens && !goBack

    fun rewind() {
        countOpenScreens = 0
        goBack = false
    }

}