package com.gengqiquan.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.gengqiquan.qqresult.IResult;
import com.gengqiquan.qqresult.QQResult;
import com.gengqiquan.rxresultadapter.RxResultAdapterFactory;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.jump);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QQResult.startActivityWith(MainActivity.this, SecondActivity.class)
                        .putString("key", "笑一个")
                        .transform(RxResultAdapterFactory.create())
                        .subscribe(new Subscriber<Intent>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Intent intent) {
                                tv.setText(intent.getStringExtra("msg"));
                            }
                        });

//                        .result(new IResult() {
//                            @Override
//                            public void result(Intent intent) {
//                                tv.setText(intent.getStringExtra("msg"));
//                            }
//
//                            @Override
//                            public void cancel() {
//
//                            }
//                        });
            }
        });
    }

}
