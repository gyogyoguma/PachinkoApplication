package com.example.pachinkoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Counter extends AppCompatActivity {
    //フィールド変数(現クラスのどのメソッドでも利用可能な変数)
    int start = 0;
    int total = 0;
    int probability = 0;
    int cherry;
    int replay;
    int watermelon;
    int bell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // ボタンを設定
        Button start_commit = findViewById(R.id.start_commit);
        Button total_commit = findViewById(R.id.total_commit);
        Button total_sub = findViewById(R.id.total_sub);
        Button total_add = findViewById(R.id.total_add);
        ImageButton cherry = findViewById(R.id.cherry_button);
        ImageButton replay = findViewById(R.id.replay_button);
        ImageButton watermelon = findViewById(R.id.watermelon_button);
        ImageButton bell = findViewById(R.id.bell_button);
        ImageButton reset = findViewById(R.id.reset_button);

        //setOnClickListenerの登録
        cherry.setOnClickListener(onClick_Cherry_button);
        replay.setOnClickListener(onClick_Replay_button);
        watermelon.setOnClickListener(onClick_Watermelon_button);
        bell.setOnClickListener(onClick_Bell_button);
        reset.setOnClickListener(onClick_Reset_button);
        start_commit.setOnClickListener(onClick_StartCommit_button);
        total_commit.setOnClickListener(onClick_TotalCommit_button);
        total_sub.setOnClickListener(onClick_TotalSub_button);
        total_add.setOnClickListener(onClick_TotalAdd_button);
    }

    //Cherryが押下された時の処理
    private View.OnClickListener onClick_Cherry_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //cherryが押下された際に1を追加し、cherry_coutに表示する
            cherry = cherry + 1;
            TextView cherry_count = (TextView) findViewById(R.id.cherry_count);
            TextView cherry_probability = (TextView) findViewById(R.id.cherry_probability);
            cherry_count.setText(String.valueOf(cherry));    //TextViewに文字列をセット
            if (total != 0) {
                double probability = (double)total / cherry;
                double cherry_rounding = ((double)Math.round(probability * 10))/10;
                String cherry_text = "1/" + String.valueOf(cherry_rounding);
                cherry_probability.setText(cherry_text);    //TextViewに文字列をセット
            }

        }
    };

    //Replayが押下された時の処理
    private View.OnClickListener onClick_Replay_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載

        }
    };

    //Watermelonが押下された時の処理
    private View.OnClickListener onClick_Watermelon_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載

        }
    };

    //Bellが押下された時の処理
    private View.OnClickListener onClick_Bell_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載

        }
    };

    //Resetが押下された時の処理
    private View.OnClickListener onClick_Reset_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載

        }
    };

    //StartCommit(確定)が押下された時の処理
    private View.OnClickListener onClick_StartCommit_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載
            EditText start_edit = (EditText) findViewById(R.id.start_edit);
            TextView start_text = (TextView) findViewById(R.id.start_text);
            String text = start_edit.getText().toString();    //EditText(テキストボックス)から文字列を取得
            if (!text.equals("")) {
                start = Integer.parseInt(text);
                start_text.setText(text);    //TextViewに文字列をセット
                start_edit.setText("");
            }
        }
    };

        //TotalCommit(確定)が押下された時の処理
        private View.OnClickListener onClick_TotalCommit_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                EditText total_edit = (EditText) findViewById(R.id.total_edit);
                TextView total_text = (TextView) findViewById(R.id.total_text);
                String text = total_edit.getText().toString();    //EditText(テキストボックス)から文字列を取得
                if (!text.equals("")) {
                    total = Integer.parseInt(text);
                    //開始回転数と総合回転数を
                    total = total - start;
                    total_text.setText(String.valueOf(total));    //TextViewに文字列をセット
                    total_edit.setText("");
                    total = Integer.parseInt(text);
                }
            }
        };

        //TotalSub(-1)が押下された時の処理
        private View.OnClickListener onClick_TotalSub_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                TextView total_text = (TextView) findViewById(R.id.total_text);
                String text = total_text.getText().toString();    //Text(テキストボックス)から文字列を取得
                int sum = Integer.parseInt(text);   //String型をInt型に変換
                sum = sum - 1;                      //1を減算
                total_text.setText( String.valueOf(sum));    //TextViewに文字列をセット
            }
        };

        //TotalAdd(+1)が押下された時の処理
        private View.OnClickListener onClick_TotalAdd_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                TextView total_text = (TextView) findViewById(R.id.total_text);
                String text = total_text.getText().toString();    //Text(テキストボックス)から文字列を取得
                int sum = Integer.parseInt(text);   //String型をInt型に変換
                sum = sum + 1;                      //1を加算
                total_text.setText( String.valueOf(sum));    //TextViewに文字列をセット
            }
        };
}
