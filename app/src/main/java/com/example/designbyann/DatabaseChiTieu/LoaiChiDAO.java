package com.example.designbyann.DatabaseChiTieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;

import java.util.ArrayList;
import java.util.List;

public class LoaiChiDAO {
    private SQLiteDatabase sqliteDB;
    private DatabaseOHelper dbHelper;
    private Context context;

    public LoaiChiDAO(Context context){
        this.context = context;
        dbHelper = new DatabaseOHelper(context);
        sqliteDB = dbHelper.getWritableDatabase();
    }
    public boolean insertLoaiChi(LoaiChi objLoaiChi){
        try {
            ContentValues values = new ContentValues();
            values.put("maLC", objLoaiChi.getMaLoaiChi());
            values.put("tenLC", objLoaiChi.getTenLoaiChi());
            long numInsert = sqliteDB.insert("LoaiChi",null,values);
            if(numInsert<=0)
                return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<LoaiChi> getAllLoaiChi(){
        List<LoaiChi> danhSachLoaiChi = new ArrayList<>();

        String sqlSelect = "select maLC, tenLC from LoaiChi";
        Cursor cursor = sqliteDB.rawQuery(sqlSelect, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String maLoaiChi = cursor.getString(0);
            String tenLoaiChi = cursor.getString(1);

            LoaiChi objLoaiChi = new LoaiChi(maLoaiChi, tenLoaiChi);
            danhSachLoaiChi.add(objLoaiChi);

            cursor.moveToNext();
        }

        return danhSachLoaiChi;
    }


    public long xoa(LoaiChi loaiChi){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        long kq = sqLiteDatabase.delete("LoaiChi","maLC=?",null);
        sqLiteDatabase.close();
        return kq;
    }}
