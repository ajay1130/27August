package com.example.a27august

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.a27august.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val listOfUrl = ArrayList<String>().apply {
            add("https://assets7.lottiefiles.com/packages/lf20_69HH48.json")
            add("https://assets6.lottiefiles.com/private_files/lf30_1TcivY.json")
            add("https://assets6.lottiefiles.com/packages/lf20_cUG5w8.json")
            add("https://assets6.lottiefiles.com/packages/lf20_xnbikipz.json")
            add("https://assets6.lottiefiles.com/private_files/lf30_FPH6Ci.json")
        }
        binding.apply {
            buttonStartAnimation.setOnClickListener {
                lootieanimation.setAnimationFromUrl(listOfUrl.random())
                lootieanimation.resumeAnimation()
            }
            buttonStopAnimation.setOnClickListener {
                if(lootieanimation.isAnimating){
                    lootieanimation.pauseAnimation()
                }
            }

            buttonStartvideo.setOnClickListener {
                startActivity(Intent(this@MainActivity,VideoPlayerActivity::class.java))
            }
            buttonEasypermission.setOnClickListener {
                startActivity(Intent(this@MainActivity,PermissionActivity::class.java))
            }
        }
        Timber.d("Activity Created...")

    }

    override fun onStart() {
        super.onStart()
        Timber.d("Activity Started..")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("Activity Resumed...")
    }
}