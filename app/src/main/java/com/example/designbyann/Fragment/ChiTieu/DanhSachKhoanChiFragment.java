package com.example.designbyann.Fragment.ChiTieu;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.designbyann.DatabaseChiTieu.KhoanChi;
import com.example.designbyann.DatabaseChiTieu.KhoanChiDAO;
import com.example.designbyann.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhSachKhoanChiFragment extends Fragment {
    private ListView lvKhoanChi;
    private KhoanChiDAO khoanChiDAO;
    private List<KhoanChi> dsKhoanChi;



    public DanhSachKhoanChiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        khoanChiDAO = new KhoanChiDAO(getActivity());
        dsKhoanChi = khoanChiDAO.getAllKC();

        ArrayAdapter<KhoanChi> adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1 ,
                dsKhoanChi);

        View view = inflater.inflate(R.layout.fragment_danh_sach_khoan_chi, container, false);
        lvKhoanChi = view.findViewById(R.id.lvKhoanChi);

        dsKhoanChi = khoanChiDAO.getAllKC();
        lvKhoanChi.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.option_menu, menu);
    }


}
