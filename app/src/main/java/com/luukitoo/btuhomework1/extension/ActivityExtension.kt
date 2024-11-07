package com.luukitoo.btuhomework1.extension

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

inline fun <reified T> Activity.argument(
    key: String,
    lazyThreadSafetyMode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE
): Lazy<T> {
    return lazy(lazyThreadSafetyMode) {
        intent.extras?.get(key) as T
    }
}

inline fun <reified VB: ViewBinding> Activity.viewBinding(): Lazy<VB> {
    val bindingInflater = VB::class.java.getMethod("inflate", LayoutInflater::class.java)
    return lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(null, layoutInflater) as VB
    }
}