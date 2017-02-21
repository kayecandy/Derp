package com.artise.derp.display.menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.MenuItem;
import com.artise.derp.display.MainActivity;


public class MenuItemSingleFragment extends Fragment {

    private int iMenuTitle;
    private int iMenuItem;
    private MenuItem menuItem;

    private TextView productNameTextView;
    private TextView productPriceTextView;


    private static String getProductPriceString(float productPrice){
        return productPrice + " Php";
    }

    public static MenuItemSingleFragment newInstance(int iMenuTitle, int iMenuItem){
        Bundle b = new Bundle();

        b.putInt("iMenuTitle", iMenuTitle);
        b.putInt("iMenuItem", iMenuItem);

        MenuItemSingleFragment fragment = new MenuItemSingleFragment();
        fragment.setArguments(b);

        return fragment;
    }


    private void readBundle(Bundle bundle){
        if(bundle != null){
            iMenuTitle = bundle.getInt("iMenuTitle");
            iMenuItem = bundle.getInt("iMenuItem");

            menuItem = MainActivity.menu.getMenuTitleAt(iMenuTitle).get(iMenuItem);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_item_single, container, false);

        productNameTextView = (TextView) v.findViewById(R.id.productName);
        productPriceTextView = (TextView) v.findViewById(R.id.productPrice);

        readBundle(getArguments());


        productNameTextView.setText(menuItem.getName());
        productPriceTextView.setText(getProductPriceString(menuItem.getPrice()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.addCartItem(iMenuTitle, iMenuItem);
            }
        });

        return v;
    }


}
