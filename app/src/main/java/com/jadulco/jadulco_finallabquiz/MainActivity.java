package com.jadulco.jadulco_finallabquiz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    EditText et_author, et_quote;
    Button bt_save, bt_next;
    DBHelper helper = new DBHelper(this);
    SQLiteDatabase dbase;
    Cursor res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_author = (EditText) findViewById(R.id.et_author);
        et_quote = (EditText) findViewById(R.id.et_quote);
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_next = (Button) findViewById(R.id.bt_next);
        helper = new DBHelper(this);
        dbase = helper.getWritableDatabase();
        res = helper.getAllData();

    }

    public void saveRecord (View view) {
        String author, quote;
        author = et_author.getText().toString();
        quote = et_quote.getText().toString();
        boolean isInserted = helper.insertData(author, quote);
        if(isInserted==true)
            Toast.makeText(this, "Data Inserted!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data Insertion failed!", Toast.LENGTH_SHORT).show();
        res.close();
        res = helper.getAllData();
    }

    public void showRecord (View view) {
            displayRecord();
    }

    private void displayRecord() {


    }
}
