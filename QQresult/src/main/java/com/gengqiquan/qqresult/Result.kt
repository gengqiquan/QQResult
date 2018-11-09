package com.gengqiquan.qqresult

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import java.io.Serializable
import java.util.*

inline fun <reified T : Activity> Activity.startActivityWith(
    vararg params: Pair<String, Any?>
): QQResult.Builder = QQResult.startActivityWith(this, T::class.java).putAll(Bundle().pair(params))

inline fun <reified T : Activity> Fragment.startActivityWith(
    vararg params: Pair<String, Any>
) = QQResult.startActivityWith(this.context, T::class.java).putAll(Bundle().pair(params))

inline fun <reified T : Activity> startActivityWith(
    context: Context, vararg params: Pair<String, Any?>
): QQResult.Builder = QQResult.startActivityWith(context, T::class.java).putAll(Bundle().pair(params))

fun Bundle.pair(params: Array<out Pair<String, Any?>>): Bundle {
    val bundle = this
    params.forEach {
        bundle.put(it.first, it.second)
    }
    return bundle
}

fun Bundle.pairs(vararg params: Pair<String, Any>): Bundle {
    val bundle = this
    params.forEach {
        bundle.put(it.first, it.second)
    }
    return bundle
}

fun Bundle.put(key: String, value: Any?): Bundle {
    val bundle = this
    when (value) {
        null -> bundle.putSerializable(key, null as Serializable?)
        is Int -> bundle.putInt(key, value)
        is Long -> bundle.putLong(key, value)
        is CharSequence -> bundle.putCharSequence(key, value)
        is String -> bundle.putString(key, value)
        is Float -> bundle.putFloat(key, value)
        is Double -> bundle.putDouble(key, value)
        is Char -> bundle.putChar(key, value)
        is Short -> bundle.putShort(key, value)
        is Boolean -> bundle.putBoolean(key, value)
        is Serializable -> bundle.putSerializable(key, value)
        is Bundle -> bundle.putBundle(key, value)
        is Parcelable -> bundle.putParcelable(key, value)
        is Array<*> -> when {
            value.isArrayOf<CharSequence>() -> bundle.putCharSequenceArrayList(
                key,
                value as ArrayList<CharSequence>
            )
            value.isArrayOf<String>() -> bundle.putStringArrayList(key, value as ArrayList<String>)
            value.isArrayOf<Parcelable>() -> bundle.putParcelableArrayList(
                key,
                value as ArrayList<out Parcelable>
            )
            else -> throw Exception("bundle extra ${key} has wrong type ${value.javaClass.name}")
        }
        is IntArray -> bundle.putIntArray(key, value)
        is LongArray -> bundle.putLongArray(key, value)
        is FloatArray -> bundle.putFloatArray(key, value)
        is DoubleArray -> bundle.putDoubleArray(key, value)
        is CharArray -> bundle.putCharArray(key, value)
        is ShortArray -> bundle.putShortArray(key, value)
        is BooleanArray -> bundle.putBooleanArray(key, value)
        else -> throw Exception("bundle extra ${key} has wrong type ${value.javaClass.name}")
    }
    return bundle
}