package com.collegelasalle.felix.androidstorageexample;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private int count;
    private final String FILENAME = "420NA6AS";

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        rootView.findViewById(R.id.buttonMinus).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateCount(count - 1);
            }
        });

        rootView.findViewById(R.id.buttonPlus).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateCount(count + 1);
            }
        });

        rootView.findViewById(R.id.buttonSave).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                sharedPref.edit().putInt("count", count).commit();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        count = sharedPref.getInt("count", 0);
        UpdateCount(count);
    }

    void UpdateCount(int n) {
        count = n;
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(Integer.toString(count));
    }
}
