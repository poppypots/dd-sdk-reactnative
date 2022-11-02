/*
 * Unless explicitly stated otherwise all files in this repository are licensed under the Apache License Version 2.0.
 * This product includes software developed at Datadog (https://www.datadoghq.com/).
 * Copyright 2016-Present Datadog, Inc.
 */

package com.datadog.reactnative

import com.datadog.android.log.Logger
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap

/**
 * The entry point to use Datadog's Logs feature.
 */
class DdLogs(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String = "DdLogs"

    private val bridgeLogger: Logger by lazy {
        Logger.Builder()
            .setDatadogLogsEnabled(true)
            .setLogcatLogsEnabled(true)
            .setLoggerName("DdLogs")
            .build()
    }


    /**
     * Send a log with level debug.
     * @param message The message to send.
     * @param context The additional context to send.
     */
    @ReactMethod
    fun debug(message: String, context: ReadableMap, promise: Promise) {
        bridgeLogger.d(
            message = message,
            attributes = context.toHashMap() + GlobalState.globalAttributes
        )
        promise.resolve(null)
    }

    /**
     * Send a log with level info.
     * @param message The message to send.
     * @param context The additional context to send.
     */
    @ReactMethod
    fun info(message: String, context: ReadableMap, promise: Promise) {
        bridgeLogger.i(
            message = message,
            attributes = context.toHashMap() + GlobalState.globalAttributes
        )
        promise.resolve(null)
    }

    /**
     * Send a log with level warn.
     * @param message The message to send.
     * @param context The additional context to send.
     */
    @ReactMethod
    fun warn(message: String, context: ReadableMap, promise: Promise) {
        bridgeLogger.w(
            message = message,
            attributes = context.toHashMap() + GlobalState.globalAttributes
        )
        promise.resolve(null)
    }

    /**
     * Send a log with level error.
     * @param message The message to send.
     * @param context The additional context to send.
     */
    @ReactMethod
    fun error(message: String, context: ReadableMap, promise: Promise) {
        bridgeLogger.e(
            message = message,
            attributes = context.toHashMap() + GlobalState.globalAttributes
        )
        promise.resolve(null)
    }

}