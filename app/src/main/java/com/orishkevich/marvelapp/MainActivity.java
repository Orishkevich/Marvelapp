package com.orishkevich.marvelapp;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ContinentFragment ff;
    private FragmentTransaction fT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> list = new ArrayList<>();

        try {
            XmlPullParser parser = getResources().getXml(R.xml.regions);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {

                for (int i = 0; i < parser.getAttributeCount(); i++) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("region")
                        &&parser.getAttributeValue(i).equals("continent")) {
                    for (int j = 0; j < parser.getAttributeCount(); j++) {
                    list.add(parser.getAttributeValue(j));
                    }
                }
                parser.next();
            }}
        } catch (Throwable t) {
            Toast.makeText(this,
                    "Ошибка при загрузке XML-документа: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Continent");
        ff=new ContinentFragment();
        fT=getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.frame,ff,"Continent");
        fT.addToBackStack(null);
        fT.commit();

    }*/



