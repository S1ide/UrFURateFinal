package com.iriton.urfurate20

import java.io.Serializable

class User(private var mLogin: String, private var mPassword: String) : Serializable {
    fun getmLogin(): String {
        return mLogin
    }

    fun setmLogin(mLogin: String) {
        this.mLogin = mLogin
    }

    fun getmPassword(): String {
        return mPassword
    }

    fun setmPassword(mPassword: String) {
        this.mPassword = mPassword
    }

}