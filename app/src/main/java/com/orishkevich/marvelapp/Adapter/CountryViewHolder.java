package com.orishkevich.marvelapp.Adapter;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orishkevich.marvelapp.Model.Country;
import com.orishkevich.marvelapp.Model.MessageEvent;
import com.orishkevich.marvelapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.DOWNLOAD_SERVICE;


public class CountryViewHolder extends RecyclerView.ViewHolder {
    private BroadcastReceiver receiverDownloadComplete;
    public final static String TAG = "CountryViewHolder";
    private ArrayList<Country> count;
    DownloadManager.Request request;
    private long enqueue;
    private DownloadManager dm;
    private ProgressBar mProgressBar;
    private TextView name_count;
    private ImageButton down;
    private ImageButton iB;
    private ProgressBar pd;
    private DownButtonListener downButtonListener = new DownButtonListener();

    private CancelButtonListener cancButtonListener = new CancelButtonListener();
    Timer myTimer;
    private static boolean queueDown=true;
    Thread tt;

    public CountryViewHolder(ArrayList<Country> count, final View itemView) {
        super(itemView);
        this.count = count;
        dm = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
        name_count = (TextView) itemView.findViewById(R.id.recyclerViewItemName);
        down = (ImageButton) itemView.findViewById(R.id.recyclerViewItemDownButton);

        iB= (ImageButton) itemView.findViewById(R.id.recyclerViewItemIcon);
        pd = (ProgressBar) itemView.findViewById(R.id.prog_down_item);
        down.setOnClickListener(downButtonListener);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CountryAdapter.listener != null) {
                    CountryAdapter.listener.onItemClick(itemView, getLayoutPosition());
                }
            }
        });
    }


    public class DownButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.d("CountryViewHolder", "DownButtonListener"+queueDown);
            if (queueDown){
                Log.d("CountryViewHolder", "DownButtonListenerStart");
                queueDown=false;
                pd.setVisibility(View.VISIBLE);
            down.setImageResource(R.drawable.ic_action_remove_dark);
            down.setOnClickListener(cancButtonListener);
            request = new DownloadManager.Request(
                    Uri.parse(count.get(getAdapterPosition()).getAdress()));
            request.setDescription("Map Download")
                    .setTitle(count.get(getAdapterPosition()).getName());
            request.setVisibleInDownloadsUi(true);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            enqueue = dm.enqueue(request);


            IntentFilter intentFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
            receiverDownloadComplete = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    long reference = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                    if (enqueue == reference) {

                        DownloadManager.Query query = new DownloadManager.Query();
                        query.setFilterById(reference);
                        Cursor cursor = dm.query(query);

                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        int status = cursor.getInt(columnIndex);

                        int fileNameIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
                        String savedFilePath = cursor.getString(fileNameIndex);


                        int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
                        int reason = cursor.getInt(columnReason);

                        switch (status) {
                            case DownloadManager.STATUS_SUCCESSFUL:
                                queueDown=true;
                                myTimer.cancel();
                                tt.interrupt();
                                pd.setVisibility(View.GONE);
                                down.setImageResource(R.drawable.ic_action_import);
                                down.setOnClickListener(downButtonListener);
                                iB.setBackgroundResource(R.color.green);
                                Log.d("BroadcastReceiver", "STATUS_SUCCESSFUL");
                                break;
                            case DownloadManager.STATUS_FAILED:
                                queueDown=true;
                                Log.d("BroadcastReceiver", "STATUS_FAILED="+ queueDown);

                                break;
                            case DownloadManager.STATUS_PAUSED:
                                queueDown=true;
                                Log.d("BroadcastReceiver", "STATUS_PAUSED");
                                break;
                            case DownloadManager.STATUS_PENDING:
                                queueDown=true;
                                Log.d("BroadcastReceiver", "STATUS_PENDING");
                                break;
                            case DownloadManager.STATUS_RUNNING:

                                Log.d("BroadcastReceiver", "STATUS_RUNNING");
                                break;
                        }
                        cursor.close();
                    }
                }
            };
            itemView.getContext().registerReceiver(receiverDownloadComplete, intentFilter);
            startProgress();


        }

    }
    }

    private class CancelButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            myTimer.cancel();
            tt.interrupt();
            queueDown=true;
            itemView.getContext(). unregisterReceiver(receiverDownloadComplete);

            pd.setVisibility(View.GONE);
            down.setImageResource(R.drawable.ic_action_import);
            down.setOnClickListener(downButtonListener);

            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus(DownloadManager.STATUS_FAILED | DownloadManager.STATUS_PENDING | DownloadManager.STATUS_RUNNING);
            DownloadManager dm = (DownloadManager) itemView.getContext().getSystemService(DOWNLOAD_SERVICE);
            Cursor c = dm.query(query);
            while (c.moveToNext()) {
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

    public ProgressBar getPd() {
        return pd;
    }

    public void setPd(ProgressBar pd) {
        this.pd = pd;
    }

    private void startProgress() {


            try {

                myTimer = new Timer();
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
                        tt = new Thread(new Runnable() {
                            public void run() {

                                EventBus.getDefault().post(new MessageEvent(count.get(getAdapterPosition()).getName(), dl_progress, queueDown));

                                pd.setProgress(dl_progress);

                            }
                        });
                        tt.start();

                    }
                }, 0, 10);

            } catch (CursorIndexOutOfBoundsException e) {
                Log.d("CountryViewHolder", "Error" + e.getMessage());
              //  e.printStackTrace();

            }
        }


}

