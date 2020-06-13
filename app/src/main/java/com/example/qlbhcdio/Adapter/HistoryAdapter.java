package com.example.qlbhcdio.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Detail;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Detail> mHistory;
    private setOnClickItemHistory onClickItemHistory;

    public HistoryAdapter(Context context, List<Detail> mHistory, setOnClickItemHistory onClickItemHistory) {
        this.context = context;
        this.mHistory = mHistory;
        this.onClickItemHistory = onClickItemHistory;
    }

    public HistoryAdapter(Context context, List<Detail> mHistory) {
        this.context = context;
        this.mHistory = mHistory;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ItemViewHolder) holder).tv_id.setText(mHistory.get(position).getId());
        ((ItemViewHolder) holder).tv_money.setText(String.valueOf(mHistory.get(position).getMoney()));
        ((ItemViewHolder) holder).tv_dateTime.setText(mHistory.get(position).getDateTimeString());
    }

    @Override
    public int getItemCount() {
        return mHistory.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tv_money;
        TextView tv_dateTime;
        TextView tv_id;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id_bill);
            tv_dateTime = itemView.findViewById(R.id.tv_date_bill);
            tv_money = itemView.findViewById(R.id.tv_sumMoney_bill);
        }
    }

    public interface setOnClickItemHistory {
        void setOnClick(int position);
    }

}
