package org.battir.personsform

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name:String, val ID:Int, val emai:String, val web:String):Parcelable

