//
// Created by kevin on 07/12/2020.
//

#include <jni.h>
#include <string>
#include <iostream>

extern "C" JNIEXPORT int JNICALL
Java_id_ac_ui_cs_mobileprogramming_kevinraikhanzain_mobileprogramminglab_MainActivity_Method(JNIEnv *env, jobject /* this */, int number) {

//    std::string hello = "Hello from C++";
    return 100 + number;
}

