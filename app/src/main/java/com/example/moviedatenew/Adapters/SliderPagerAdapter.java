package com.example.moviedatenew.Adapters;

import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviedatenew.Models.Slide;
import com.example.moviedatenew.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderPagerAdapter  extends PagerAdapter {
      //implement methods


    private Context mContext;
    private List<Slide> mList;

    //generate constructor

    public SliderPagerAdapter(Context mContext, List<Slide> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slide_item,null);


        ImageView slideImage= slideLayout.findViewById(R.id.slide_image);
        TextView slideText= slideLayout.findViewById(R.id.slide_title);
        slideImage.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;       //but in tutorial view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
