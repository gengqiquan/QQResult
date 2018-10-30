# RxActivityResult
 Obtain results intent from startActivityForResult() to be callback.
 
 Use fragemnt as proxy


## use in java 
```
     QQResult.startActivityWith(MainActivity.this, SecondActivity.class)
                             .putString("key", "笑一个")
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

### use in kotlin with anko
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
compile 'com.gengqiquan:QQResult:0.0.1'
```

