package com.ericg.firebaseauth.extensions

import android.app.Activity
import android.widget.Toast

object Extensions {
    fun Activity.toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}