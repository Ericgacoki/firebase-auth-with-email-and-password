package com.ericg.firebaseauth.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object FirebaseUtils {
    val fAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val fUser: FirebaseUser? = fAuth.currentUser
}