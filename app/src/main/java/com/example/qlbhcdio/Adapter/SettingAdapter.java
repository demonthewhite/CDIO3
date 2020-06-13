package com.example.qlbhcdio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.SettingFunction;

import java.util.ArrayList;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CODE_SETTING_LaBel = 125;
    private static final int CODE_ITEM = 127;

    private Context context;
    private List<SettingFunction> mFunction;

    public SettingAdapter(Context context) {
        this.context = context;
        mFunction = new ArrayList<>();
        mFunction.add(new SettingFunction(125, "Thiết lập tài khoản"));
        mFunction.add(new SettingFunction(1, "Thanh Toán"));
        mFunction.add(new SettingFunction(2, "Mật khẩu"));
        mFunction.add(new SettingFunction(125, "Cài đặt ứng dụng"));
        mFunction.add(new SettingFunction(3, "Đổi ngôn ngữ"));
        mFunction.add(new SettingFunction(4, "Thông báo"));
        mFunction.add(new SettingFunction(5, "Đăng Xuất"));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CODE_SETTING_LaBel) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_label_setting, parent, false);
            return new LabelViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_setting, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).tv_function.setText(mFunction.get(position).getName());
        } else {
            ((LabelViewHolder) holder).tv_function.setText(mFunction.get(position).getName());
        }

    }

    @Override
    public int getItemCount() {
        return mFunction.size();
    }


    @Override
    public int getItemViewType(int position) {
        switch (mFunction.get(position).getId()) {
            case CODE_SETTING_LaBel:
                return CODE_SETTING_LaBel;
            default:
                return CODE_ITEM;
        }
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView tv_function;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_function = itemView.findViewById(R.id.tv_function);
    }
}

class LabelViewHolder extends RecyclerView.ViewHolder {

    TextView tv_function;

    public LabelViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_function = itemView.findViewById(R.id.tv_label_setting);
    }
}

