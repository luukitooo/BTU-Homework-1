package com.luukitoo.btuhomework1.extension

import android.content.Context
import android.content.Intent
import android.widget.Toast
import kotlin.reflect.KClass

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

inline fun <reified T> Context.startActivity(intentBuilder: Intent.() -> Unit = { }) {
    val intent = Intent(this, T::class.java)
    intentBuilder.invoke(intent)
    startActivity(intent)
}
