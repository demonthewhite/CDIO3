package com.example.qlbhcdio.Adapter.qlbhcdio.Adapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.Adapter.qlbhcdio.Adapter.model.KindFish;
import com.example.qlbhcdio.R;

import java.util.List;

;

public class KindFishAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<KindFish> mKindFish;

    public KindFishAdapter(Context context/*, List<KindFish> mKindFish*/) {
        this.context = context;
   /*     this.mKindFish = mKindFish;*/
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kindfish, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageButton ibtn_kindfish;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ibtn_kindfish = itemView.findViewById(R.id.img_kindfish);
        }

        public void setImage() {
        }
    }

}
