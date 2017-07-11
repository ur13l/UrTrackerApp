package com.projects.uriel.urtrackerapp.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import com.projects.uriel.urtrackerapp.session.Session

/**
 * Created by uriel on 9/07/17.
 */

class SplashActivity : AppCompatActivity() {
    private var prefs: SharedPreferences? = null

    /**
     * Method executed when the app starts, it loads the activity and wait elements to be ready in
     * the next activity.
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent: Intent

        //Preference instancge
        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)


        if (Session.user!!._id != null) {
            intent = Intent(this, MainActivity::class.java)
        } else {
            intent = Intent(this, StartActivity::class.java);
        }


        startActivity(intent)
        finish()
    }

}
