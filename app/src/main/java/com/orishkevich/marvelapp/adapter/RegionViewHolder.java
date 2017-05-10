package com.orishkevich.marvelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;



public class RegionViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName;

    public  RegionViewHolder(final View itemView){
        super(itemView);

        tvName = (TextView)itemView.findViewById(R.id.recyclerViewItemName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CountryAdapter.listener!=null){
                    CountryAdapter.listener.onItemClick(itemView, getLayoutPosition());
                }
            }
        });
    }
}