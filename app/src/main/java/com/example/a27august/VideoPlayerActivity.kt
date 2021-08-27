package com.example.a27august

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a27august.databinding.ActivityVideoPlayerBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class VideoPlayerActivity : AppCompatActivity() {
    lateinit var simpleExoPlayer: SimpleExoPlayer
    lateinit var binding: ActivityVideoPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        simpleExoPlayer = SimpleExoPlayer.Builder(this).build()
        binding.videoView.apply {
            player = simpleExoPlayer
            val mediaItem =
                MediaItem.fromUri("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4")
            simpleExoPlayer.addMediaItem(mediaItem)
            val mediaItem2 =
                MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
            simpleExoPlayer.addMediaItem(mediaItem2)
            simpleExoPlayer.prepare()
            simpleExoPlayer.play()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        simpleExoPlayer.release()
    }
}