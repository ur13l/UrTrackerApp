package com.projects.uriel.urtrackerapp.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.projects.uriel.urtrackerapp.R
import com.projects.uriel.urtrackerapp.fragments.SignInFragment

/**
 * Created by uriel on 9/07/17.
 */

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val ft = supportFragmentManager.beginTransaction()
        val signInFragment = SignInFragment()
        ft.replace(R.id.fragment_container, signInFragment).commit()

    }
}
