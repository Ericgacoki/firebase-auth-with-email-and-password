package com.ericg.firebaseauth.views

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.ericg.firebaseauth.R
import com.ericg.firebaseauth.extensions.Extensions.toast
import com.ericg.firebaseauth.utils.FirebaseUtils.fAuth
import com.ericg.firebaseauth.utils.FirebaseUtils.fUser
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    lateinit var inputsArray: Array<EditText>
    lateinit var userEmail: String
    lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        inputsArray = arrayOf(etEmail, etPassword, etConfirmPassword)
        btnSignIn.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = fAuth.currentUser
        user?.let {
            startActivity(Intent(this, HomeActivity::class.java))
            toast("welcome back")
        }
    }

    private fun notEmpty(): Boolean {
        return etEmail.text.toString().trim().isNotEmpty() &&
                etPassword.text.toString().trim().isNotEmpty() &&
                etConfirmPassword.text.toString().trim().isNotEmpty()
    }

    private fun identicalPassword(): Boolean {
        var identical = false
        if (notEmpty() &&
            etPassword.text.toString().trim() == etConfirmPassword.text.toString().trim()
        ) {
            identical = true
        } else if (!notEmpty()) {
            inputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        } else {
            toast("passwords are not matching !")
        }
        return identical
    }

    private fun signIn() {
        if (identicalPassword()) {
            // identicalPassword() only returns true when inputs are not empty and passwords are identical
            userEmail = etEmail.text.toString().trim()
            userPassword = etPassword.text.toString().trim()

            fAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        toast("created user successfully !")
                        sendEmailVerification()
                        // start intent here
                        startActivity(Intent(this, HomeActivity::class.java))

                    } else {
                        toast("failed to Authenticate !")
                    }
                }
        }
    }

    private fun sendEmailVerification() {
        fUser?.sendEmailVerification()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                toast("email sent to $userEmail")

            }

        }
    }
}