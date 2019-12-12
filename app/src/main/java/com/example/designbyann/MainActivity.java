package com.example.designbyann;

import android.os.Bundle;

import com.example.designbyann.Fragment.ChiTieu.DanhSachKhoanChiFragment;
import com.example.designbyann.Fragment.ChiTieu.DanhSachLoaiChiFragment;
import com.example.designbyann.Fragment.ChiTieu.ThemKhoanChiFragment;
import com.example.designbyann.Fragment.ChiTieu.ThemLoaiChiFragment;
import com.example.designbyann.Fragment.GioiThieuFragemnt;
import com.example.designbyann.Fragment.ThongKeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cho em 9đ đi cô", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.menu_quanlykhoanchi:
                fragment = new DanhSachLoaiChiFragment();
                this.setTitle("Danh sách loại chi");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.menu_khoanchi:
                fragment = new DanhSachKhoanChiFragment();
                this.setTitle("Danh sách khoản chi");
                fragmentTransaction.replace(R.id.frameContent, fragment, "");
                fragmentTransaction.commit();
                return true;

            case R.id.menu_themloaichi:
                fragment = new ThemLoaiChiFragment();
                this.setTitle("Thêm loại chi");
                fragmentTransaction.replace(R.id.frameContent, fragment, "themloaichi");
                fragmentTransaction.commit();
                return true;

            case R.id.menu_themkhoanchi:
                fragment = new ThemKhoanChiFragment();
                this.setTitle("Thêm khoản chi");
                fragmentTransaction.replace(R.id.frameContent, fragment, "themkhoanchi");
                fragmentTransaction.commit();
                return true;


            case R.id.menu_thongke:
                fragment = new ThongKeFragment();
                this.setTitle("Danh sách thống kê");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.menu_gioithieu:
                fragment = new GioiThieuFragemnt();
                this.setTitle("Danh sách giới thiệu");
                fragmentTransaction.replace(R.id.frameContent, fragment, "gioithieu");
                fragmentTransaction.commit();
                return true;

            case R.id.menu_thoat:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
