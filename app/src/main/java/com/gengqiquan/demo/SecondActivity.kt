package com.gengqiquan.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(this@SecondActivity, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()

        button.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("msg", "日落下山红霞飞"))
            finish()
        }
        jump.setOnClickListener {
            startActivityWith<ThirdActivity>(
                "key" to "哭一个", "number" to 100
            ).result({
                Toast.makeText(this@SecondActivity, it.getStringExtra("msg"), Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy", this.javaClass.name)
    }
}
