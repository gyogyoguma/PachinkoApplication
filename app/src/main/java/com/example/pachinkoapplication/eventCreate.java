package com.example.pachinkoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class eventCreate extends AppCompatActivity {
private SQLiteDatabaseHelper helper = null;
private EditText txtYear = null;
    private EditText txtMonth = null;
    private EditText txtDay= null;
    private EditText txtMemo= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        //ヘルパーを準備
        helper = new SQLiteDatabaseHelper(this);
        txtYear= findViewById(R.id.txtYear);
        txtMonth= findViewById(R.id.txtMonth);
        txtDay= findViewById(R.id.txtDay);
        txtMemo= findViewById(R.id.txtMemo);
    }
   // public void onSave(Calendar calendar){
    public void onSave(View view){


        // インスタンス化
        Calendar calendar = new Calendar();
       // String sample = String.valueOf(year);
        try(SQLiteDatabase db = helper.getWritableDatabase()) {
            ContentValues cv = new ContentValues();
            cv.put("year", txtYear.getText().toString());
            cv.put("title", txtMonth.getText().toString());
            cv.put("txtDay", txtDay.getText().toString());
            cv.put("txtMemo", txtMemo.getText().toString());
            db.insert("calendar", null, cv);
            Toast.makeText(this, "データの登録に成功しました", Toast.LENGTH_SHORT).show();
            
        }
    }

    public void onDelete(View view){
        try(SQLiteDatabase db = helper.getWritableDatabase()){
          String[] params = {txtYear.getText().toString()};
          db.delete("calendar","year= ?",params);

            Toast.makeText(this,"データの削除に成功しました",Toast.LENGTH_SHORT).show();

        }


    }
    public void onSearch(View view){

            String[] cols ={"isbn","title","price"};
            String[] params={txtYear.getText().toString()};
        try(SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cs = db.query("calendar",cols,"year= ?",params,null,null,null,null)){
    if(cs.moveToFirst()){
        txtMonth.setText(cs.getString(1));
        txtDay.setText(cs.getString(2));
        txtMemo.setText(cs.getString(3));

    }else {
        Toast.makeText(this,"データがありません",Toast.LENGTH_SHORT).show();
    }
            }





    }



}