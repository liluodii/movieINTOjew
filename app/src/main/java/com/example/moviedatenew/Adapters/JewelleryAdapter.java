package com.example.moviedatenew.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviedatenew.Models.Jewellery_list;
import com.example.moviedatenew.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JewelleryAdapter extends RecyclerView.Adapter<JewelleryAdapter.MyViewHolder> {

    Context context;
    List<Jewellery_list> mdata;
    JewelleryItemClickListener jewelleryItemClickListener;


    public JewelleryAdapter(Context context, List<Jewellery_list> mdata, JewelleryItemClickListener listener) {
        this.context = context;
        this.mdata = mdata;
         jewelleryItemClickListener = listener;     //added for MD
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_jewellery,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.TvTitle.setText(mdata.get(i).getTitle());
        myViewHolder.ImgJewellery.setImageResource(mdata.get(i).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView TvTitle;
        private ImageView ImgJewellery;


        public MyViewHolder(@NonNull View itemView) {             //add for MD

            super(itemView);
            TvTitle=itemView.findViewById(R.id.item_jewellery_title);
            ImgJewellery=itemView.findViewById(R.id.item_jewellery_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jewelleryItemClickListener.onJewelleryClick(mdata.get(getAdapterPosition()),ImgJewellery);
                }
            });

        }
    }
}
