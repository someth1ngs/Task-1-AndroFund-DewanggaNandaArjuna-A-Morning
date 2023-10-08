package com.example.task_1_androfund_dewangganandaarjuna_a_morning

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username:String,
    val password:String
): Parcelable
