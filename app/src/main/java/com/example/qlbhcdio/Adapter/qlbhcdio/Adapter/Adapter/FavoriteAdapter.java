package com.example.qlbhcdio.Adapter.qlbhcdio.Adapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.R;

public class FavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public FavoriteAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nameFish;
        TextView tv_money;
        ImageView imageFish;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFish = itemView.findViewById(R.id.img_sellFish);
            tv_nameFish = itemView.findViewById(R.id.tv_title);
            tv_money = itemView.findViewById(R.id.tv_cost);
        }
    }
}
