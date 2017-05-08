package com.orishkevich.marvelapp.Adapter;

import android.app.DownloadManager;

import android.content.Context;
import android.database.Cursor;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orishkevich.marvelapp.Model.Country;
import com.orishkevich.marvelapp.R;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.DOWNLOAD_SERVICE;



public class CountryViewHolder extends RecyclerView.ViewHolder {

    public final static String TAG = "CountryViewHolder";
    private ArrayList<Country> count;

    private long enqueue;
    private DownloadManager dm;
    private ProgressBar mProgressBar;
    private DownButtonListener downButtonListener= new DownButtonListener();;


   // public  ImageButton canc;
    private CancelButtonListener cancButtonListener= new CancelButtonListener();

        public CountryViewHolder(ArrayList<Country> count, final View itemView){
            super(itemView);
            this.count = count;
            dm = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            name_count = (TextView)itemView.findViewById(R.id.recyclerViewItemName);
            down = (ImageButton) itemView.findViewById(R.id.recyclerViewItemDownButton);
            pd=(ProgressBar)itemView.findViewById(R.id.prog_down_item);
            down.setOnClickListener(downButtonListener);
            mProgressBar=(ProgressBar)itemView.findViewById(R.id.prog_down_items);

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
//mProgressBar.setVisibility(View.VISIBLE);
            pd.setVisibility(View.VISIBLE);
            down.setImageResource(R.drawable.ic_action_remove_dark);
            down.setOnClickListener(cancButtonListener);

            DownloadManager.Request request = new DownloadManager.Request(
            Uri.parse(count.get(getAdapterPosition()).getAdress()));
            enqueue = dm.enqueue(request);
            startProgress();


        }

    }

    private class CancelButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.d("CountryViewHolder", "CancelButtonListener" );
            pd.setVisibility(View.GONE);
            down.setImageResource(R.drawable.ic_action_import);
            down.setOnClickListener(downButtonListener);

            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus (DownloadManager.STATUS_FAILED|DownloadManager.STATUS_PENDING|DownloadManager.STATUS_RUNNING);
            DownloadManager dm = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            Cursor c = dm.query(query);
            while(c.moveToNext()) {
                dm.remove(c.getLong(c.getColumnIndex(DownloadManager.COLUMN_ID)));
            }
        }
    }
    public TextView getName_count() {
        return name_count;
    }

    public void setName_count(TextView name_count) {
        this.name_count = name_count;
    }

    public ImageButton getDown() {
        return down;
    }

    public void setDown(ImageButton down) {
        this.down = down;
    }

    private  TextView name_count;
    private  ImageButton down;



    private ProgressBar pd;
    public ProgressBar getPd() {
        return pd;
    }

    public void setPd(ProgressBar pd) {
        this.pd = pd;
    }

private void startProgress(){
    try{

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                DownloadManager.Query q = new DownloadManager.Query();
                q.setFilterById(enqueue);
                final Cursor cursor = dm.query(q);
                cursor.moveToFirst();
                long bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                long bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                cursor.close();
                final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        pd.setProgress(dl_progress);
                    }
                });
                t.start();

            }
        }, 0, 10);}
    catch (Exception e) {
        Log.d("CountryViewHolder", "Error"+ e.getMessage() );
        e.printStackTrace();

    }
}


}

