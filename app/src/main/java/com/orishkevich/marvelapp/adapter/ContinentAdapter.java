package com.orishkevich.marvelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.orishkevich.marvelapp.model.Continent;
import com.orishkevich.marvelapp.R;
import java.util.ArrayList;



public class ContinentAdapter extends RecyclerView.Adapter<ContinentViewHolder> {

    public static OnItemClickListener listener;
    private ArrayList<Continent> cont;


    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public ContinentAdapter(ArrayList<Continent> cont){
      //  Log.d("Adapter", "ContinentAdapter()");
        this.cont = cont;
    }


    @Override
    public void onBindViewHolder(ContinentViewHolder contViewHolder, int i){
       // Log.d("Adapter", "onBindViewHolder");
        Continent current = cont.get(i);
        contViewHolder.name_cont.setText(current.getName());
    }

    @Override
    public ContinentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_cont, viewGroup, false);
       // Log.d("Adapter", "ContinentViewHolder");
        return new ContinentViewHolder(itemView);
    }

    @Override
    public int getItemCount(){

       // Log.d("Adapter", "getItemCount()");
        return cont.size();
    }


}
