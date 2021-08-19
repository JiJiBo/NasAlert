package com.nas.nas_toast

import android.widget.Toast
import com.rulerbug.bugutils.Utils.BugApp

object NasToast {
    val toast by lazy { Toast(BugApp.getContext()) }

}