#include <string.h>
#include <jni.h>

//START OF
//** secret url
//package com.don.tokenomy.utils
JNIEXPORT jstring JNICALL
Java_com_don_tokenomy_utils_JniHelper_baseUrl(JNIEnv *env) {
    return (*env)->NewStringUTF(env, "https://exchange.tokenomy.com/");
}
//END OF API KEY




