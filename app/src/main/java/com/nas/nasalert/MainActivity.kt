package com.nas.nasalert

import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import com.nas.nas_toast.NasAlert
import com.nas.nasalert.databinding.ActivityMainBinding
import com.pinyue.zcf.base.BugBindingBaseAppCompatActivity
import com.rulerbug.bugutils.Utils.BugLogUtils

class MainActivity : BugBindingBaseAppCompatActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
    }
    val swipeBackController by lazy { SwipeBackController(this) }
    override fun main() {
        mBinging.stepView.setMin(10)
        mBinging.stepView.setMax(100)
        mBinging.stepView.setListener {

            mBinging.btGetMsg.setText(it.toString())
        }
        mBinging.btGetMsg.setOnClickListener {

            mBinging.btGetMsg.setText(mBinging.stepView.num.toString())
            NasAlert.showByOneButton(this, "你好", "已获取数量", {

            })
        }
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (swipeBackController.processEvent(ev)) {
            return true;
        } else {
            return super.onTouchEvent(ev);
        }
    }
}