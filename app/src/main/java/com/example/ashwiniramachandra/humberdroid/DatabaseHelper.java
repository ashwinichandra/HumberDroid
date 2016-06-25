package com.example.ashwiniramachandra.humberdroid;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME ";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "MARKS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + TABLE_NAME
                + "("
                + COL_1 + " integer primary key autoincrement, "
                + COL_2 + " text not null, "
                + COL_3 + " text not null,"
                + COL_4 + " integer"
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + TABLE_NAME);
        onCreate(db);

    }

    public boolean insert(String firstname, String lastname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, firstname);
        contentValues.put(COL_3, lastname);
        contentValues.put(COL_4, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);
        return res;
    }

    public boolean update(String id, String firstname, String lastname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, firstname);
        contentValues.put(COL_3, lastname);
        contentValues.put(COL_4, marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{ id });
        return true;
    }

    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[]{ id });
    }

}
