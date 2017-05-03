package com.orishkevich.marvelapp.Adapter;



import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;


public class ContinentViewHolder  extends RecyclerView.ViewHolder {

    public TextView tvName;

    public  ContinentViewHolder(final View itemView){
        super(itemView);

        tvName = (TextView)itemView.findViewById(R.id.tvName);

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