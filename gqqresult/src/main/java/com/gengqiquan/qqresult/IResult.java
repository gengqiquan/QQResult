package com.gengqiquan.qqresult;

import android.content.Intent;

public interface IResult {
    void result(Intent intent);

    void cancel();
}
