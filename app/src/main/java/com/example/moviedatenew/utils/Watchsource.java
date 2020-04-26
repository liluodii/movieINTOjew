package com.example.moviedatenew.utils;

import com.example.moviedatenew.Models.Watch_list;
import com.example.moviedatenew.R;

import java.util.ArrayList;
import java.util.List;

public class Watchsource {

    public static List<Watch_list> getPopularWatch(){
        List<Watch_list> lstWatch=new ArrayList<>();
        lstWatch.add(new Watch_list("Sport sail Watch", R.drawable.wat5,R.drawable.jew15));
        lstWatch.add(new Watch_list("Palazo Empire",R.drawable.wat3,R.drawable.jew17));
        lstWatch.add(new Watch_list("Versace Watch",R.drawable.wat4,R.drawable.jew15));
        lstWatch.add(new Watch_list("Gucci Unisex",R.drawable.wat1,R.drawable.jew17));
        lstWatch.add(new Watch_list("G-Timeless",R.drawable.wat6,R.drawable.wat8));

        return lstWatch;
    }


    public static List<Watch_list> getweekWatch(){

        List<Watch_list> lstWatch=new ArrayList<>();
        lstWatch.add(new Watch_list("Greenleaf Ring",R.drawable.wat14,R.drawable.jew17));
        lstWatch.add(new Watch_list("Butterfly Watch",R.drawable.wat15,R.drawable.jew15));
        lstWatch.add(new Watch_list("Skull Sport",R.drawable.wat16,R.drawable.jew17));
        lstWatch.add(new Watch_list("Jack Threads",R.drawable.wat17,R.drawable.jew15));
        lstWatch.add(new Watch_list("Eros Mesh",R.drawable.wat5,R.drawable.jew13));

        return lstWatch;
    }
}
