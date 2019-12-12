package com.example.designbyann.DatabaseChiTieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class KhoanChiDAO {
    private SQLiteDatabase sqliteDB;
    private DatabaseOHelper dbHelper;
    private Context context;

    public KhoanChiDAO(Context context){
        this.context = context;
        dbHelper = new DatabaseOHelper(context);
        sqliteDB = dbHelper.getWritableDatabase();
    }
    public boolean insertKhoanChi(KhoanChi khoanChi){
        try {
            ContentValues values = new ContentValues();
            values.put("maKC", khoanChi.getMaKhoanChi());
            values.put("tenKC", khoanChi.getTenKhoanChi());
            values.put("soTien", khoanChi.getSoTien());
            values.put("ngayChi", khoanChi.getNgayChi());
                long numInsert = sqliteDB.insert("KhoanChi",null,values);
            if(numInsert<=0)
                return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }


        return true;
    }
    public List<KhoanChi> getAllKC(){
        List<KhoanChi> danhSachKhoanChi = new ArrayList<>();

        String sqlSelect = "select maKC,tenKC,soTien,ngayChi from KhoanChi";
        Cursor cursor = sqliteDB.rawQuery(sqlSelect, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String MaKC = cursor.getString(0);
            String TenKC = cursor.getString(1);
            Double soTien = cursor.getDouble(2);
            String ngayChi = cursor.getString(3);

            KhoanChi khoanChi = new KhoanChi(MaKC,TenKC,soTien,ngayChi);
            danhSachKhoanChi.add(khoanChi);

            cursor.moveToNext();
        }

        return danhSachKhoanChi;
    }
}
