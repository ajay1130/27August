package com.example.a27august

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

class MyApp:Application() {
    private val isDebug = true
    override fun onCreate() {
        super.onCreate()
        if (isDebug) {
//            val formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)
//                .methodCount(2)
//                .methodOffset(7)
//                .build()
//            Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
            Timber.plant(object : Timber.DebugTree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    super.log(priority, "global_tag_$tag", message, t)
                }

                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "%s->%s:%s",
                        element.className,
                        element.methodName,
                        element.lineNumber,
                        super.createStackElementTag(element)
                    )
                }
            })
            Timber.d("Global App")

        }
    }
}