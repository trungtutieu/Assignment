package com.example.designbyann.Fragment.ChiTieu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.designbyann.DatabaseChiTieu.LoaiChi;
import com.example.designbyann.DatabaseChiTieu.LoaiChiDAO;
import com.example.designbyann.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemLoaiChiFragment extends Fragment {
    private LoaiChiDAO loaiChiDAO;


    public ThemLoaiChiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loaiChiDAO = new LoaiChiDAO(getActivity());
        View view = inflater.inflate(R.layout.fragment_them_loai_chi, container, false);

        Button btLuu = view.findViewById(R.id.btLuu);
        final EditText edMaLoaiChi = view.findViewById(R.id.edMaLoaiChi);
        final EditText edTenLoaiChi = view.findViewById(R.id.edTenLoaiChi);


        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maLC = edMaLoaiChi.getText().toString();
                String tenLC = edTenLoaiChi.getText().toString();

                LoaiChi objLoaiChi = new LoaiChi(maLC, tenLC);

                boolean isSuccess = loaiChiDAO.insertLoaiChi(objLoaiChi);

                if(isSuccess){
                    Toast.makeText(getActivity(),"Chen thanh cong", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"Chen that bai", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

}
