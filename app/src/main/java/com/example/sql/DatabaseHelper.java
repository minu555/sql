package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "employee.db";
    public static final String TABLE_NAME = "employee_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "EMAIL";
    public static final String COL4 = "PHONE";





    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT, EMAIL TEXT, PHONE TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS users_data");
        onCreate(db);
    }

    public boolean addData(String Mname, String Memail, String Mphone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Mname);
        contentValues.put(COL3, Memail);
        contentValues.put(COL4, Mphone);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
