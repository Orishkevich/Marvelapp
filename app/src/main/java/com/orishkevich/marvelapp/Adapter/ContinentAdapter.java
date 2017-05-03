package com.orishkevich.marvelapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orishkevich.marvelapp.Model.Continent;

import com.orishkevich.marvelapp.R;

import java.util.ArrayList;



public class ContinentAdapter extends RecyclerView.Adapter<ContinentViewHolder> {

    public static ContinentAdapter.OnItemClickListener listener;
    private ArrayList<Continent> cont;


    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(ContinentAdapter.OnItemClickListener listener){
        this.listener = listener;
    }

    public ContinentAdapter(ArrayList<Continent> cont){
        this.cont = cont;
    }


    @Override
    public void onBindViewHolder(ContinentViewHolder contViewHolder, int i){

        Continent current = cont.get(i);
        contViewHolder.tvName.setText(current.getName());
    }

    @Override
    public ContinentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_cont, viewGroup, false);
        return new ContinentViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return cont.size();
    }


}
