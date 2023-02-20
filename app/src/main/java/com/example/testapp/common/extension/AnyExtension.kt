package com.example.testapp.common.extension

val Any.classTag: String
    get() = this::class.java.simpleName