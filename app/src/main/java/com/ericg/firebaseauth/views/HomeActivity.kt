package com.ericg.firebaseauth.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ericg.firebaseauth.R
import com.ericg.firebaseauth.extensions.Extensions.toast
import com.ericg.firebaseauth.utils.FirebaseUtils.fAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSignOut.setOnClickListener {
            fAuth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            toast("signed out")
        }
    }
}