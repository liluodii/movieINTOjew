package com.example.moviedatenew.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviedatenew.Adapters.JewelleryAdapter;
import com.example.moviedatenew.Adapters.JewelleryItemClickListener;
import com.example.moviedatenew.Adapters.WatchAdapter;
import com.example.moviedatenew.Adapters.WatchItemClickListner;
import com.example.moviedatenew.Models.Jewellery_list;
import com.example.moviedatenew.Models.Watch_list;
import com.example.moviedatenew.R;
import com.example.moviedatenew.Models.Slide;
import com.example.moviedatenew.Adapters.SliderPagerAdapter;
import com.example.moviedatenew.utils.DataSource;
import com.example.moviedatenew.utils.Watchsource;

import java.util.ArrayList;
import java.util.List;

public class WatchActivity extends AppCompatActivity implements WatchItemClickListner {
    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private RecyclerView JewelleryRV,JewelleryRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewellery_activity);


        iniViews();
        iniSlider();
        iniPopularWatch();
        iniWeekWatch();


    }

    private void iniWeekWatch() {

        WatchAdapter weekJewelleryAdapter =new WatchAdapter(this, Watchsource.getweekWatch(),this);
        JewelleryRvWeek.setAdapter(weekJewelleryAdapter);
        JewelleryRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }




    private void iniPopularWatch() {
        //recyclerview data
        //init data


        WatchAdapter watchAdapter =new WatchAdapter(this, Watchsource.getPopularWatch(),this );
        JewelleryRV.setAdapter(watchAdapter);
        JewelleryRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        //prepare a list of slides
        lstSlides=new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.wat18,""));
        lstSlides.add(new Slide(R.drawable.wat19,""));
        lstSlides.add(new Slide(R.drawable.jew9,""));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderPager.setAdapter(adapter);
    }

    private void iniViews() {
        sliderPager=findViewById(R.id.slider_pager);
        JewelleryRV=findViewById(R.id.rv_jewellery);
        JewelleryRvWeek=findViewById(R.id.rv_jewellery_week);
    }

    @Override
    public void onWatchClick(Watch_list jewellery, ImageView watchimageView) {       //add for MD
        //here we will send jewellery information to detail activity
        //also we will create the transition animation between the two activity

        Intent intent=new Intent(this, WatchDetailActivity.class);
        //send jewellery information to detail activity
        intent.putExtra("title",jewellery.getTitle());
        intent.putExtra("imgURL",jewellery.getThumbnail());
        intent.putExtra("imgCover",jewellery.getCoverPhoto());

        //startActivity(intent);

        //create the animation
        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(WatchActivity.this,
                watchimageView,"sharedName");

        startActivity(intent,options.toBundle());



        //to make a simple text to see if the click works, use toast
        Toast.makeText(this,"item clicked: " + jewellery.getTitle(),Toast.LENGTH_LONG).show();
        //it worked
    }
}
