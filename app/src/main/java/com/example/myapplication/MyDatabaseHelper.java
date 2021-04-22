package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER_TABLE="create table user\n" +
            "(\n" +
            "    id       integer primary key,\n" +
            "    name     text,\n" +
            "    level    integer,\n" +
            "    followed boolean\n" +
            ")";

    public static final String INIT_DATA = "INSERT INTO user (name, level, followed) VALUES ('Ned Stark', 5, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Robert Baratheon', 5, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Jaime Lannister', 4, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Daenerys Targaryen', 4, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Jon Snow', 3, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Arya Stark', 3, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Sansa Stark', 2, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Tyrion Lannister', 2, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Robb Stark', 1, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Night King', 1, 1);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Eren Yeager', 5, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Mikasa Ackerman', 5, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Armin Arlert', 4, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Reiner Braun', 4, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Bertholdt Hoover', 3, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Annie Leonhart', 3, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Sasha Blouse', 2, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Levi Ackerman', 2, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Zeke Jaeger', 1, 0);\n" +
            "INSERT INTO user (name, level, followed) VALUES ('Pieck Finger', 1, 0);\n" +
            "commit;";

    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE user");
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(INIT_DATA);
        Toast.makeText(mContext, "create database successful", Toast.LENGTH_SHORT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
