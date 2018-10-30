package com.gengqiquan.rxresultadapter;

import android.content.Intent;
import com.gengqiquan.qqresult.IResult;
import com.gengqiquan.qqresult.IResultAdapter;
import com.gengqiquan.qqresult.QQResult;
import rx.Observable;
import rx.Subscriber;

public class RxResultAdapterFactory {

    public static IResultAdapter<Observable<Intent>> create() {
        return new IResultAdapter<Observable<Intent>>() {
            @Override
            public Observable<Intent> adapter(final QQResult.Builder builder) {
                return Observable.create(new Observable.OnSubscribe<Intent>() {
                    @Override
                    public void call(final Subscriber<? super Intent> subscriber) {
                        builder.result(new IResult() {
                            @Override
                            public void result(Intent intent) {
                                subscriber.onNext(intent);
                            }

                            @Override
                            public void cancel() {
                                subscriber.onCompleted();
                            }
                        });
                    }
                });
            }
        };
    }
}
