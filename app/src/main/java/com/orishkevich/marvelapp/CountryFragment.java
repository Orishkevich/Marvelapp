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

import java.util.ArrayList;




public class CountryFragment extends Fragment {

    public RecyclerView rvMain;
    public CountryAdapter countryAdapter;
    public LinearLayoutManager layoutManager;
    public ArrayList<Country> count=new ArrayList<>();
    public String id;
    public CountryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocab,container,false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id= bundle.getString("key");
        }
                return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CountryFragment", "onViewCreate");


                    rvMain = (RecyclerView)getActivity().findViewById(R.id.my_recycler_view2);

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
