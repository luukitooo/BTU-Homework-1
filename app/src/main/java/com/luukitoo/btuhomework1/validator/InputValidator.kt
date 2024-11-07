package com.luukitoo.btuhomework1.validator

interface InputValidator {

    fun validate(): Boolean
}

inline fun InputValidator.onSuccess(action: () -> Unit): InputValidator {
    if (validate()) action.invoke()
    return this
}

inline fun InputValidator.onFailure(action: () -> Unit): InputValidator {
    if (!validate()) action.invoke()
    return this
}
