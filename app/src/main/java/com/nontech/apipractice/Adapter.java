package com.nontech.apipractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    @NonNull

    List<DetailsAdapter>image;

    LayoutInflater layoutInflater;
    Context context;

    public Adapter(@NonNull List<DetailsAdapter> image,Context context) {
        this.context=context;
        this.image=image;

        this.layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myviews=layoutInflater.inflate(R.layout.tvcard_design,parent,false);

        return new MyHolder(myviews);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


        Picasso.get().load(image.get(position).getLogo()).into(holder.imageView);
        //=====onclicklistenner===

        if (holder.getAdapterPosition()==0){

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VideoActivity.channel="http://116.202.46.40:9023/ZEE_HINDI/index.m3u8";
                    Intent intent=new Intent(v.getContext(),VideoActivity.class);
                    v.getContext().startActivity(intent);

                }
            });

        }else if (holder.getAdapterPosition()==1){

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    VideoActivity.channel="http://116.202.46.40:9023/STAR_GOLD_HINDI/index.m3u8";
                    Intent intent=new Intent(v.getContext(),VideoActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);


        }
    }
}
