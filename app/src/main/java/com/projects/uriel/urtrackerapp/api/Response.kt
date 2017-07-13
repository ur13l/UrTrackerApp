package com.projects.uriel.urtrackerapp.api

/**
 * Created by uriel on 12/07/17.
 */
class Response<T> {
    var success : Boolean = false
    var errors : Array<String>? = null
    var data : T? = null
}