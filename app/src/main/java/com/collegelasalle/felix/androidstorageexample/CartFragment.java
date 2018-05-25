package com.collegelasalle.felix.androidstorageexample;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CartFragment extends Fragment {

    private Product product1 = new Product(0,"Product1",0);
    private Product product2 = new Product(1,"Product2",0);
    private AppDatabase db;

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
                product1.count--;
                UpdateCount1();
            }
        });

        rootView.findViewById(R.id.buttonPlus).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                product1.count++;
                UpdateCount1();
            }
        });

        rootView.findViewById(R.id.buttonMinus2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                product2.count--;
                UpdateCount2();
            }
        });

        rootView.findViewById(R.id.buttonPlus2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                product2.count++;
                UpdateCount2();
            }
        });

        rootView.findViewById(R.id.buttonSave).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = getView().findViewById(R.id.editText);
                product1.productName = editText.getText().toString();
                editText = getView().findViewById(R.id.editText2);
                product2.productName = editText.getText().toString();
                db.productDao().insertAll(product1, product2);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = Room.databaseBuilder(getContext(), AppDatabase.class, "database-name").allowMainThreadQueries().build();
        List<Product> products = db.productDao().getAll();
        if (products.size() > 0)
        {
            for (Product product : products) {
                if (product.uid == 0) {
                    product1 = product;
                } else {
                    product2 = product;
                }
            }
        }
        UpdateCount1();
        UpdateCount2();
        UpdateNames();
    }

    void UpdateCount1() {
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(Integer.toString(product1.count));
    }

    void UpdateCount2() {
        TextView textView = getView().findViewById(R.id.textView2);
        textView.setText(Integer.toString(product2.count));
    }

    void UpdateNames() {
        EditText editText = getView().findViewById(R.id.editText);
        editText.setText(product1.productName);
        editText = getView().findViewById(R.id.editText2);
        editText.setText(product2.productName);
    }
}
