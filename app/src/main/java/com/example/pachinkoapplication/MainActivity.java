package com.example.pachinkoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //どのレイアウトを画面として表示させるのかを設定する
        setContentView(R.layout.activity_main);

        findViewById(R.id.chara).startAnimation(AnimationUtils.loadAnimation(this, R.anim.up_down));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // ボタンを設定
        Button calendar_button = findViewById(R.id.calendar_button);
        Button counter_button = findViewById(R.id.counter_button);
        calendar_button.setOnClickListener(onCalendarClick_button);
        counter_button.setOnClickListener(onCounterClick_button);
    }

    //calendar_buttonが押下された時の処理
    private View.OnClickListener onCalendarClick_button = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //MainActivityクラスから、Calendarクラスへ遷移
            Intent intent = new Intent(MainActivity.this,com.example.pachinkoapplication.Calendar.class);
            startActivity(intent);
        }
    };

    //counter_buttonが押下された時の処理
    private View.OnClickListener onCounterClick_button = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //MainActivityクラスから、Counterクラスへ遷移
            Intent intent = new Intent(MainActivity.this,com.example.pachinkoapplication.Counter.class);
            startActivity(intent);
        }
    };
}