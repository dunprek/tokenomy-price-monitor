package com.don.tokenomy.utils

object JniHelper {
    init {
        System.loadLibrary("kotlin-jni")
    }

    external fun baseUrl(): String
}