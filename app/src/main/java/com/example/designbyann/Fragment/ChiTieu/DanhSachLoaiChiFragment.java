package com.example.designbyann.Fragment.ChiTieu;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.designbyann.DatabaseChiTieu.LoaiChi;
import com.example.designbyann.DatabaseChiTieu.LoaiChiDAO;
import com.example.designbyann.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhSachLoaiChiFragment extends Fragment {
    private ListView lvLoaiChi;
    private LoaiChiDAO loaiChiDAO;
    private List<LoaiChi> dsLoaiChi;


    public DanhSachLoaiChiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loaiChiDAO = new LoaiChiDAO(getActivity());
        dsLoaiChi = loaiChiDAO.getAllLoaiChi();

        final ArrayAdapter adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1 ,
                dsLoaiChi);

        View view = inflater.inflate(R.layout.fragment_danh_sach_loai_chi, container, false);
        lvLoaiChi = view.findViewById(R.id.lvLoaiChi);

        lvLoaiChi.setAdapter(adapter);

        lvLoaiChi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Xóa");
                builder.setCancelable(false);
                builder.setPositiveButton("Không", DialogInterface.OnClickListener);

                Toast.makeText(getActivity(),"Bạn vừa xóa"+dsLoaiChi.get(position),Toast.LENGTH_SHORT).show();

                loaiChiDAO.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
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
