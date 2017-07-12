package com.projects.uriel.urtrackerapp.application

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.projects.uriel.urtrackerapp.session.Session
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by uriel on 9/07/17.
 */
class MyApplication : Application() {

    /**
     * Punto de partida que ejecuta la app al iniciar.
     */
    override fun onCreate() {
        super.onCreate()

        //Método para iniciar la instancia de la sesión.
        Session.sessionStart(this)

        //Instancia de gson utilizada por Retrofit para usarse en otra sección de la app.
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("d/M/yyyy").create()

        //Instancia de retrofit, utilizada en la app.
        retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build()


        Realm.init(this)
        realmInstance = Realm.getDefaultInstance()

    }

    companion object {

        var realmInstance: Realm? = null
            private set

        var retrofitInstance: Retrofit? = null
            private set


        val BASE_URL = "https://ur-tracker-backend.herokuapp.com/api/"
    }

}