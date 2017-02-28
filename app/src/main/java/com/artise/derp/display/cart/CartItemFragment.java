package com.artise.derp.display.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.MenuItem;
import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.data.datastructure.options.CheckboxOption;
import com.artise.derp.data.datastructure.options.Options;
import com.artise.derp.display.MainActivity;
import com.artise.derp.display.options.custom.AddonOptionsFragment;
import com.artise.derp.display.options.OptionsFragment;
import com.artise.derp.display.options.custom.CheckboxOptionsFragment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartItemFragment extends Fragment {


    private int iMenuTitle;
    private int iMenuItem;
    private int quantity;

    private MenuItem menuItem;


    private TextView nameTextView;
    private TextView priceTextView;
    private TextView quantityTextView;

    private ImageView trashIcon;

    private LinearLayout cartItemLayout;


    private HashMap<Options, OptionsFragment> optionsFragments;


    private String getQuantityString(int quantity){
        return "x" + quantity;
    }

    private String getPriceString(long price){
        return "(" + price + " Php)";
    }

    public void addQuantity(){
        quantity++;
        quantityTextView.setText(getQuantityString(quantity));
    }

    public static CartItemFragment newInstance(int iMenuTitle, int iMenuItem, int quantity){
        Bundle b = new Bundle();

        b.putInt("iMenuTitle", iMenuTitle);
        b.putInt("iMenuItem", iMenuItem);
        b.putInt("quantity", quantity);

        CartItemFragment fragment = new CartItemFragment();
        fragment.setArguments(b);

        return fragment;
    }

    private void readBundle(Bundle bundle){
        if(bundle != null){
            iMenuTitle = bundle.getInt("iMenuTitle");
            iMenuItem = bundle.getInt("iMenuItem");
            quantity = bundle.getInt("quantity");

            menuItem = MainActivity.menu.getMenuItemAt(iMenuTitle, iMenuItem);
            optionsFragments = new HashMap<>();

            ArrayList<Options> options = menuItem.getOptionsList();
            for(int i=0; i < options.size(); i++){
                Class<?> optionClass = null;
                if(options.get(i) instanceof AddonOption){
                    optionClass = AddonOptionsFragment.class;
                }else if(options.get(i) instanceof CheckboxOption){
                    optionClass = CheckboxOptionsFragment.class;
                }

                optionsFragments.put(options.get(i), OptionsFragment.newInstance(optionClass, iMenuTitle, iMenuItem, i));

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart_item, container, false);

        nameTextView = (TextView) v.findViewById(R.id.productName);
        quantityTextView = (TextView) v.findViewById(R.id.quantity);
        priceTextView = (TextView) v.findViewById(R.id.productPrice);

        trashIcon = (ImageView) v.findViewById(R.id.trashIcon);

        cartItemLayout = (LinearLayout) v.findViewById(R.id.cartItemLayout);

        readBundle(getArguments());


        nameTextView.setText(menuItem.getName());
        priceTextView.setText(getPriceString(menuItem.getPrice()));
        quantityTextView.setText(getQuantityString(quantity));

        final Fragment f = this;


        trashIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.cart.removeCartItem(menuItem, f);

            }
        });


        cartItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity.options.changeCustomOptions(optionsFragments);

            }
        });

        MainActivity.options.changeCustomOptions(optionsFragments);


        return v;
    }

}
