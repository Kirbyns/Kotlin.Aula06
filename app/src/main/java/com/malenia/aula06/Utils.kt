package com.malenia.aula06

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alert(titulo: String,msg: String, context: Context){
    AlertDialog.Builder(context)
        .setTitle(titulo)
        .setMessage(msg)
        .setPositiveButton("ok",null)
        .create()
        .show()
}