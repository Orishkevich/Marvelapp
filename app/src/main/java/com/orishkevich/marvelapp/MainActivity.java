package com.orishkevich.marvelapp;
/**загрузка фрагмента с континентами*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import android.support.v4.app.FragmentTransaction;

import com.orishkevich.marvelapp.fragment.ContinentFragment;

public class MainActivity extends AppCompatActivity {
    private ContinentFragment fF;
    private FragmentTransaction fT;
    private ProgressBar mProgressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.prog_down_main);
        mProgressBar.setVisibility(View.GONE);

        setTitle("Continent");
        fF = new ContinentFragment();
        fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.frame, fF, "Continent");
        fT.addToBackStack(null);
        fT.commit();
    }
}



