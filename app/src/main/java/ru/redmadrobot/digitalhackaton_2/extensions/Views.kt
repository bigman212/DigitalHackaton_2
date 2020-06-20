package ru.redmadrobot.digitalhackaton_2.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.google.android.material.textfield.TextInputEditText

fun ProgressBar.showLoading() {
    isVisible = true
}

fun ProgressBar.hideLoading() {
    isGone = true
}

fun Activity.hideKeyboard(focusedView: View?) {
    focusedView?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }
}

fun Activity.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun TextInputEditText.fieldValue(): String = text.toString()

val ViewBinding.context: Context
    get() = root.context

val ViewBinding.resources: Resources
    get() = context.resources

fun Context.getCompatColor(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}
