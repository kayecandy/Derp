package com.artise.derp.display.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artise.derp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartContainerFragment extends Fragment {


    public CartContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart_container, container, false);

        return v;
    }

}
