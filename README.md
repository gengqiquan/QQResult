# QQResult
 Obtain results intent from startActivityForResult() to be callback.
 
 Use fragemnt as proxy

[![GitHub experimental release version](https://img.shields.io/github/release/gengqiquan/QQResult/all.svg?label=Experimental&maxAge=600)](https://github.com/gengqiquan/QQResult/releases)
[![GitHub experimental release date](https://img.shields.io/github/release-date-pre/gengqiquan/QQResult.svg?label=Released&maxAge=600)](https://github.com/gengqiquan/QQResult/releases)
[![Github experimental release downloads](https://img.shields.io/github/downloads-pre/gengqiquan/QQResult/latest/total.svg?label=Downloads&maxAge=600)](https://github.com/gengqiquan/QQResult/releases)

## use in java 
```
     QQResult.startActivityWith(MainActivity.this, SecondActivity.class)
                             .put("key", "笑一个")
                             .result(new IResult() {
                                 @Override
                                 public void result(Intent intent) {
                                     tv.setText(intent.getStringExtra("msg"));
                                 }

                                 @Override
                                 public void cancel() {

                                 }
                             });
```

### use in kotlin
call in activity or fragment
```
 startActivityWith<ThirdActivity>(
                "key" to "哭一个", "number" to 100
            ).result({
                Toast.makeText(this@SecondActivity, it.getStringExtra("msg"), Toast.LENGTH_SHORT).show()
            })
```

## gradle
```

compile 'com.gengqiquan:QQResult:0.0.3'

```

# Transform
java
```
 QQResult.startActivityWith(MainActivity.this, SecondActivity.class)
                        .put("key", "笑一个")
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
```
kotlin
```
     startActivityWith<ThirdActivity>(
                "key" to "哭一个", "number" to 100
            )
                .toObservable()
                .subscribe({
                Toast.makeText(this@SecondActivity, it.getStringExtra("msg"), Toast.LENGTH_SHORT).show()
                })

```
## gradle
```
compile 'com.gengqiquan:result-adapter-rxjava:0.0.3'
```
