package com.example.guitorio.roompersistancelibrary.allproducts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guitorio.roompersistancelibrary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppProductsFragment extends Fragment {

    private RecyclerView recyclerViewAllProducts;


    public AppProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_app_products, container, false);



        return view;
    }

}
