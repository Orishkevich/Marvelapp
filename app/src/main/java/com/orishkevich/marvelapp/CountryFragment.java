package com.orishkevich.marvelapp;



import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.orishkevich.marvelapp.Adapter.CountryAdapter;
import com.orishkevich.marvelapp.Model.Continent;
import com.orishkevich.marvelapp.Model.Country;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;


public class CountryFragment extends Fragment {

    private RecyclerView rvMain;
    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Country> count;
    private String id;
    final String LOG_TAG = "CountryFragment";
    boolean map=true;
    boolean download=false;
    public CountryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count,container,false);
        count=new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null) {
            id= bundle.getString("key");
        }


                return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProgressBar progDown=(ProgressBar)getActivity().findViewById(R.id.prog_down);
        progDown.setVisibility(View.INVISIBLE);

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
                                           count.add(new Country(firstUpperCase(xpp.getAttributeValue(0)),map,download));
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




}
