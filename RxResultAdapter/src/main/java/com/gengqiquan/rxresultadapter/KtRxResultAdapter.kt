package com.gengqiquan.rxresultadapter

import android.content.Intent
import com.gengqiquan.qqresult.IResult
import com.gengqiquan.qqresult.QQResult
import rx.Observable

fun QQResult.Builder.toObservable() = Observable.create<Intent> { emitter ->
    this.result(object : IResult {
        override fun result(intent: Intent?) {
            emitter.onNext(intent)
        }

        override fun cancel() {
            emitter.onCompleted()
        }
    })
}

fun QQResult.Builder.toNonNullObservable() = Observable.create<Intent> { emitter ->
    this.result(object : IResult {
        override fun result(intent: Intent?) {
            try {
                emitter.onNext(intent!!)
            } catch (e: Exception) {
                emitter.onError(Exception("result data can not be null"))
            }
        }

        override fun cancel() {
            emitter.onCompleted()
        }
    })
}