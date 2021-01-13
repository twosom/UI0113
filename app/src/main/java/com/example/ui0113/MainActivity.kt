package com.example.ui0113

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_click.*

class MainActivity : AppCompatActivity() {
    //뷰 클래스
    //View 클래스는 매개변수가 없는 생성자가 없기 때문에
    //생성자에서 대입받아서 넘겨주어야 함.
    inner class MyView(context: Context) : View(context) {
        /*
        //내부에 컬래스를 만든 경우 외부 클래스의 객체를 지정하고 싶으면
        //this@외부클래스 이름 형태로 작성하면 됨.
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            Toast.makeText(this@MainActivity, "터치", Toast.LENGTH_SHORT).show()
            return super.onTouchEvent(event)
        }

         */

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val myView = MyView(this)
        //사용자 정의 뷰를 Activity의 전체화면으로 설정.
        setContentView(myView)

        //인터페이스를 구현할 클래스 생성
        /*
        class TouchImpl : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Toast.makeText(this@MainActivity, "클래스를 만들어서 구현", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        myView.setOnTouchListener(TouchImpl())
         */

        //anonymous class 를 만들어서 처리
        /*
        myView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Toast.makeText(this@MainActivity, "익명 클래스를 만들어서 구현", Toast.LENGTH_SHORT);
                return false;
            }

        })
         */

        //SAM 방법을 이용한 이벤트
        //메소드가 1개인 인터페이스인 경우만 사용 가능
        myView.setOnTouchListener({
            v:View?, event:MotionEvent? ->
            Toast.makeText(this@MainActivity, "SAM을 이용한 이벤트 처리", Toast.LENGTH_SHORT).show();
            true
        });


        myView.setOnClickListener{
            Toast.makeText(this@MainActivity, "SAM onClick", Toast.LENGTH_SHORT).show();
            true;
        }




    }


//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        //MotionEvent? 이므로 null 허용타입.
//        //이 경우 프로퍼티를 호출할 때 ? 또는 !! 등을 이용해서 null 처리를 해야 한다.
//        var x: Int = event?.rawX!!.toInt()
//
//        var y: Int = event?.rawY!!.toInt()
//
//        Toast.makeText(this, "x : ${x}, y : ${y}", Toast.LENGTH_SHORT).show();
//
//        return super.onTouchEvent(event)
//    }
    
    
    

}