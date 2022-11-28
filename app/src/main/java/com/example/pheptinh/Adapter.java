package com.example.pheptinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Pheptinh> pheptinhList;

    public Adapter(Context context, int layout, List<Pheptinh> pheptinhList) {
        this.context = context;
        this.layout = layout;
        this.pheptinhList = pheptinhList;
    }

    @Override
    public int getCount() {
        return pheptinhList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout, null);
            holder = new ViewHolder();

            //anh xa view
            holder.txtTen = (TextView) view.findViewById(R.id.textviewTen);
            holder.imgHinh= (ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        // gan gia tri
        Pheptinh pheptinh = pheptinhList.get(i);

        holder.txtTen.setText(pheptinh.getPheptinh());
        holder.imgHinh.setImageResource(pheptinh.getHinh());

        return view;
    }

}
