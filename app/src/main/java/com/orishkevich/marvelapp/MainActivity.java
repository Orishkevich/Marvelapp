package com.orishkevich.marvelapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ContinentFragment ff;
    private FragmentTransaction fT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Continent");
        ff=new ContinentFragment();
        fT=getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.frame,ff,"Continent");
        fT.addToBackStack(null);
        fT.commit();

    }
    }


