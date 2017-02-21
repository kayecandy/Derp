package com.artise.derp.display.options;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.display.MainActivity;

/**
 * Created by Candice on 21/02/2017.
 */

public abstract class OptionsFragment extends Fragment {

    protected String label;

    protected View input;
    protected TextView optionsLabelText;
    protected LinearLayout optionsLayout;


    protected abstract void readExtraBundle(Bundle bundle);
    protected abstract View initializeInput();
    public abstract String getInputValue();



    public String getLabel(){
        return label;
    }

    public void readBundle(Bundle bundle){
        if(bundle != null){
            label = bundle.getString("label");

            readExtraBundle(bundle);
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
