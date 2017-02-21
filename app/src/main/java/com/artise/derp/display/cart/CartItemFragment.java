package com.artise.derp.display.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.MenuItem;
import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.data.datastructure.options.Options;
import com.artise.derp.display.MainActivity;
import com.artise.derp.display.options.types.AddonOptionsFragment;
import com.artise.derp.display.options.OptionsFragment;

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
                if(options.get(i) instanceof AddonOption){
                    optionsFragments.put(options.get(i), AddonOptionsFragment.newInstance(iMenuTitle, iMenuItem, i));
                }
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
//                getFragmentManager().beginTransaction().remove(f).commit();

                MainActivity.cart.removeCartItem(menuItem, f);

            }
        });


        cartItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<OptionsFragment> options = new ArrayList<OptionsFragment>(optionsFragments.values());

                for (int i=0; i < options.size(); i++){
                    Log.d("Test Options", options.get(i).getLabel());
                }

                MainActivity.options.changeCustomOptions(options);

                Log.d("Test", "cliciked");
            }
        });

        return v;
    }

}
