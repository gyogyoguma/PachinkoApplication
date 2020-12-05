package com.example.pachinkoapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "pachinco.sqlite" ;
    static final private int VERSION = 1 ;

    //コンストラクター
    SQLiteDatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //データベース作成時にテーブルとテストデータを作成
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE calender (year INTEGER PRIMARY KEY,month INTEGER PRIMARY KEY, day INTEGER PRIMARY KEY,memo TEXT)");
    }

    //データベースをバージョンアップした時、テーブルを再作成
    @Override
    public void onUpgrade(SQLiteDatabase db, int old_v, int new_v) {
        db.execSQL("DROP TABLE IF EXISTS day");
        onCreate(db);
    }

}
