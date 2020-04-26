package com.example.moviedatenew.utils;

import com.example.moviedatenew.Models.Jewellery_list;
import com.example.moviedatenew.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Jewellery_list> getPopularJewellery(){
        List<Jewellery_list> lstJewellery=new ArrayList<>();
        lstJewellery.add(new Jewellery_list("Morganite 14K", R.drawable.jew30,R.drawable.jew13));
        lstJewellery.add(new Jewellery_list("Gold Flower ring",R.drawable.jew31,R.drawable.jew11));
        lstJewellery.add(new Jewellery_list("Diamond Flower",R.drawable.jew32,R.drawable.jew15));
        lstJewellery.add(new Jewellery_list("Morganite Flower",R.drawable.jew16,R.drawable.jew17));
        lstJewellery.add(new Jewellery_list("Silver Ring",R.drawable.jew18,R.drawable.jew19));

        return lstJewellery;
    }


    public static List<Jewellery_list> getweekJewellery(){

        List<Jewellery_list> lstJewellery=new ArrayList<>();
        lstJewellery.add(new Jewellery_list("Greenleaf Ring",R.drawable.jew33,R.drawable.jew17));
        lstJewellery.add(new Jewellery_list("Moissanite Engagement",R.drawable.jew34,R.drawable.jew22));
        lstJewellery.add(new Jewellery_list("Halo Ring",R.drawable.jew16,R.drawable.jew25));
        lstJewellery.add(new Jewellery_list("Moissanite Ring .46ct",R.drawable.jew36,R.drawable.jew27));
        lstJewellery.add(new Jewellery_list("Morganite Flower",R.drawable.jew35,R.drawable.jew17));

        return lstJewellery;
    }

}

