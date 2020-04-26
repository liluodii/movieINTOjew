package com.example.moviedatenew.Adapters;

import android.widget.ImageView;

import com.example.moviedatenew.Models.Jewellery_list;
import com.example.moviedatenew.Models.Watch_list;

public interface WatchItemClickListner {

    void onWatchClick (Watch_list jewellery, ImageView watchimageView);
    //we will need the image view to make the shared anomation between the two activities

}
