package com.example.doan.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan.Model.DichVu;
import com.example.doan.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DichVuHightAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<DichVu> data;

    public DichVuHightAdapter(Context context, int resource, ArrayList<DichVu> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    static class Holder {
        ImageView imgHinhHight;
        CheckBox cbTenSanPham;
        Spinner spSoLuong;
        TextView tvGia;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        Holder holder = new Holder();
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);

            holder.spSoLuong = view.findViewById(R.id.spSoLuong);
            holder.cbTenSanPham = view.findViewById(R.id.cbTenSP);
            holder.tvGia = view.findViewById(R.id.tvGia);
            holder.imgHinhHight = view.findViewById(R.id.imgHinhAdapter);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        DichVu dichVu = data.get(position);

        holder.cbTenSanPham.setText(dichVu.getTenDV());
        byte[] hinhAnh = dichVu.getHinhAnh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.imgHinhHight.setImageBitmap(bitmap);

        ArrayAdapter adapter_soluong;
        ArrayList<String> arraySoLuong = new ArrayList<>();
        for(int i = 1; i<=dichVu.getSoLuong();i++)
        {
            arraySoLuong.add(i + "");

        }
        adapter_soluong = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arraySoLuong);
        holder.spSoLuong.setAdapter(adapter_soluong);

        holder.tvGia.setText(dichVu.getDonGia() + "");

        return view;
    }
}
