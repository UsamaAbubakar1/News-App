package com.example.newswave;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<articlesModel>articlesModelArrayList;

    public recyclerAdapter(Context context, ArrayList<articlesModel> articlesModelArrayList) {
        this.context = context;
        this.articlesModelArrayList = articlesModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layoutitem, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, webView.class);
                    intent.putExtra("url", articlesModelArrayList.get(adapterPosition).getUrl());
                    context.startActivity(intent);
                }
            }
        });

        holder.time.setText("Published At:-" + articlesModelArrayList.get(position).getPublishedAt());
        holder.heading.setText(articlesModelArrayList.get(position).getTitle());
        holder.content.setText(articlesModelArrayList.get(position).getDescription());
        holder.auther.setText(articlesModelArrayList.get(position).getAuthor());
        Glide.with(context).load(articlesModelArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articlesModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView heading, content, auther, category, time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.heading);
            content = itemView.findViewById(R.id.content);
            auther = itemView.findViewById(R.id.auther);
            cardView = itemView.findViewById(R.id.cardView);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.newsImg);



        }
    }
}
