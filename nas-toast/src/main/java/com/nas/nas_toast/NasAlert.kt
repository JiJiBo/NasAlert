package com.nas.nas_toast

import android.app.Activity
import android.app.Dialog
import androidx.databinding.DataBindingUtil
import com.nas.nas_toast.databinding.NasOneBtBinding
import com.nas.nas_toast.databinding.NasTwoBtBinding

object NasAlert {
    fun showByOneButton(activity: Activity, title: String, msg: String, ok: () -> Unit) {
        val dialog = Dialog(activity)
        val bind = DataBindingUtil.inflate<NasOneBtBinding>(
            activity.layoutInflater,
            R.layout.nas_one_bt,
            null,
            false
        )
        bind.tvTitle.setText(title)
        bind.tvMsg.setText(msg)
        dialog.setContentView(bind.root)
        dialog.show()
        dialog.setOnDismissListener {
            ok()
        }
        dialog.window!!.setBackgroundDrawableResource(R.color.transparent)
        bind.btSubmit.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun showByTwoButton(activity: Activity, title: String, msg: String, ok: () -> Unit) {
        val dialog = Dialog(activity)
        val bind = DataBindingUtil.inflate<NasTwoBtBinding>(
            activity.layoutInflater,
            R.layout.nas_two_bt,
            null,
            false
        )
        bind.tvTitle.setText(title)
        bind.tvContent.setText(msg)
        dialog.setContentView(bind.root)
        dialog.show()

        dialog.window!!.setBackgroundDrawableResource(R.color.transparent)
        bind.tvEnsure.setOnClickListener {
            dialog.dismiss()
            ok()
        }
        bind.tvCancle.setOnClickListener {
            dialog.dismiss()
        }
    }
}