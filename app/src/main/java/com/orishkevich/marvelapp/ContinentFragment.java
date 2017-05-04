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
    public ArrayList<Continent> cont=new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    public String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continent,container,false);
      //  View view = inflater.inflate(R.layout.activity_memory,container,false);

        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());

        long bytesAvailable = stat.getBlockSizeLong()  *stat.getBlockCountLong();
        long megAvailable = bytesAvailable / 1048576;
        Log.d("ContinentFragment","Available MB : "+megAvailable);
// https://inducesmile.com/android/how-to-get-android-ram-internal-and-external-memory-information/
        File path = Environment.getDataDirectory();
        StatFs stat2 = new StatFs(path.getPath());
        long blockSize = stat2.getBlockSizeLong();
        long availableBlocks = stat2.getAvailableBlocksLong();
        String format =  Formatter.formatFileSize(getActivity(), availableBlocks * blockSize);
        Log.d("ContinentFragment","Format : "+format);





        ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
       // progressBar.setVisibility(ProgressBar.VISIBLE);
// запускаем длительную операцию
//        progressBar.setVisibility(ProgressBar.INVISIBLE);


        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

                    try {
                XmlPullParser parser = getResources().getXml(R.xml.regions);

                while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {


                    if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("region")
                          &&parser.getAttributeValue(0).equals("continent")

                            ) {
                        Log.d("ContinentFragment","Continent : "+parser.getAttributeValue(null,"continent"));
                        cont.add(new Continent(parser.getAttributeValue(1)));
                    }
                    parser.next();
                }
            } catch (Throwable t) {

            }


        ListView memoryList = (ListView)getActivity().findViewById(R.id.list_of_memory);

        List<Memory> memoryDataSource = new ArrayList<Memory>();

        String heading = "RAM Information";
        long totalRamValue = totalRamMemorySize();
        long freeRamValue = freeRamMemorySize();
        long usedRamValue = totalRamValue - freeRamValue;
        int imageIcon = R.drawable.piechart;

        Memory mMemory = new Memory(heading, formatSize(usedRamValue) + " MB", formatSize(freeRamValue) + " MB", formatSize(totalRamValue) + " MB", imageIcon);
        memoryDataSource.add(mMemory);

        String internalMemoryTitle = "Internal Memory Information";
        long totalInternalValue = getTotalInternalMemorySize();
        long freeInternalValue = getAvailableInternalMemorySize();
        long usedInternalValue = totalInternalValue - freeInternalValue;
        int internalIcon = R.drawable.piechartone;

        Memory internalMemory = new Memory(internalMemoryTitle, formatSize(usedInternalValue), formatSize(freeInternalValue), formatSize(totalInternalValue), internalIcon);
        memoryDataSource.add(internalMemory);

        String externalMemoryTitle = "External Memory Information";
        long totalExternalValue = getTotalExternalMemorySize();
        long freeExternalValue = getAvailableExternalMemorySize();
        long usedExternalValue = totalExternalValue - freeExternalValue;
        int externalIcon = R.drawable.piecharttwo;

        Memory externalMemory = new Memory(externalMemoryTitle, formatSize(usedExternalValue), formatSize(freeExternalValue), formatSize(totalExternalValue), externalIcon);
        memoryDataSource.add(externalMemory);

        MemoryAdapter memoryAdapter = new MemoryAdapter(getActivity(), memoryDataSource);
        memoryList.setAdapter(memoryAdapter);

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



    private long freeRamMemorySize() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.availMem / 1048576L;

        return availableMegs;
    }

    private long totalRamMemorySize() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager)getActivity().getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        long availableMegs = mi.totalMem / 1048576L;
        return availableMegs;
    }

    public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }

    public static long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        } else {
            return 0;
        }
    }

    public static long getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        } else {
            return 0;
        }
    }

    public static String formatSize(long size) {
        String suffix = null;

        if (size >= 1024) {
            suffix = " KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = " MB";
                size /= 1024;
            }
        }
        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }
        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();
    }

    private String returnToDecimalPlaces(long values){
        DecimalFormat df = new DecimalFormat("#.00");
        String angleFormated = df.format(values);
        return angleFormated;
    }



}



