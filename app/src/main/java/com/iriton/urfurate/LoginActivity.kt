package com.iriton.urfurate20

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iriton.urfurate.MainActivity
import com.iriton.urfurate.R
import kotlinx.android.synthetic.main.login_layout.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
    }

    private fun isEmailValid() = (TextUtils.isEmpty(space!!.text).not()
            && Patterns.EMAIL_ADDRESS.matcher(space!!.text).matches())

    private fun isPasswordValid() = TextUtils.isEmpty(secondSpace!!.text).not()

    fun onEnableBtnClick(v: View) {

        when (isEmailValid() && isPasswordValid()) {

            true -> {
                showToast("Вход выполнен!")
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(
                    MainActivity.USER_KEY, User(space.getText().toString(), secondSpace.getText().toString())
                )
                startActivity(intent)
            }

            false -> showToast("Неправильные данные!")
        }
    }

    private fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}