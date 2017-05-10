package com.orishkevich.marvelapp.fragment;
/**Фрагмент с континентами**/

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import static com.orishkevich.marvelapp.Memory.bytesToHuman;
import com.orishkevich.marvelapp.adapter.ContinentAdapter;
import com.orishkevich.marvelapp.Memory;
import com.orishkevich.marvelapp.model.Continent;
import com.orishkevich.marvelapp.R;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;



public class ContinentFragment extends Fragment {


    private RecyclerView rvMain;
    private ContinentAdapter contAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Continent> cont;
    private String id;//country
    private SharedPreferences sharedPrefs;
    private String myPrefs = "myPrefs";
    private static final String countrySave = "countrySave";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ContinentFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_continent, container, false);
        cont = new ArrayList<>();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        sharedPrefs = getActivity().getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        //setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        Log.d("ContinentFragment", "onViewCreate");
        try {
            //парсинг континентов
            XmlPullParser parser = getResources().getXml(R.xml.regions);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {


                if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("region")
                        && (parser.getAttributeValue(0).equals("continent") || parser.getAttributeValue(0).equals("russia"))) {
                    if (parser.getAttributeValue(0).equals("russia"))
                        cont.add(new Continent(firstUpperCase(parser.getAttributeValue(0))));
                    else cont.add(new Continent(firstUpperCase(parser.getAttributeValue(1))));
                }
                parser.next();
            }
        } catch (Throwable t) {
            Log.d("ContinentFragment=", "onFailure" + t.getMessage());
        }
        ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        TextView textView3 = (TextView) getActivity().findViewById(R.id.percent);
        textView3.setText(bytesToHuman(new Memory().FreeMemory()));
        Log.d("ContinentFragment=", "TotalMemory()=" + new Memory().TotalMemory());
        Log.d("ContinentFragment=", "FreeMemory()=" + new Memory().FreeMemory());
        progressBar.setMax((int) (new Memory().TotalMemory() / 100l));
        progressBar.setProgress((int) (new Memory().BusyMemory() / 100l));

        rvMain = (RecyclerView) getActivity().findViewById(R.id.recycler_view_cont);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMain.setLayoutManager(layoutManager);
        contAdapter = new ContinentAdapter(cont);
        rvMain.setAdapter(contAdapter);
        contAdapter.setOnItemClickListener(new ContinentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                id = cont.get(position).getName();
                saveCountry(id);
                CountryFragment fragment = new CountryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, fragment, "Country");
                Bundle bundle = new Bundle();

                bundle.putString("key", id);
                Log.d("CountryFragment", "onItemClick1 ID=" + id);
                fragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

    }



    public String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    private void saveCountry(String count) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(countrySave, count);
        editor.apply();
    }
}



