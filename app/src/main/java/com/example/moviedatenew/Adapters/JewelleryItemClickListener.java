package com.example.moviedatenew.Adapters;

import android.widget.ImageView;

import com.example.moviedatenew.Models.Jewellery_list;

public interface JewelleryItemClickListener {

    void onJewelleryClick (Jewellery_list jewellery, ImageView jewelleryImageView);
    //we will need the image view to make the shared anomation between the two activities

}



