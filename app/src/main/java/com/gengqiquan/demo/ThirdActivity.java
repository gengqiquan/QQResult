package com.gengqiquan.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toast.makeText(this, getIntent().getStringExtra("key"), Toast.LENGTH_SHORT).show();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK, new Intent().putExtra("msg", "壮士打靶把营归"));
                finish();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", this.getClass().getName());
    }
}
