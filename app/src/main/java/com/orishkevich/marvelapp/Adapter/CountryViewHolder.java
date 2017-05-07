package com.orishkevich.marvelapp.Adapter;

import android.app.DownloadManager;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.orishkevich.marvelapp.R;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit2.Call;


public class CountryViewHolder extends RecyclerView.ViewHolder {
    final static String TAG = "CountryViewHolder";
    private int totalFileSize;
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
           // initDownload();
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

