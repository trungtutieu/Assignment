package com.example.designbyann.DatabaseChiTieu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOHelper extends SQLiteOpenHelper {
    public DatabaseOHelper(Context context){
        super(context,"dbChiTieu",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableLoaiChi = "create table LoaiChi(maLC text primary key, tenLC text)";
        String createTableKhoanChi = "create table KhoanChi(maKC text primary key, tenKC text,soTien double,ngayChi text)";
        db.execSQL(createTableLoaiChi);
        db.execSQL(createTableKhoanChi);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists LoaiChi");
        db.execSQL("drop table if exists KhoanChi");
        onCreate(db);

    }


}
