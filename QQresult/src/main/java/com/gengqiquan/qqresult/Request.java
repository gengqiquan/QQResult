package com.gengqiquan.qqresult;


import android.content.Intent;

class Request {
    protected void post(int resultCode, Intent data) {
        observer.update(resultCode, data);
    }


    protected void subscribe(Observer observer) {

        this.observer = observer;
    }

    Observer observer;

    public Request(Intent intent) {
        this.intent = intent;
    }

    Intent intent;
}



