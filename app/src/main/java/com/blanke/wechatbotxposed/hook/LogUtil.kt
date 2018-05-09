package com.blanke.wechatbotxposed.hook

import de.robv.android.xposed.XposedBridge

/**
 * Created by blanke on 2017/10/3.
 */

object LogUtil {
    fun log(msg: String) {
        XposedBridge.log("Bot:\t" + msg + "\tts=" + System.currentTimeMillis())
    }

    fun log(e: Throwable) {
        XposedBridge.log(e)
    }

    fun logStackTraces(methodCount: Int = 15, methodOffset: Int = 3) {
        val trace = Thread.currentThread().stackTrace
        var level = ""
        log("---------logStackTraces start----------")
        for (i in methodCount downTo 1) {
            val stackIndex = i + methodOffset
            if (stackIndex >= trace.size) {
                continue
            }
            val builder = StringBuilder()
            builder.append("|")
                    .append(' ')
                    .append(level)
                    .append(trace[stackIndex].className)
                    .append(".")
                    .append(trace[stackIndex].methodName)
                    .append(" ")
                    .append(" (")
                    .append(trace[stackIndex].fileName)
                    .append(":")
                    .append(trace[stackIndex].lineNumber)
                    .append(")")
            level += "   "
            log(builder.toString())
        }
        log("---------logStackTraces end----------")
    }
}
