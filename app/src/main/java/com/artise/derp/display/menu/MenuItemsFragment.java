package com.artise.derp.display.menu;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.Util;
import com.artise.derp.data.datastructure.MenuTitle;
import com.artise.derp.display.MainActivity;

import java.util.ArrayList;


public class MenuItemsFragment extends Fragment {

    private static final int MAX_COLUMN = 3;

    private int iMenuTitle;
//    private ArrayList<String> menuItems;
    private MenuTitle menuItems;

    private LinearLayout menuItemsLayout;

    public static MenuItemsFragment newInstance(int iMenuTitle){
        Bundle b = new Bundle();
        b.putInt("iMenuTitle", iMenuTitle);

        MenuItemsFragment mif = new MenuItemsFragment();
        mif.setArguments(b);

        return mif;
    }


    private void readBundle(Bundle bundle){
        if(bundle != null){
            iMenuTitle = bundle.getInt("iMenuTitle");

            menuItems = MainActivity.menu.getMenuTitleAt(iMenuTitle);
        }
    }

    private LinearLayout createNewRow(){
        LinearLayout row = new LinearLayout((getActivity()));
        row.setOrientation(LinearLayout.HORIZONTAL);

        row.setId(Util.generateViewId());

        row.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));


        return row;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_items, container, false);

        readBundle(getArguments());

        menuItemsLayout = (LinearLayout) v.findViewById(R.id.menuItemsLayout);



        int nMenuItems = menuItems.size();

        LinearLayout row = createNewRow();



        int i;
        for(i=0; i < nMenuItems; i++){

            if(i % MAX_COLUMN == 0 && i != 0){
                menuItemsLayout.addView(row);

                row = createNewRow();
            }


            Fragment f = MenuItemSingleFragment.newInstance(iMenuTitle, i);


            getFragmentManager().beginTransaction().add(row.getId(), f).commit();


//            TextView text = new TextView(getActivity());
//            text.setText(menuItems.get(i));

//            row.addView(text);
        }



        Log.d("Test", "Row Size: " + row.getChildCount());

        while(i % MAX_COLUMN != 0){
            LinearLayout space = new LinearLayout(getActivity());

            space.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            ));

            row.addView(space);


            i++;
        }

        menuItemsLayout.addView(row);

        return v;
    }

}
