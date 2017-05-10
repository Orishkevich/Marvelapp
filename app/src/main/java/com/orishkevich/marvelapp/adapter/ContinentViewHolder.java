package com.orishkevich.marvelapp.adapter;



import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;


public class ContinentViewHolder  extends RecyclerView.ViewHolder {

    public TextView name_cont;

    public  ContinentViewHolder(final View itemView){
        super(itemView);

        name_cont = (TextView)itemView.findViewById(R.id.name_cont);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContinentAdapter.listener!=null){
                    ContinentAdapter.listener.onItemClick(itemView, getLayoutPosition());
                }
            }
        });
    }
}
