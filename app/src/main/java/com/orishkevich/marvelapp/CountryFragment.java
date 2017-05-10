package com.orishkevich.marvelapp;
/**Фрагмент со странами*/

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

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


public class CountryFragment extends Fragment {


    private RecyclerView rvMain;
    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Country> count;
    private String country;
    final String LOG_TAG = "CountryFragment";
    boolean map = true;
    boolean download = false;
    private TextView textView2;
    boolean offfOn;
    private TextView textView3;
    private long enqueue;
    private DownloadManager dm;
    protected ProgressBar mProgressBar;
    private View viewById;

    public SharedPreferences sharedPrefs;
    public String myPrefs = "myPrefs";
    public static final String countrySave = "countrySave";


    public CountryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count, container, false);
        count = new ArrayList<>();
        Bundle bundle = getArguments();

        if (bundle != null) {
            country = firstDownCase(bundle.getString("key"));
        }
        Log.d(LOG_TAG, "START_onCreateView");



        sharedPrefs = this.getActivity().getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(countrySave)) {
            country=sharedPrefs.getString(countrySave, "");
            Log.d(LOG_TAG, "sharedPrefs="+ country );
        }
        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "START_onCreate="+ country );

        sharedPrefs = this.getActivity().getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(countrySave)) {
            country=sharedPrefs.getString(countrySave, "");
            Log.d(LOG_TAG, "sharedPrefs="+ country );
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "START_onViewCreated="+ country );

        textView3 = (TextView) getActivity().findViewById(R.id.country);
        viewById = getActivity().findViewById(R.id.PD);
        textView2 = (TextView) getActivity().findViewById(R.id.percent);
        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.prog_down_items);


        mProgressBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager manager = getActivity().getSupportFragmentManager();
                DialogPBFragment myDialogFragment = new DialogPBFragment();
                myDialogFragment.show(manager, "dialog");

            }
        });

        try {
            //парсинг стран по континенту
            Log.d(LOG_TAG, "START_PARSING"+ country );
            XmlPullParser xpp = getResources().getXml(R.xml.regions);
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(LOG_TAG, "START_DOCUMENT");
                        break;
                    case XmlPullParser.START_TAG:

                        for (int i = 0; i < xpp.getAttributeCount(); i++) {

                            if (xpp.getAttributeValue(i).equals(country)) {
                                for (int j = 0; j < xpp.getAttributeCount(); j++) {
                                    if (xpp.getAttributeName(j).equals("name")) {

                                        xpp.next();

                                        while ((xpp.getEventType() == XmlPullParser.START_TAG) &&
                                                !(xpp.getAttributeValue(0).equals("continent"))) {
                                            if ((xpp.getAttributeName(0).equals("name")
                                                    || xpp.getAttributeName(1).equals("name"))) {
                                                map = true;
                                                for (int x = 0; x < xpp.getAttributeCount(); x++) {

                                                    if (xpp.getAttributeName(x).equals("map")) {
                                                        switch (xpp.getAttributeValue(x)) {
                                                            case "no":
                                                                map = false;
                                                                break;
                                                            default:
                                                                break;
                                                        }

                                                    }

                                                }
                                                Log.d(LOG_TAG, "Country=" + xpp.getAttributeValue(0));
                                                Log.d(LOG_TAG, "Map=" + map);
                                                count.add(new Country(firstUpperCase(xpp.getAttributeValue(0)), map, download, country));
                                                xpp.next();
                                                while (xpp.getDepth() > 3) {
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

                    case XmlPullParser.END_TAG:

                        break;

                    case XmlPullParser.TEXT:

                        break;

                    default:
                        break;
                }

                xpp.next();
            }
            Log.d(LOG_TAG, "END_DOCUMENT");

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rvMain = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMain.setLayoutManager(layoutManager);
        countryAdapter = new CountryAdapter(count);
        rvMain.setAdapter(countryAdapter);
        countryAdapter.setOnItemClickListener(new CountryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (v.getClass().equals(ImageButton.class))
                    Log.d("CountryFragment", "Click Image button ID=" + position);
                else {
                    Log.d("CountryFragment", "v.getClass()=" + v.getClass());
                    Log.d("CountryFragment", "onItemClick1 ID=" + position);
                    RegionFragment fragment = new RegionFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragment, "Region");
                    Bundle bundle = new Bundle();
                    country= count.get(position).getName();
                    bundle.putString("key", country);
                    fragment.setArguments(bundle);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }

            }
        });
    }

    public String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public String firstDownCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }


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

//отслеживание загрузки
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        offfOn = event.getQd();
        if (!offfOn) {
            textView2 = (TextView) getActivity().findViewById(R.id.percent);

            viewById.setVisibility(View.VISIBLE);
            textView3.setText(event.message);
            final int dl = event.getDl();
            textView2.setText(String.valueOf(dl) + " %");
            Thread tt = new Thread(new Runnable() {
                public void run() {

                    mProgressBar.setProgress(dl);

                }
            });
            tt.start();
            offfOn = false;//???
        }
    }
}
