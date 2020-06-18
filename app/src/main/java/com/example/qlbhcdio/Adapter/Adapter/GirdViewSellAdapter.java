package com.example.qlbhcdio.Adapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qlbhcdio.Adapter.model.Fish;
import com.example.qlbhcdio.R;

import java.util.List;

public class GirdViewSellAdapter extends BaseAdapter {

    private List<Fish> listSell;
    private Context context;

    public GirdViewSellAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return 10 /*listSell.size()*/;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_girdview_sellfish, parent, false);
            viewHolder.image = convertView.findViewById(R.id.img_sellFish);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.cost = (TextView) convertView.findViewById(R.id.tv_cost);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // todo set data (viewHolder)
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView title;
        TextView cost;

    }

}
