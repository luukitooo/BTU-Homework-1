package com.luukitoo.btuhomework1.validator

import android.util.Patterns

class MessageInputValidator(
    private val recipientNumber: Int?,
    private val message: String
) : InputValidator {

    override fun validate(): Boolean {
        if (recipientNumber == null || message.isBlank()) {
            return false
        }
        if (!Patterns.PHONE.matcher(recipientNumber.toString()).matches()) {
            return false
        }
        return true
    }
}
