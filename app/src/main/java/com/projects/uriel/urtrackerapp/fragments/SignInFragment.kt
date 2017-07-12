package com.projects.uriel.urtrackerapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.projects.uriel.urtrackerapp.R
import android.graphics.Typeface
import android.text.InputType
import android.support.v4.widget.SearchViewCompat.setInputType



/**
 * Created by uriel on 9/07/17.
 */

class SignInFragment : BaseFragment(){
    private var etEmail : EditText? = null
    private var etPassword : EditText? = null
    private var btnSignIn : Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_sign_in, container, false)
        defineViews(view)


        return view
    }


    override fun defineViews(view : View) {
        etEmail = view.findViewById(R.id.et_email) as EditText
        etPassword = view.findViewById(R.id.et_password) as EditText
        btnSignIn = view.findViewById(R.id.btn_sign_in) as Button

        //Input type configuration for etPassword
        etPassword!!.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        etPassword!!.setTypeface(Typeface.DEFAULT)
    }
}
