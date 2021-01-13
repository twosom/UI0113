package com.example.ui0113

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_click.*

class ClickActivity : AppCompatActivity() {


    //사용할 클래스를 미리 만들어 놓고
    //객체에 주입.
    inner class ClickImpl : View.OnClickListener {
        override fun onClick(v: View) {
            if (v.id == btn1.id) {
                //Toast.makeText(this@ClickActivity, "버튼1 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
                //로그 출력
                Log.e("클릭", "버튼1 클릭");
                //스낵바 출력
                Snackbar.make(v, "버튼1 클릭", Snackbar.LENGTH_LONG).show();
            } else if (v.id == btn2.id) {
                //Toast.makeText(this@ClickActivity, "버튼1 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
                //로그 출력
                Log.e("클릭", "버튼2 클릭");
                //스낵바 출력
                Snackbar.make(v, "버튼2 클릭", Snackbar.LENGTH_LONG).show();
            } else if (v.id == btn3.id) {
                //Toast.makeText(this@ClickActivity, "버튼1 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
                //로그 출력
                Log.e("클릭", "버튼3 클릭");
                //스낵바 출력
                Snackbar.make(v, "버튼3 클릭", Snackbar.LENGTH_LONG).show();
            } else if (v.id == btn4.id) {
                //Toast.makeText(this@ClickActivity, "버튼1 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
                //로그 출력
                Log.e("클릭", "버튼4 클릭");
                //스낵바 출력
                Snackbar.make(v, "버튼4 클릭", Snackbar.LENGTH_LONG).show();
            }


        }
    }

    fun click(v: View) {
        //Toast.makeText(applicationContext, "버튼2 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
        Log.e("클릭", "버튼4 클릭")
        Snackbar.make(v, "버튼4 클릭", Snackbar.LENGTH_LONG).show();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)

//        btn1.setOnClickListener(ClickImpl())
//
//        btn2.setOnClickListener(object:View.OnClickListener{
//            override fun onClick(v: View) {
//                //Toast.makeText(applicationContext, "버튼2 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
//                Log.e("클릭", "버튼2 클릭")
//                Snackbar.make(v, "버튼2 클릭", Snackbar.LENGTH_LONG).show();
//            }
//
//        })
//
//        btn3.setOnClickListener{
//            //Toast.makeText(applicationContext, "버튼3 클릭 이벤트 처리", Toast.LENGTH_SHORT).show()
//            v:View ->
//            Log.e("클릭", "버튼3 클릭")
//            Snackbar.make(v, "버튼3 클릭", Snackbar.LENGTH_LONG).show();
//        }

        val clickImpl = ClickImpl()
        /*
        btn1.setOnClickListener(clickImpl)
        btn2.setOnClickListener(clickImpl)
        btn3.setOnClickListener(clickImpl)
         */

        val ar = arrayOf<Button>(btn1, btn2, btn3)
        for (btn in ar) {
            btn.setOnClickListener(clickImpl);
        }
        btnTimer.setOnClickListener {
            v:View ->

            val timer = object : CountDownTimer(10000, 1000) {
                var i = 0
                override fun onTick(millisUntilFinished: Long) {
                    i = i + 1
                    btnTimer.text = i.toString()
                    Log.e("i", i.toString())
                    //Toast.makeText(applicationContext, i.toString(), Toast.LENGTH_SHORT).show()
                    Snackbar.make(v, i.toString(), Snackbar.LENGTH_SHORT).show()
                }

                override fun onFinish() {
                    btnTimer.text = "타이머 다시 시작"
                }
            }
            timer.start()
        }


    }
}