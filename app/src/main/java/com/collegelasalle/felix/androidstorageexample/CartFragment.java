package com.collegelasalle.felix.androidstorageexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private int count;

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
                UpdateCount(-1);
            }
        });

        rootView.findViewById(R.id.buttonPlus).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateCount(1);
            }
        });

        rootView.findViewById(R.id.buttonSave).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return rootView;
    }

    void UpdateCount(int change) {
        count += change;
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(Integer.toString(count));
    }

}
