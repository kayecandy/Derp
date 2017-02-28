package com.artise.derp.display.options;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.display.MainActivity;
import com.artise.derp.data.datastructure.options.Options;

/**
 * Created by Candice on 21/02/2017.
 */

public abstract class OptionsFragment extends Fragment {

    protected String label;

    protected int iMenuTitle;
    protected int iMenuItem;
    protected int iMenuItemOption;

    protected Options option;

    protected View input;
    protected TextView optionsLabelText;
    protected LinearLayout optionsLayout;


    protected abstract View initializeInput();
    public abstract String getInputValue();


    public static OptionsFragment newInstance(Class<?> optionsFragmentSubclass, int iMenuTitle, int iMenuItem, int iMenuItemOption){

        Bundle b = new Bundle();

        b.putInt("iMenuTitle", iMenuTitle);
        b.putInt("iMenuItem", iMenuItem);
        b.putInt("iMenuItemOption", iMenuItemOption);

        try {

            OptionsFragment fragment = (OptionsFragment) optionsFragmentSubclass.newInstance();

            fragment.setArguments(b);

            return fragment;

        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;


    }


    public void readBundle(Bundle bundle){
        if(bundle != null){

            iMenuTitle = bundle.getInt("iMenuTitle");
            iMenuItem = bundle.getInt("iMenuItem");
            iMenuItemOption = bundle.getInt("iMenuItemOption");


            option = MainActivity.menu.getMenuItemOptionAt(iMenuTitle, iMenuItem, iMenuItemOption);

            label = option.getName();

            Log.d("Test Options", label);


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        View v = inflater.inflate(R.layout.fragment_options, container, false);

        optionsLabelText = (TextView)v.findViewById(R.id.optionsLabel);
        optionsLayout = (LinearLayout)v.findViewById(R.id.optionsLayout);

        readBundle(getArguments());


        input = initializeInput();
        input.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1
        ));

        optionsLabelText.setText(label);


        optionsLayout.addView(input);





        return v;
    }



}
