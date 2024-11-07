package com.luukitoo.btuhomework1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.luukitoo.btuhomework1.databinding.ActivityResultBinding
import com.luukitoo.btuhomework1.extension.argument
import com.luukitoo.btuhomework1.extension.viewBinding

class ResultActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityResultBinding>()

    private val number by argument<Int>(FillDataActivity.KEY_RECIPIENT_NUMBER)
    private val message by argument<String>(FillDataActivity.KEY_MESSAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        setListeners()
    }

    private fun initViews() = with(binding) {
        etRecipientNumber.setText(number.toString())
        etMessage.setText(message)
    }

    private fun setListeners() = with(binding) {
        btnClear.setOnClickListener {
            onClearClick()
        }
    }

    private fun onClearClick() = with(binding) {
        etRecipientNumber.text?.clear()
        etMessage.text?.clear()
    }
}
