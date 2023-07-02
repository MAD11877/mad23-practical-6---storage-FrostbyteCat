package com.example.mad_wk2practical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class dbHandler extends SQLiteOpenHelper{
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "users.db";
    public static  String USERS_TABLE = "users";
    public static String COLUMN_USERNAME = "Username";
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_ID = "ID";
    public static String COLUMN_FOLLOWED = "Followed";

    public dbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE + "(" +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FOLLOWED + " TEXT)";


        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    public void addUser(User userData){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, userData.getUserName());
        values.put(COLUMN_DESCRIPTION, userData.getUserDescription());
        values.put(COLUMN_ID, userData.getId());
        values.put(COLUMN_FOLLOWED, userData.getIsFollowed());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(USERS_TABLE, null, values);
        db.close();
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> userList = new ArrayList<User>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + USERS_TABLE, null);
        while (cursor.moveToNext()){
            User user = new User();
            user.name = cursor.getString(0);
            user.description = cursor.getString(1);
            user.id = cursor.getInt(2);
            user.followed = Boolean.parseBoolean(cursor.getString(3));
            userList.add(user);
        }

        return userList;
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(
                "UPDATE User " +
                "SET Followed = \""+
                user.followed +"\" " +
                "WHERE id = \""+
                user.id +"\""
                );

        db.close();
    }
}
