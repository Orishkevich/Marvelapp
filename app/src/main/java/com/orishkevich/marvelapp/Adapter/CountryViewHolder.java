package com.orishkevich.marvelapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;


public class CountryViewHolder extends RecyclerView.ViewHolder {

        public TextView name_count;
        public ImageButton down;

        public CountryViewHolder(final View itemView){
            super(itemView);

            name_count = (TextView)itemView.findViewById(R.id.recyclerViewItemName);
            down = (ImageButton) itemView.findViewById(R.id.recyclerViewItemDeleteButton);

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
