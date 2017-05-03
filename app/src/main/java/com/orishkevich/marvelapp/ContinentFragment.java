package com.orishkevich.marvelapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orishkevich.marvelapp.Adapter.ContinentAdapter;
import com.orishkevich.marvelapp.Adapter.CountryAdapter;
import com.orishkevich.marvelapp.Model.Continent;


import java.util.ArrayList;

public class ContinentFragment extends Fragment {

    public RecyclerView rvMain;
    public ContinentAdapter contAdapter;
    public LinearLayoutManager layoutManager;
    public ArrayList<Continent> cont=new ArrayList<>();

    public String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continent,container,false);
        cont.add(new Continent("Ukraine"));
        cont.add(new Continent("Poland"));
        cont.add(new Continent("Latvia"));
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

        contAdapter = new ContinentAdapter(cont);
        rvMain.setAdapter(contAdapter);

        contAdapter.setOnItemClickListener(new ContinentAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int position){
                Log.d("ContinentFragment", "onItemClick1 ID="+position);
                CountryFragment fragment = new CountryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, fragment,"Country");
                Bundle bundle = new Bundle();
                id=cont.get(position).getName();
                bundle.putString("key", id);
                fragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });


    }






}



