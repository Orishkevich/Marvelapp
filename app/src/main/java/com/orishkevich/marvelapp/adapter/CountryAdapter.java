package com.orishkevich.marvelapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.orishkevich.marvelapp.model.Country;
import com.orishkevich.marvelapp.R;
import java.util.ArrayList;

/**
 * Created by Инженер-конструктор on 13.03.2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    public Context context;
    public static OnItemClickListener listener;

    public ArrayList<Country> getCountry() {
        return count;
    }

    private ArrayList<Country> count;
    private String url;

    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
                this.listener = listener;
    }

    public CountryAdapter(ArrayList<Country> count){
        this.count = count;
    }


    @Override
    public void onBindViewHolder(CountryViewHolder countViewHolder, int i){

        Country current = count.get(i);
        countViewHolder.getName_count().setText(current.getName());
       // Log.d("CountryAdapter", "URL="+ current.getAdress() );
        if (!current.getMap()){countViewHolder.getDown().setVisibility(View.INVISIBLE);}
        countViewHolder.getPd().setVisibility(View.GONE);
}
    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_count, viewGroup, false);

        return new CountryViewHolder(count,itemView);
    }

    @Override
    public int getItemCount(){
        return count.size();
    }


}