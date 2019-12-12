package com.example.designbyann.Fragment.ChiTieu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.designbyann.DatabaseChiTieu.DatabaseOHelper;
import com.example.designbyann.DatabaseChiTieu.KhoanChi;
import com.example.designbyann.DatabaseChiTieu.KhoanChiDAO;
import com.example.designbyann.DatabaseChiTieu.LoaiChi;
import com.example.designbyann.DatabaseChiTieu.LoaiChiDAO;
import com.example.designbyann.R;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemKhoanChiFragment extends Fragment {
    private KhoanChiDAO khoanChiDAO;
    private EditText edMAKC1, edTenKC1, edSoTien1,eddate1;
    private Button btLuu;
    private Spinner spLoaiChi;
    private DatabaseOHelper databaseHelper;
    private LoaiChiDAO loaiChiDAO;
    private List<LoaiChi> dsLoaiChi;

    public ThemKhoanChiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loaiChiDAO = new LoaiChiDAO(getActivity());
        dsLoaiChi = loaiChiDAO.getAllLoaiChi();

        View view = inflater.inflate(R.layout.fragment_them_khoan_chi, container, false);

        spLoaiChi = view.findViewById(R.id.spLoaiChi);

        ArrayAdapter<LoaiChi> adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_spinner_item,
                dsLoaiChi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLoaiChi.setAdapter(adapter);
        khoanChiDAO = new KhoanChiDAO(getActivity());

        Button btLuu = view.findViewById(R.id.btLuuKC);
        edMAKC1 = view.findViewById(R.id.edMaKC);
        edTenKC1= view.findViewById(R.id.edTenKC);
        edSoTien1 = view.findViewById(R.id.edSoTien);
        eddate1 = view.findViewById(R.id.eddate);

        LoaiChi loaiChi = (LoaiChi) spLoaiChi.getSelectedItem();

        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maKhoanChi = edMAKC1.getText().toString();
                String tenKhoanChi = edTenKC1.getText().toString();
                double soTien = Double.parseDouble(edSoTien1.getText().toString());
                String thoiGian =  eddate1.getText().toString();
                KhoanChi khoanChi = new KhoanChi(tenKhoanChi,maKhoanChi,soTien,thoiGian);


                boolean isSuccess = khoanChiDAO.insertKhoanChi(khoanChi);
                if(isSuccess){
                    Toast.makeText(getActivity(),"Chen thanh cong", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"Chen that bai", Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;

    }

    public DatePicker setupDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        return null;
    }


}