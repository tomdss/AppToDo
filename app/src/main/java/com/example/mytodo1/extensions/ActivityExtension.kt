package com.example.mytodo1.extensions

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

fun AppCompatActivity.showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showSnackBar(message: String){
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
}