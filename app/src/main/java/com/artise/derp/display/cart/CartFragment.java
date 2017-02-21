package com.artise.derp.display.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.MenuItem;
import com.artise.derp.display.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private LinearLayout cartLayout;

    private HashMap<MenuItem, CartItemFragment> cartItems;

    public void addCartItemOnce(int iMenuTitle, int iMenuItem){

        MenuItem item = MainActivity.menu.getMenuItemAt(iMenuTitle, iMenuItem);
        Fragment f = CartItemFragment.newInstance(iMenuTitle, iMenuItem, 1);

        if(cartItems.containsKey(item)){

            cartItems.get(item).addQuantity();

        }else{
            getFragmentManager().beginTransaction().add(cartLayout.getId(), f).commit();
            cartItems.put(item, (CartItemFragment) f);
        }

    }

    public void removeCartItem(MenuItem item, Fragment fragment){
        getFragmentManager().beginTransaction().remove(fragment).commit();

        cartItems.remove(item);
    }

    public void addCartItem(int iMenuTitle, int iMenuItem){


        Fragment f = CartItemFragment.newInstance(iMenuTitle, iMenuItem, 1);

        getFragmentManager().beginTransaction().add(cartLayout.getId(), f).commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        MainActivity.cart = this;
        cartLayout = (LinearLayout) v.findViewById(R.id.cartLayout);

        cartItems = new HashMap<>();

        return v;
    }

}
