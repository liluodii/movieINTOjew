package com.example.moviedatenew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
import com.example.moviedatenew.R;
import com.example.moviedatenew.utils.AddtoCart;

public class JewelleryDetailActivity extends AppCompatActivity {

    private ImageView JewelleryThumbnailImg,JewelleryCoverImg;
    private TextView tv_title, tv_description;
    private Button btnContinue;
    private TextView chooseDate;
    private TimePicker timePicker;
    private RatingBar ratingBar;
    String jewelleryTitle;
    TextView Price;
    Intent intent;
    Intent intent1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewellery_detail);

        intent1=new Intent(JewelleryDetailActivity.this, AddtoCart.class);

        ratingBar=findViewById(R.id.ratingBar);
        btnContinue=findViewById(R.id.btnAddCart);
        chooseDate=findViewById(R.id.tvChooseColor);
        Price=findViewById(R.id.tvprice);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price=Price.getText().toString();
                intent1.putExtra("title",jewelleryTitle);
                intent1.putExtra("price",price);
                startActivity(intent1);
            }
        });


      iniViews();



    }   //get the data

    void iniViews() {

        intent= getIntent();
        jewelleryTitle=intent.getExtras().getString("title");
        int imageResourceId = intent.getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        JewelleryThumbnailImg=findViewById(R.id.detail_Jewellery_image);
        Glide.with(this).load(imageResourceId).into(JewelleryThumbnailImg);
        JewelleryThumbnailImg.setImageResource(imageResourceId);
        JewelleryCoverImg=findViewById(R.id.detail_Jewellery_cover);
        Glide.with(this).load(imagecover).into(JewelleryCoverImg);
        tv_title=findViewById(R.id.detail_jewellery_title);
        tv_title.setText(jewelleryTitle);
       // getSupportActionBar().setTitle(movieTitle);
        tv_description=findViewById(R.id.detail_jewellery_desc);
        //setup animation
        JewelleryCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }
}
