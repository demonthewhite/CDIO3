package com.example.qlbhcdio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Product;

import java.util.List;

public class GirdAdapter extends BaseAdapter {

    private List<Product> listSell;
    private Context context;
    private SelectedItem selectedItem;

    public GirdAdapter(List<Product> listSell, Context context, SelectedItem selectedItem) {
        this.listSell = listSell;
        this.context = context;
        this.selectedItem = selectedItem;
    }

    @Override
    public int getCount() {
        return listSell.size();
    }

    @Override
    public Product getItem(int position) {
        return listSell.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_girdview, parent, false);
            viewHolder.image = convertView.findViewById(R.id.img_item_product);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.cost = (TextView) convertView.findViewById(R.id.tv_cost);
            viewHolder.cardView = convertView.findViewById(R.id.CardView_fish);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // todo set data (viewHolder)
        Product fish = listSell.get(position);
        viewHolder.title.setText(fish.getName());
        viewHolder.cost.setText(String.valueOf(fish.getMoney()));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem.onSelect(position);
            }
        });

        return convertView;
    }


    static class ViewHolder {
        ImageView image;
        TextView title;
        TextView cost;
        CardView cardView;
    }

    public interface SelectedItem {
        void onSelect(int position);
    }

}
