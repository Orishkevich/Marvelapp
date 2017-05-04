package com.orishkevich.marvelapp;

import android.app.ActivityManager;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.orishkevich.marvelapp.Adapter.ContinentAdapter;
import com.orishkevich.marvelapp.Adapter.CountryAdapter;
import com.orishkevich.marvelapp.Model.Continent;


import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

public class ContinentFragment extends Fragment {

    private String TAG = getClass().getName();
    public RecyclerView rvMain;
    public ContinentAdapter contAdapter;
    public LinearLayoutManager layoutManager;
    public ArrayList<Continent> cont;

    public String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ContinentFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_continent,container,false);


        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("ContinentFragment", "onCreate");
        cont=new ArrayList<>();

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Log.d("ContinentFragment", "onViewCreate");
        try {
            XmlPullParser parser = getResources().getXml(R.xml.regions);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {


                if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("region")
                        &&parser.getAttributeValue(0).equals("continent")

                        ) {
                    //Log.d("ContinentFragment","Continent : "+parser.getAttributeValue(null,"continent"));
                    cont.add(new Continent(parser.getAttributeValue(1)));
                }
                parser.next();
            }
        } catch (Throwable t) {

        }
       ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        TextView textView3 = (TextView)getActivity().findViewById(R.id.textView3);
        textView3.setText(bytesToHuman(FreeMemory()));
        progressBar.setMax(TotalMemory());
        progressBar.setProgress(FreeMemory());

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
    // https://inducesmile.com/android/how-to-get-android-ram-internal-and-external-memory-information/
    public int TotalMemory()
    {

        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        int   Total  = (  statFs.getBlockCount() *  statFs.getBlockSize());
        return Total;
    }

    public int FreeMemory()
    {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        int   Free   = (statFs.getAvailableBlocks() *  statFs.getBlockSize());
        return Free;
    }

    public long BusyMemory()
    {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long   Total  = ((long) statFs.getBlockCount() * (long) statFs.getBlockSize());
        long   Free   = (statFs.getAvailableBlocks()   * (long) statFs.getBlockSize());
        long   Busy   = Total - Free;
        return Busy;
    }
    public static String floatForm (double d)
    {
        return new DecimalFormat("#.##").format(d);
    }


    public static String bytesToHuman (long size)
    {
        long Kb = 1  * 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size <  Kb)                 return floatForm(        size     ) + " byte";
        if (size >= Kb && size < Mb)    return floatForm((double)size / Kb) + " Kb";
        if (size >= Mb && size < Gb)    return floatForm((double)size / Mb) + " Mb";
        if (size >= Gb && size < Tb)    return floatForm((double)size / Gb) + " Gb";
        if (size >= Tb && size < Pb)    return floatForm((double)size / Tb) + " Tb";
        if (size >= Pb && size < Eb)    return floatForm((double)size / Pb) + " Pb";
        if (size >= Eb)                 return floatForm((double)size / Eb) + " Eb";

        return "???";
    }

}



