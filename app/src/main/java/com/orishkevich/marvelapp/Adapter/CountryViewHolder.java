package com.orishkevich.marvelapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;


public class CountryViewHolder extends RecyclerView.ViewHolder {

    public  TextView name_count;
    public  ImageButton down;
    public ProgressBar pd;
   // public  ImageButton canc;
    private DownButtonListener downButtonListener;
   // private CancelButtonListener cancButtonListener;

        public CountryViewHolder(final View itemView){
            super(itemView);
            name_count = (TextView)itemView.findViewById(R.id.recyclerViewItemName);
            down = (ImageButton) itemView.findViewById(R.id.recyclerViewItemDownButton);
            pd=(ProgressBar)itemView.findViewById(R.id.prog_down_item);

            downButtonListener = new DownButtonListener();
            down.setOnClickListener(downButtonListener);
            //cancButtonListener = new CancelButtonListener();
            //canc = (ImageButton) itemView.findViewById(R.id.recyclerViewItemDeleteButton);
            //canc.setOnClickListener(cancButtonListener);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CountryAdapter.listener!=null){
                        CountryAdapter.listener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }
    public class DownButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            pd.setVisibility(View.VISIBLE);
            Log.d("CountryViewHolder", "DownButtonListener" );
        }
    }

    private class CancelButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
           // cancel();
        }
    }

}

