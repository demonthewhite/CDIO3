package com.example.qlbhcdio.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Product;

public class ProductPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_product);
        if(getIntent().getExtras().getSerializable("product")!=null){
            Product product = (Product) getIntent().getExtras().getSerializable("product");
            Toast.makeText(this,product.getName(),Toast.LENGTH_SHORT).show();
        }


    }
}
