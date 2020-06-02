package com.iriton.urfurate20

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.iriton.urfurate.R
import kotlinx.android.synthetic.main.splashscreen.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val logoAnim = AnimationUtils.loadAnimation(this, R.anim.logoriseanimation)
        val loadAnim = AnimationUtils.loadAnimation(this, R.anim.loadanim)
        val firstAnim = AnimationUtils.loadAnimation(this, R.anim.firstmoun)
        val secondAnim = AnimationUtils.loadAnimation(this, R.anim.secondmoun)
        val thirdAnim = AnimationUtils.loadAnimation(this, R.anim.thirdmoun)

        logo.startAnimation(logoAnim)
        loading.startAnimation(loadAnim)
        firstmoun.startAnimation(firstAnim)
        medmoun.startAnimation(secondAnim)
        lastmoun.startAnimation(thirdAnim)

        Handler().postDelayed(
            {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            },
            3000
        )
    }
}