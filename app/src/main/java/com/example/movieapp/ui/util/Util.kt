package com.example.movieapp.ui.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.movieapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object Util {

    fun makeToast(context: Context,message:String , length:Int){
        Toast.makeText(context, message , length).show()
    }

}