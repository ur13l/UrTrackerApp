package com.projects.uriel.urtrackerapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.projects.uriel.urtrackerapp.R
import android.graphics.Typeface
import android.support.design.widget.Snackbar
import android.text.InputType
import android.widget.TextView
import com.projects.uriel.urtrackerapp.activities.MainActivity
import com.projects.uriel.urtrackerapp.api.Response
import com.projects.uriel.urtrackerapp.api.UserApi
import com.projects.uriel.urtrackerapp.application.MyApplication
import com.projects.uriel.urtrackerapp.model.User
import com.projects.uriel.urtrackerapp.session.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit


/**
 * Created by uriel on 9/07/17.
 */

class SignInFragment : BaseFragment(){
    private var retrofit : Retrofit? = null
    private var userApi : UserApi? = null
    private var etEmail : EditText? = null
    private var etPassword : EditText? = null
    private var btnSignIn : Button? = null
    private var tvForgotPassword : TextView? = null
    private var tvRegister : TextView? = null

    /**
     * Method executed when the fragment is loaded
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofit = MyApplication.retrofitInstance
        userApi = retrofit!!.create(UserApi::class.java)
    }

    /**
     * Executed to inflate the fragment view.
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_sign_in, container, false)
        defineViews(view)

        //Input type configuration for etPassword
        etPassword!!.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        etPassword!!.setTypeface(Typeface.DEFAULT)

        //Setting up listeners in elements
        btnSignIn!!.setOnClickListener { view -> signIn() }
        tvForgotPassword!!.setOnClickListener { view -> forgotPassword() }
        tvRegister!!.setOnClickListener { view -> register() }

        return view
    }


    /**
     * Function to assign the elements from the UI to Kotlin Objects
     */
    override fun defineViews(view : View) {
        etEmail = view.findViewById(R.id.et_email) as EditText
        etPassword = view.findViewById(R.id.et_password) as EditText
        btnSignIn = view.findViewById(R.id.btn_sign_in) as Button
        tvForgotPassword = view.findViewById(R.id.tv_forgot_password) as TextView
        tvRegister = view.findViewById(R.id.tv_register) as TextView

    }

    fun forgotPassword() {

    }


    /**
     * Function that handles the btnSignIn click. Its main function is to start the sign in process.
     */
    fun signIn() {
        var call : Call<Response<User>> = userApi!!.login(etEmail!!.text.toString(), etPassword!!.text.toString())
        call.enqueue(object : Callback<Response<User>> {
            override fun onFailure(call: Call<Response<User>>?, t: Throwable?) {
                Snackbar.make(btnSignIn as View, R.string.request_error, Snackbar.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Response<User>>?, response: retrofit2.Response<Response<User>>?) {
                if (response!!.body() != null) {
                    var user = response!!.body().data
                    Session.loadSession(user!!)
                    val intent = Intent(activity as Context, MainActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    activity.startActivity(intent)
                    activity.finish()
                }
            }

        })
    }

    fun register() {
        val ft = fragmentManager.beginTransaction()
        val signUpFragment = SignUpFragment()
        ft.replace(R.id.fragment_container,signUpFragment).commit()
    }
}
