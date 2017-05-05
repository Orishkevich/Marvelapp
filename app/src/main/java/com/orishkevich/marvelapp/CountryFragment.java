package com.orishkevich.marvelapp;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orishkevich.marvelapp.Adapter.CountryAdapter;
import com.orishkevich.marvelapp.Model.Country;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;




public class CountryFragment extends Fragment {

    private RecyclerView rvMain;
    private CountryAdapter countryAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Country> count;
    private String id;

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


        try {
            XmlPullParser parser = getResources().getXml(R.xml.regions);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {

                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("region")
                        &&parser.getAttributeValue(1).equals(id)
                        && parser.getAttributeName(0).equals("name")
                        )
                {

                        if (parser.getEventType() == XmlPullParser.START_TAG
                                && parser.getName().equals("region")
                                && parser.getAttributeName(0).equals("name")) {
                            Log.d("CountryFragment", "ADD!");
                            count.add(new Country(parser.getAttributeValue(0)));
                        }


                }

                parser.next();
            }
        } catch (Throwable t) {
            Log.d("CountryFragment", "There is an error");
            t.printStackTrace();
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
                            Log.d("CountryFragment", "onItemClick1 ID="+position);
                            RegionFragment fragment = new RegionFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame, fragment,"Region");
                            Bundle bundle = new Bundle();
                            id=count.get(position).getName();
                            bundle.putString("key", id);
                            fragment.setArguments(bundle);
                            transaction.addToBackStack(null);
                            transaction.commit();


                        }
                    });


                }






}
