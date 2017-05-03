package com.orishkevich.marvelapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orishkevich.marvelapp.Model.Country;
import com.orishkevich.marvelapp.Model.Region;
import com.orishkevich.marvelapp.R;

import java.util.ArrayList;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class RegionAdapter extends RecyclerView.Adapter<RegionViewHolder> {

    public static RegionAdapter.OnItemClickListener listener;
    private ArrayList<Region> reg;


    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(RegionAdapter.OnItemClickListener listener){
        this.listener = listener;
    }

    public RegionAdapter(ArrayList<Country> persons){
        this.reg = reg;
    }


    @Override
    public void onBindViewHolder(RegionViewHolder personViewHolder, int i){

        Region current = reg.get(i);
        personViewHolder.tvName.setText(current.getName());
    }

    @Override
    public RegionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);

        return new RegionViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return reg.size();
    }


}
