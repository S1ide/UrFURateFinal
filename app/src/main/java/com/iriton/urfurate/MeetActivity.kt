package com.iriton.urfurate

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iriton.urfurate.MainActivity
import com.iriton.urfurate.R
import kotlinx.android.synthetic.main.login_layout.*
import kotlinx.android.synthetic.main.meet_activity.*

class MeetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meet_activity)

        val title = findViewById<TextView>(R.id.title)
        val bundle = getIntent().extras as Bundle
        val event = bundle.get("Event") as Event
        title.text = event.nameOfMeet
        tWStartTime.text = event.timeOfStart
        tWEndTime.text = event.timeOfEnd
        logo_mero.setImageResource(event.logo)


    }

    fun speakQuestion(view: View) {
        val toast = Toast.makeText(applicationContext, "В разработке!", Toast.LENGTH_SHORT)
        toast.show()
    }
    fun registrationOnMero(view: View) {
        val toast = Toast.makeText(applicationContext, "Вы зарегистрированы!", Toast.LENGTH_SHORT)
        toast.show()
    }
}