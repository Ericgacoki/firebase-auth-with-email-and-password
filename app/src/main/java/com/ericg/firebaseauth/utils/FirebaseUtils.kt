package com.ericg.firebaseauth.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object FirebaseUtils {

    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
}