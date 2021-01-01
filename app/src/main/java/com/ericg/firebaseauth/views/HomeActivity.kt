package com.ericg.firebaseauth.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ericg.firebaseauth.R
import com.ericg.firebaseauth.extensions.Extensions.toast
import com.ericg.firebaseauth.utils.FirebaseUtils.firebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

// todo use dataBinding instead of kotlin synthetics

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, CreateAccountActivity::class.java))
            toast("Signed out")
            finish()
        }
    }
}