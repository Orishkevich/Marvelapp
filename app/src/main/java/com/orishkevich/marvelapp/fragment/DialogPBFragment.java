package com.orishkevich.marvelapp.fragment;
/**
 * Необходимо тут использовать RecycleView.
 * Google теперь не рекомендует использовать ProgressDialog в новых версиях Androd.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orishkevich.marvelapp.R;


public class DialogPBFragment extends DialogFragment implements
        DialogInterface.OnClickListener {

    protected ProgressBar mProgressBar;
    private TextView textView2;
    private boolean offfOn;
    private TextView textView3;
    private View form = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView3 = (TextView) getActivity().findViewById(R.id.country);
        textView2 = (TextView) getActivity().findViewById(R.id.percent);
        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.prog_down_items);


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        form = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return (builder.setTitle("Downloads").setView(form)
                .setNegativeButton(R.string.close, null).create());
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {


    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);

     /*   CountryFragment parentFragment = new CountryFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, parentFragment, "Country");
        transaction.addToBackStack(null);
        transaction.commit();*/


    }

    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
    }

    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        Log.d("DialogFragment", "Start  onEvent");

            textView2 = (TextView) getActivity().findViewById(R.id.percent);
            textView3.setText(event.message);
            final int dl = event.getDl();
            textView2.setText(String.valueOf(dl) + " %");
            Thread tt = new Thread(new Runnable() {
                public void run() {

                    mProgressBar.setProgress(dl);

                }
            });
            tt.start();

    }*/
}