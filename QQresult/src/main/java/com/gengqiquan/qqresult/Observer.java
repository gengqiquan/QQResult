package com.gengqiquan.qqresult;

import android.content.Intent;

interface Observer {
    void update(int resultCode, Intent data);
}
