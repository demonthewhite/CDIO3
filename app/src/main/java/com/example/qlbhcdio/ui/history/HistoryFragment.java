package com.example.qlbhcdio.ui.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlbhcdio.Adapter.HistoryAdapter;
import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Detail;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView recyclerViewHistory;
    private HistoryAdapter mHistoryAdapter;
    private List<Detail> mDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);
        recyclerViewHistory = view.findViewById(R.id.rcl_history);
        try {
            addList();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mHistoryAdapter = new HistoryAdapter(getContext(), mDetail);
        recyclerViewHistory.setAdapter(mHistoryAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewHistory.setLayoutManager(manager);

        return view;
    }

    private void addList() throws ParseException {
        mDetail = new ArrayList<>();
        mDetail.add(new Detail("0354", 200000, "6/11/2020"));
        mDetail.add(new Detail("0154", 55000, "4/11/2020"));
        mDetail.add(new Detail("0254", 150000, "2/11/2020"));
        mDetail.add(new Detail("0374", 35000, "1/11/2020"));
        mDetail.add(new Detail("0474", 25000, "22/10/2020"));
        mDetail.add(new Detail("0464", 30000, "20/10/2020"));
        mDetail.add(new Detail("2454", 65000, "11/10/2020"));
        mDetail.add(new Detail("1474", 57000, "2/10/2020"));
        mDetail.add(new Detail("1704", 60000, "28/9/2020"));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        // TODO: Use the ViewModel
    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }
}