package com.example.pachinkoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

//TextWatcherを使うと確定ボタンいらなくなりそう

import androidx.appcompat.app.AppCompatActivity;



public class Counter extends AppCompatActivity {
    //フィールド変数(現クラスのどのメソッドでも利用可能な変数)
    int start = 0;
    int total = 0;
    int cherry;
    int replay;
    int watermelon;
    int bell;
    boolean cherry_flag = false;
    boolean replay_flag = false;
    boolean watermelon_flag = false;
    boolean bell_flag = false;
    boolean start_flag = false;


    //Wighetの変数
    TextView cherry_count;
    TextView cherry_probability;
    //TextView cherry_text;
    TextView replay_count;
    TextView replay_probability;
    TextView watermelon_count;
    TextView watermelon_probability;
    TextView bell_count;
    TextView bell_probability;
    TextView start_text;
    TextView total_text;
    EditText start_edit;
    EditText total_edit;


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
            cherry_count = (TextView) findViewById(R.id.cherry_count);
            cherry_probability = (TextView) findViewById(R.id.cherry_probability);
            cherry_count.setText(String.valueOf(cherry));    //TextViewに文字列をセット
            if (total != 0) {
                double probability = (double)total / cherry;
                double cherry_rounding = ((double)Math.round(probability * 10))/10;
                String cherry_text = "1/" + String.valueOf(cherry_rounding);
                cherry_probability.setText(cherry_text);    //TextViewに文字列をセット
            }
            cherry_flag = true;
        }
    };

    //Replayが押下された時の処理
    private View.OnClickListener onClick_Replay_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Replayが押下された際に1を追加し、replay_coutに表示する
            replay = replay + 1;
            replay_count = (TextView) findViewById(R.id.replay_count);
            replay_probability = (TextView) findViewById(R.id.replay_probability);
            replay_count.setText(String.valueOf(replay));    //TextViewに文字列をセット
            if (total != 0) {
                double probability = (double) total / replay;
                double replay_rounding = ((double) Math.round(probability * 10)) / 10;
                String replay_text = "1/" + String.valueOf(replay_rounding);
                replay_probability.setText(replay_text);    //TextViewに文字列をセット
            }
            replay_flag = true;
        }
    };

    //Watermelonが押下された時の処理
    private View.OnClickListener onClick_Watermelon_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Watermelonが押下された際に1を追加し、replay_coutに表示する
            watermelon = watermelon + 1;
            watermelon_count = (TextView) findViewById(R.id.watermelon_count);
            watermelon_probability = (TextView) findViewById(R.id.watermelon_probability);
            watermelon_count.setText(String.valueOf(watermelon));    //TextViewに文字列をセット
            if (total != 0) {
                double probability = (double) total / watermelon;
                double watermelon_rounding = ((double) Math.round(probability * 10)) / 10;
                String replay_text = "1/" + String.valueOf(watermelon_rounding);
                watermelon_probability.setText(replay_text);    //TextViewに文字列をセット
            }
            watermelon_flag = true;
        }
    };


    //Bellが押下された時の処理
    private View.OnClickListener onClick_Bell_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Bellが押下された際に1を追加し、replay_coutに表示する
            bell = bell + 1;
            bell_count = (TextView) findViewById(R.id.bell_count);
            bell_probability = (TextView) findViewById(R.id.bell_probability);
            bell_count.setText(String.valueOf(bell));    //TextViewに文字列をセット
            if (total != 0) {
                double probability = (double) total / bell;
                double bell_rounding = ((double) Math.round(probability * 10)) / 10;
                String replay_text = "1/" + String.valueOf(bell_rounding);
                bell_probability.setText(replay_text);    //TextViewに文字列をセット
            }
            bell_flag = true;
        }
    };

    //Resetが押下された時の処理
    private View.OnClickListener onClick_Reset_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //開始回転数をリセットする
            start = 0;
            start_text = (TextView) findViewById(R.id.start_text);
            start_text.setText(String.valueOf(start));
            start_flag = false;
            //総合回転数をリセットする
            total = 0;
            total_text = (TextView) findViewById(R.id.total_text);
            total_text.setText(String.valueOf(total));
            //cherryをリセットする
            cherry = 0;
            cherry_count = (TextView) findViewById(R.id.cherry_count);
            cherry_probability = (TextView) findViewById(R.id.cherry_probability);
            cherry_count.setText(String.valueOf(cherry));    //TextViewに文字列をセット
            cherry_probability.setText("1/" + cherry);    //TextViewに文字列をセット
            cherry_flag = false;
            //replayをリセットする
            replay = 0;
            replay_count = (TextView) findViewById(R.id.replay_count);
            TextView replay_probability = (TextView) findViewById(R.id.replay_probability);
            replay_count.setText(String.valueOf(replay));    //TextViewに文字列をセット
            replay_probability.setText("1/" + replay);    //TextViewに文字列をセット
            replay_flag = false;
            //watermelonをリセットする
            watermelon =0;
            watermelon_count = (TextView) findViewById(R.id.watermelon_count);
            watermelon_probability = (TextView) findViewById(R.id.watermelon_probability);
            watermelon_count.setText(String.valueOf(watermelon));    //TextViewに文字列をセット
            watermelon_probability.setText("1/" + watermelon);    //TextViewに文字列をセット
            watermelon_flag = false;
            //bellをリセットする
            bell = 0;
            bell_count = (TextView) findViewById(R.id.bell_count);
            bell_probability = (TextView) findViewById(R.id.bell_probability);
            bell_count.setText(String.valueOf(bell));    //TextViewに文字列をセット
            bell_probability.setText("1/" + bell);    //TextViewに文字列をセット
            bell_flag = false;
            SetUp();
        }
    };

    //StartCommit(確定)が押下された時の処理
    private View.OnClickListener onClick_StartCommit_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //押下された時の処理を記載
            start_edit = (EditText) findViewById(R.id.start_edit);
            start_text = (TextView) findViewById(R.id.start_text);
            String text = start_edit.getText().toString();    //EditText(テキストボックス)から文字列を取得
            if (!text.equals("")) {
                start = Integer.parseInt(text);
                start_text.setText(text);    //TextViewに文字列をセット
                start_edit.setText("");
                start_flag = true;
            }
            if (start_flag){
                //開始回転数と総合回転数を
                total = total - start;
                total_text.setText(String.valueOf(total));    //TextViewに文字列をセット
                SetUp();
            }
            start_flag = false;
        }
    };

        //TotalCommit(確定)が押下された時の処理
        private View.OnClickListener onClick_TotalCommit_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                total_edit = (EditText) findViewById(R.id.total_edit);
                total_text = (TextView) findViewById(R.id.total_text);
                String text = total_edit.getText().toString();    //EditText(テキストボックス)から文字列を取得
                if (!text.equals("")) {
                    total = Integer.parseInt(text);
                    //開始回転数と総合回転数を
                    total = total - start;
                    total_text.setText(String.valueOf(total));    //TextViewに文字列をセット
                    total_edit.setText("");
                    total = Integer.parseInt(text);
                }
                SetUp();
            }
        };

        //TotalSub(-1)が押下された時の処理
        private View.OnClickListener onClick_TotalSub_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                total_text = (TextView) findViewById(R.id.total_text);
                String text = total_text.getText().toString();    //Text(テキストボックス)から文字列を取得
                int sum = Integer.parseInt(text);   //String型をInt型に変換
                total = sum - 1;                      //1を減算
                total_text.setText( String.valueOf(total));    //TextViewに文字列をセット
                SetUp();
            }
        };

        //TotalAdd(+1)が押下された時の処理
        private View.OnClickListener onClick_TotalAdd_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押下された時の処理を記載
                total_text = (TextView) findViewById(R.id.total_text);
                String text = total_text.getText().toString();    //Text(テキストボックス)から文字列を取得
                int sum = Integer.parseInt(text);   //String型をInt型に変換
                total = sum + 1;                      //1を加算
                total_text.setText( String.valueOf(total));    //TextViewに文字列をセット
                SetUp();
            }
        };

        private void SetUp() {
            if (total != 0) {
                if (cherry_flag) {
                    cherry_probability.setText("1/" + String.valueOf(((double)Math.round((double)total / cherry * 10))/10));
                }
                if (replay_flag) {
                    replay_probability.setText("1/" + String.valueOf(((double) Math.round((double)total / replay * 10)) / 10));
                }
                if (watermelon_flag) {
                    watermelon_probability.setText("1/" + String.valueOf(((double) Math.round((double)total / watermelon * 10)) / 10));
                }
                if (bell_flag) {
                    bell_probability.setText("1/" + String.valueOf(((double) Math.round((double)total / bell * 10)) / 10));
                }
            }
        }
}
