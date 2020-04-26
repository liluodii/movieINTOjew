package com.example.moviedatenew.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moviedatenew.JewelleryBooked;
import com.example.moviedatenew.MainActivity;
import com.example.moviedatenew.R;
import com.example.moviedatenew.ui.WatchActivity;

public class AddtoCart extends AppCompatActivity {

    private Button ButtonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart);

        ButtonPay=findViewById(R.id.btnPay);
        TextView item,price;

        item=findViewById(R.id.tvcart1);
        price=findViewById(R.id.tvprice1);
        Intent intent1= getIntent();
        String jewelleryTitle=intent1.getExtras().getString("title");
        String Price= intent1.getExtras().getString("price");
        item.setText(jewelleryTitle);
        price.setText(Price);

        ButtonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(AddtoCart.this,JewelleryBooked.class);
                startActivity(intent);
            }
        });





    }
}
