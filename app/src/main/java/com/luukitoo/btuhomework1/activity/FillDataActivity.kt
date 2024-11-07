package com.luukitoo.btuhomework1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.luukitoo.btuhomework1.R
import com.luukitoo.btuhomework1.databinding.ActivityFillDataBinding
import com.luukitoo.btuhomework1.extension.showToast
import com.luukitoo.btuhomework1.extension.startActivity
import com.luukitoo.btuhomework1.extension.viewBinding
import com.luukitoo.btuhomework1.validator.MessageInputValidator
import com.luukitoo.btuhomework1.validator.onFailure
import com.luukitoo.btuhomework1.validator.onSuccess

class FillDataActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityFillDataBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() = with(binding) {
        btnSendMessage.setOnClickListener {
            onSendMessageClick()
        }
    }

    private fun onSendMessageClick() = with(binding) {
        val number = etRecipientNumber.text.toString().toIntOrNull()
        val message = etMessage.text.toString()
        MessageInputValidator(
            recipientNumber = number,
            message = message
        ).onSuccess {
            goToResultActivity(number!!, message)
        }.onFailure {
            showToast(getString(R.string.inputs_should_not_be_empty))
        }
    }

    private fun goToResultActivity(number: Int, message: String) {
        startActivity<ResultActivity> {
            putExtra(KEY_RECIPIENT_NUMBER, number)
            putExtra(KEY_MESSAGE, message)
        }
    }

    companion object {
        const val KEY_RECIPIENT_NUMBER = "KEY_RECIPIENT_NUMBER"
        const val KEY_MESSAGE = "KEY_MESSAGE"
    }
}