package com.orishkevich.marvelapp;



import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.orishkevich.marvelapp.Adapter.CountryAdapter;
import com.orishkevich.marvelapp.Model.Country;
import com.orishkevich.marvelapp.Model.MessageEvent;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CountryFragment extends Fragment {

    public static final String MESSAGE_PROGRESS = "message_progress";
    private static final int PERMISSION_REQUEST_CODE = 1;

    private TextView mProgressText;
    private RecyclerView rvMain;
    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Country> count;
    private String id;
    final String LOG_TAG = "CountryFragment";
    boolean map=true;
    boolean download=false;
    private TextView textView2;

    private TextView textView3;
    private long enqueue;
    private DownloadManager dm;
    protected ProgressBar mProgressBar;
    protected long downloadId;


    DownloadManager downloadManager=dm;
    String downloadFileUrl = "http://www.101apps.co.za/" +
            "images/headers/101_logo_very_small.jpg";
    private long myDownloadReference= enqueue;
    private BroadcastReceiver receiverDownloadComplete;
    private BroadcastReceiver receiverNotificationClicked;
    View viewById;


    public CountryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count,container,false);
        count=new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null) {
            id= firstDownCase(bundle.getString("key"));
        }
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
     /*   BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    downloadId = intent.getLongExtra(
                            DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(enqueue);
                    Cursor c = dm.query(query);
                    if (c.moveToFirst()) {
                        int columnIndex = c
                                .getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if (DownloadManager.STATUS_SUCCESSFUL == c
                                .getInt(columnIndex)) {

                            ImageView view = (ImageView) getActivity().findViewById(R.id.imageView1);
                            String uriString = c
                                    .getString(c
                                            .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                            view.setImageURI(Uri.parse(uriString));
                        }
                    }
                }
            }
        };

        getActivity().registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));*/
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


                try {
            XmlPullParser xpp =getResources().getXml(R.xml.regions);
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало документа
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(LOG_TAG, "START_DOCUMENT");
                        break;
                    // начало тэга
                    case XmlPullParser.START_TAG:

                        for (int i = 0; i < xpp.getAttributeCount(); i++) {

                            if (xpp.getAttributeValue(i).equals(id)) {
                                for (int j = 0; j < xpp.getAttributeCount(); j++) {
                                    if( xpp.getAttributeName(j).equals("name"))
                                    {

                                      xpp.next();

                                      while ((xpp.getEventType() == XmlPullParser.START_TAG)&&
                                          !(xpp.getAttributeValue(0).equals("continent"))) {
                                       if ((xpp.getAttributeName(0).equals("name")
                                               ||xpp.getAttributeName(1).equals("name"))) {
                                            map=true;
                                           for(int x = 0; x < xpp.getAttributeCount(); x++){

                                               if (xpp.getAttributeName(x).equals("map")) {
                                                   switch (xpp.getAttributeValue(x)){
                                                       case "no":
                                                           map = false;
                                                           break;
                                                       default:
                                                           break;
                                                   }

                                               }

                                           }
                                           Log.d(LOG_TAG, "Country="+xpp.getAttributeValue(0));
                                           Log.d(LOG_TAG, "Map="+map);
                                           count.add(new Country(firstUpperCase(xpp.getAttributeValue(0)),map,download,id));
                                            xpp.next();
                                           while(xpp.getDepth()>3){
                                               xpp.next();
                                           }
                                        }
                                          xpp.next();
                                        }
                                    }
                                }
                            }

                        }
                        break;
                    // конец тэга
                    case XmlPullParser.END_TAG:

                        break;
                    // содержимое тэга
                    case XmlPullParser.TEXT:

                        break;

                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }
            Log.d(LOG_TAG, "END_DOCUMENT");

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
                    rvMain = (RecyclerView)getActivity().findViewById(R.id.my_recycler_view);
                    layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvMain.setLayoutManager(layoutManager);
                    countryAdapter = new CountryAdapter(count);
                    rvMain.setAdapter(countryAdapter);
                    countryAdapter.setOnItemClickListener(new CountryAdapter.OnItemClickListener(){
                        @Override
                        public void onItemClick(View v, int position){
                            if(v.getClass().equals(ImageButton.class))Log.d("CountryFragment", "Click Image button ID="+position);
                            else {
                                Log.d("CountryFragment", "v.getClass()=" + v.getClass());
                                Log.d("CountryFragment", "onItemClick1 ID=" + position);
                                RegionFragment fragment = new RegionFragment();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.frame, fragment, "Region");
                                Bundle bundle = new Bundle();
                                id = count.get(position).getName();
                                bundle.putString("key", id);
                                fragment.setArguments(bundle);
                                transaction.addToBackStack(null);
                                transaction.commit();

                            }

                        }
                    });
                }

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

        public String firstDownCase(String word){
        if(word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }


    /*@Override
    public void onResume() {
        super.onResume();

//        filter for notifications - only acts on notification
//              while download busy
        IntentFilter filter = new IntentFilter(DownloadManager
                .ACTION_NOTIFICATION_CLICKED);

        receiverNotificationClicked = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String extraId = DownloadManager
                        .EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS;
                long[] references = intent.getLongArrayExtra(extraId);
                for (long reference : references) {
                    if (reference == myDownloadReference) {
//                        do something with the download file
                    }
                }
            }
        };
        getActivity().registerReceiver(receiverNotificationClicked, filter);

//        filter for download - on completion
        IntentFilter intentFilter = new IntentFilter(DownloadManager
                .ACTION_DOWNLOAD_COMPLETE);

        receiverDownloadComplete = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                long reference = intent.getLongExtra(DownloadManager
                        .EXTRA_DOWNLOAD_ID, -1);
                if (myDownloadReference == reference) {
//                    do something with the download file
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(reference);
                    Cursor cursor = downloadManager.query(query);

                    cursor.moveToFirst();
//                        get the status of the download
                    int columnIndex = cursor.getColumnIndex(DownloadManager
                            .COLUMN_STATUS);
                    int status = cursor.getInt(columnIndex);

                    int fileNameIndex = cursor.getColumnIndex(DownloadManager
                            .COLUMN_LOCAL_FILENAME);
                    String savedFilePath = cursor.getString(fileNameIndex);

//                        get the reason - more detail on the status
                    int columnReason = cursor.getColumnIndex(DownloadManager
                            .COLUMN_REASON);
                    int reason = cursor.getInt(columnReason);

                    switch (status) {
                        case DownloadManager.STATUS_SUCCESSFUL:

//                                start activity to display the downloaded image
                            Toast.makeText(getActivity(),
                                    "Start activity to display the downloaded image: " + reason,
                                    Toast.LENGTH_LONG).show();

                            break;
                        case DownloadManager.STATUS_FAILED:
                            Toast.makeText(getActivity(),
                                    "FAILED: " + reason,
                                    Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_PAUSED:
                            Toast.makeText(getActivity(),
                                    "PAUSED: " + reason,
                                    Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_PENDING:
                            Toast.makeText(getActivity(),
                                    "PENDING!",
                                    Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_RUNNING:
                            Toast.makeText(getActivity(),
                                    "RUNNING!",
                                    Toast.LENGTH_LONG).show();
                            break;
                    }
                    cursor.close();
                }
            }
        };
        getActivity().registerReceiver(receiverDownloadComplete, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiverDownloadComplete);
        getActivity().unregisterReceiver(receiverNotificationClicked);
    }*/
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){

        textView2 = (TextView)getActivity().findViewById(R.id.percent);
        textView3 = (TextView)getActivity().findViewById(R.id.country);
        viewById = getActivity().findViewById(R.id.PD);
        viewById.setVisibility(View.VISIBLE);
        mProgressBar=(ProgressBar) getActivity().findViewById(R.id.prog_down_items);
        textView3.setText(event.message);
        final int dl=event.getDl();

        textView2.setText(String.valueOf(dl)+" %");


        Thread tt = new Thread(new Runnable() {
            public void run() {

                mProgressBar.setProgress(dl);

            }
        });
        tt.start();


    }
}
