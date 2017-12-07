package com.jadulco.jadulco_finallabquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MikaA on 11/23/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    Context context;

    public DBHelper(Context context) {
        super(context, "grades.sqlite", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE famous_quotes (_ID INTEGER PRIMARY KEY AUTOINCREMENT, AUTHOR TEXT, QUOTE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData (String author, String quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("author", author);
        cv.put("quote", quote);
        long result = db.insert("famous_quotes", null, cv);

        if (result == -1)
            return  false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM famous_quotes", null);
    }


}

