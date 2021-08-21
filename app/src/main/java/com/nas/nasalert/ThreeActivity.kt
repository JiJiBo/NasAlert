package com.nas.nasalert

import android.os.Bundle
import com.nas.nasalert.databinding.ActivityThreeBinding

import com.pinyue.zcf.base.BugBindingBaseAppCompatActivity


class ThreeActivity : BugBindingBaseAppCompatActivity<ActivityThreeBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_three
    }

    override fun main() {

    }

    override fun bugActivityCanSwipe(): Boolean {
        return true
    }
}