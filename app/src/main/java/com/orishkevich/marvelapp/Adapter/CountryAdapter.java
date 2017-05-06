package com.orishkevich.marvelapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.orishkevich.marvelapp.Model.Country;
import com.orishkevich.marvelapp.R;

import java.util.ArrayList;

/**
 * Created by Инженер-конструктор on 13.03.2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    public static OnItemClickListener listener;
        private ArrayList<Country> count;


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
        //public void onBindViewHolder(ViewHolder viewHolder, int i)
        Country current = count.get(i);
        countViewHolder.name_count.setText(current.getName());
        if (!current.getMap()){countViewHolder.down.setVisibility(View.INVISIBLE);}

        Country record = count.get(i);
        int iconResourceId = 0;
        switch (record.getDowload()) {
            case true:
                iconResourceId = R.drawable.green_circle;
                break;
            case false:
                iconResourceId = R.drawable.red_circle;
                break;

        }
        countViewHolder.icon.setImageResource(iconResourceId);
        countViewHolder.name.setText(record.getName());
        countViewHolder.deleteButtonListener.setRecord(record);
        countViewHolder.copyButtonListener.setRecord(record);

}
    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_count, viewGroup, false);

        return new CountryViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return count.size();
    }


}