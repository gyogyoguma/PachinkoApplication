package com.example.pachinkoapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Calendar extends AppCompatActivity {
    String dayData= null;
    private SQLiteDatabaseHelper helper = null;
    private EditText txtMemo= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        helper = new SQLiteDatabaseHelper(this);
        try(SQLiteDatabase db = helper.getWritableDatabase()) {

            Toast.makeText(this, "接続", Toast.LENGTH_SHORT).show();

            //ヘルパーを準備
            txtMemo = findViewById(R.id.editMemo);
        }

        final CalendarView calendarView = new CalendarView(this);
// 日付が変更した時に呼ばれるコールバックインターフェースを設定
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("you" , year + "年" + (month + 1) + "月" + dayOfMonth + "日");
            }
        });



        // CalendarViewにリスナーを設定
       ((CalendarView) findViewById(R.id.calendarView)).setOnDateChangeListener(listener);



    }
    @Override
    protected void onResume() {
        super.onResume();
        // ボタンを設定
        Button save_button = findViewById(R.id.btnSave);
        Button delete_button = findViewById(R.id.btnDelete);
        save_button.setOnClickListener(onSave_button);
        delete_button.setOnClickListener(onDelete_button);
    }



    /**
     * カレンダーの日付部分タップ時のリスナー
     */

    CalendarView.OnDateChangeListener listener = new CalendarView.OnDateChangeListener() {

        /**
         * 日付部分タップ時に実行される処理
         * @param view 押下されたカレンダーのインスタンス
         * @param year タップされた日付の「年」
         * @param month タップされた日付の「月」※月は0月から始まるから、+1して調整が必要
         * @param dayOfMonth タップされた日付の「日」
         */
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
      LinearLayout memoView = findViewById(R.id.memoLayout);
            memoView.setVisibility(view.VISIBLE);

            //主キーdayData
            String sample = String.valueOf(year);
            String sample2 = String.valueOf(month+1);
            String sample3 = String.valueOf(dayOfMonth);
            dayData =(sample+sample2+sample3);

            String[] cols ={"year","memo"};
            String[] params={dayData};
            try(SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cs = db.query("calendar_tables",cols,"year= ?",params,null,null,null,null)){
                if(cs.moveToFirst()){
                    txtMemo.setText(cs.getString(1));

                }else {
                    Toast.makeText(getApplicationContext(), "データがありません", Toast.LENGTH_SHORT).show();
                    txtMemo.setText("");
                }
            }
        }
    };


    //onSave_buttonが押下された時の処理
    private View.OnClickListener onSave_button = new View.OnClickListener(){


        @Override
        public void onClick(View v) {

            try(SQLiteDatabase db = helper.getWritableDatabase()) {
                ContentValues cv = new ContentValues();
                cv.put("year", dayData);
                cv.put("memo",txtMemo.getText().toString());
                db.insertWithOnConflict("calendar_tables", null, cv,SQLiteDatabase.CONFLICT_REPLACE);
                Toast.makeText(getApplicationContext(), "登録", Toast.LENGTH_SHORT).show();

            }
            Toast.makeText(getApplicationContext(), dayData+"hoznn", Toast.LENGTH_SHORT).show();
        }
    };

    //onDelete_buttonが押下された時の処理
    private View.OnClickListener onDelete_button = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            try(SQLiteDatabase db = helper.getWritableDatabase()){
                String[] params = {dayData};
                db.delete("calendar_tables","year= ?",params);
                Toast.makeText(getApplicationContext(), "削除", Toast.LENGTH_SHORT).show();

            }
        }
    };
}