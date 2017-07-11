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
    var retrofitInstance: Retrofit? = null
        private set


    /**
     * Punto de partida que ejecuta la app al iniciar.
     */
    override fun onCreate() {
        super.onCreate()

        //Método para iniciar la instancia de la sesión.
        Session.sessionStart(this)

        //Instancia de gson utilizada por Retrofit para usarse en otra sección de la app.
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setDateFormat("d/M/yyyy").create()

        //Instancia de retrofit, utilizada en la app.
        retrofitInstance = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build()


        Realm.init(this)
        realmInstance = Realm.getDefaultInstance()

    }

    companion object {

        var realmInstance: Realm? = null
            private set
        var LAST_UPDATE_CONVOCATORIAS = "last_update_convocatorias"
        var LAST_UPDATE_REGIONES = "last_update_regiones"
        var LAST_UPDATE_EVENTOS = "last_update_eventos"
        val LAST_UPDATE_PUBLICIDAD = "last_update_publicidad"


        //dirección publica
        //public static final String BASE_URL = "http://200.23.39.11/GuanajovenWeb/public/api/";

        //uriel publica
        //public static final String BASE_URL = "http://192.168.0.93/GuanajovenWeb/public/api/";

        val BASE_URL = "http://10.0.7.128/GuanajovenWeb/public/api/"
    }

}