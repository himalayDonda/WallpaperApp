package com.example.wallpaperapp.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

fun <T> Activity.openActivity(
    activity: Class<T>,
    bundle: Bundle? = null,
) {
    val intent = Intent(this, activity)
    if (bundle != null){
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

fun <T> Fragment.openActivity(
    activity: Class<T>,
    bundle: Bundle? = null,
) {
    val intent = Intent(requireActivity(), activity)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

fun Activity.showToast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun Fragment.showToast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), text, length).show()
}