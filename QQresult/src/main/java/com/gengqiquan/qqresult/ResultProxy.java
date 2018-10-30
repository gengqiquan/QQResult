package com.gengqiquan.qqresult;

import android.content.Intent;

/**
 * Created by gengqiquan on 2017/7/4.
 */

class ResultProxy implements IResult {
    Func1 func1;
    Func2 func2;

    public ResultProxy(Func1 func1, Func2 func2) {
        this.func1 = func1;
        this.func2 = func2;
    }

    @Override
    public void result(Intent intent) {
        func1.result(intent);
    }

    @Override
    public void cancel() {
        func2.cancel();
    }
}