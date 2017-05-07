package com.orishkevich.marvelapp.Adapter;

import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.orishkevich.marvelapp.Model.Download;
import com.orishkevich.marvelapp.R;
import com.orishkevich.marvelapp.RetrofitInterface;

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
import retrofit2.Callback;
import retrofit2.Response;



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
            initDownload();
            Log.d("CountryViewHolder", "DownButtonListener" );
        }
    }

    private class CancelButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
           // cancel();
        }
    }
    private void initDownload(){
Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://download.osmand.net")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

        RetrofitInterface downloadService = retrofit.create(RetrofitInterface.class);

        Call<ResponseBody> call = downloadService.downloadFile();
        try {

            downloadFile(call.execute().body());

        } catch (IOException e) {

            e.printStackTrace();
           // Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
       /* call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d(TAG, "server contacted and has file");

                boolean writtenToDisk = writeResponseBodyToDisk(response.body());

                Log.d(TAG, "file download was a success? " + writtenToDisk);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
            }
        });*/
    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_DOWNLOADS),"Future Studio Icon.png");
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
    private void downloadFile(ResponseBody body) throws IOException {

        int count;
        byte data[] = new byte[1024 * 4];
        long fileSize = body.contentLength();
        InputStream bis = new BufferedInputStream(body.byteStream(), 1024 * 8);
        File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "file.zip");
        OutputStream output = new FileOutputStream(outputFile);
        long total = 0;
        long startTime = System.currentTimeMillis();
        int timeCount = 1;
        while ((count = bis.read(data)) != -1) {

            total += count;
            totalFileSize = (int) (fileSize / (Math.pow(1024, 2)));
            double current = Math.round(total / (Math.pow(1024, 2)));

            int progress = (int) ((total * 100) / fileSize);

            long currentTime = System.currentTimeMillis() - startTime;

            Download download = new Download();
            download.setTotalFileSize(totalFileSize);

            if (currentTime > 1000 * timeCount) {

                download.setCurrentFileSize((int) current);
                download.setProgress(progress);
             //   sendNotification(download);
                timeCount++;
            }

            output.write(data, 0, count);
        }
       // onDownloadComplete();
        output.flush();
        output.close();
        bis.close();

    }



}

