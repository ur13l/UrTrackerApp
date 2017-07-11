package com.projects.uriel.urtrackerapp.session

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projects.uriel.urtrackerapp.model.User

/**
 * Created by uriel on 9/07/17.
 */

class Session() {
    companion object {
        private var prefs: SharedPreferences? = null
        private val SESSION = "session"
        var user: User? = null


        /**
         * Start the session attributes to locate values in the preferences
         * @param ctx
         */
        fun sessionStart(ctx: Context) {
            prefs = PreferenceManager.getDefaultSharedPreferences(ctx)
            val gson = Gson()
            val jsonUser = prefs!!.getString(SESSION, null)
            if (jsonUser != null) {
                user = gson.fromJson<User>(jsonUser,object:TypeToken<User>(){}.type)
            } else {
                user = User()
            }
        }

        /**
         * Loads an user instance to be the new Session instance.
         * @param user
         */
        fun loadSession(user: User) {
            val gson = Gson()
            val jsonUser = gson.toJson(user)
            prefs!!.edit().putString(SESSION, jsonUser).apply()
        }

        /**
         * Elimina todos los datos guardados en la sesión
         */
        fun logout() {
            prefs!!.edit().remove(SESSION).apply()
        }
    }

}