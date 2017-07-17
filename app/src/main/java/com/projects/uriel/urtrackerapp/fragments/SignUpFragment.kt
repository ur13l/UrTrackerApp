package com.projects.uriel.urtrackerapp.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.projects.uriel.urtrackerapp.R

/**
 * Created by uriel on 9/07/17.
 */

class SignUpFragment : BaseFragment () {
    var etEmail : EditText? = null
    var etPassword : EditText? = null
    var etConfirmPassword : EditText? = null
    var etName : EditText? = null
    var btnSignUp : Button? = null
    var tvLogin : TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_sign_up, container, false)
        defineViews(view)

        //Input type configuration for etPassword
        etPassword!!.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        etConfirmPassword!!.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        etPassword!!.setTypeface(Typeface.DEFAULT)
        etConfirmPassword!!.setTypeface(Typeface.DEFAULT)

        //Setting up listeners in elements
        tvLogin!!.setOnClickListener { view -> login() }
        btnSignUp!!.setOnClickListener { view -> signUp() }

        return view
    }

    /**
     * Function to assign the elements from the UI to Kotlin Objects
     */
    override fun defineViews(view : View) {
        etEmail = view.findViewById(R.id.et_email) as EditText
        etPassword = view.findViewById(R.id.et_password) as EditText
        etConfirmPassword = view.findViewById(R.id.et_confirm_password) as EditText
        etName = view.findViewById(R.id.et_name) as EditText
        btnSignUp = view.findViewById(R.id.btn_sign_up) as Button
        tvLogin = view.findViewById(R.id.tv_login) as TextView

    }

    fun login () {
        val ft = fragmentManager.beginTransaction()
        val signInFragment = SignInFragment()
        ft.replace(R.id.fragment_container,signInFragment).commit()
    }

    fun signUp () {

    }

}
