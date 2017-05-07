package com.orishkevich.marvelapp.Adapter;

import android.app.DownloadManager;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.orishkevich.marvelapp.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.DOWNLOAD_SERVICE;



public class CountryViewHolder extends RecyclerView.ViewHolder {
    final static String TAG = "CountryViewHolder";
    private int totalFileSize;
    public  TextView name_count;
    public  ImageButton down;
    public ProgressBar pd;


    private long enqueue;
    private DownloadManager dm;
    protected ProgressBar mProgressBar;
    protected long downloadId;


   // public  ImageButton canc;
    private DownButtonListener downButtonListener;
   // private CancelButtonListener cancButtonListener;

        public CountryViewHolder(final View itemView){
            super(itemView);
            dm = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);

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

            DownloadManager.Request request = new DownloadManager.Request(
                    Uri.parse("http://download.osmand.net/download.php?standard=yes&file=Denmark_europe_2.obf.zip"));

            enqueue = dm.enqueue(request);
            mProgressBar = pd;
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
                            mProgressBar.setProgress(dl_progress);

                        }
                    });
                    t.start();

                }

            }, 0, 10);
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

