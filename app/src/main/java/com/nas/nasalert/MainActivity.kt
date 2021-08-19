package com.nas.nasalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nas.nas_toast.NasAlert
import com.nas.nasalert.databinding.ActivityMainBinding
import com.pinyue.zcf.base.BugBindingBaseAppCompatActivity
import com.rulerbug.bugutils.Utils.BugLogUtils

class MainActivity : BugBindingBaseAppCompatActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun main() {
        mBinging.step.setListener {
            BugLogUtils.e(it, "num")
            if (it == 1) {
                NasAlert.showByOneButton(this, "提示", "一个按钮", {
                    BugLogUtils.e("ok", "one")
                })
            } else if (it == 2) {
                NasAlert.showByTwoButton(this, "提示", "二个按钮", {
                    BugLogUtils.e("ok", "two")
                })
            }
        }
    }

}