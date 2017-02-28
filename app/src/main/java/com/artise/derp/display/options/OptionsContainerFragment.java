package com.artise.derp.display.options;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.artise.derp.R;
import com.artise.derp.display.MainActivity;

import com.artise.derp.data.datastructure.options.Options;
import com.artise.derp.display.options.fixed.QuantityOptionsFragment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsContainerFragment extends Fragment {

    private LinearLayout fixedOptionsLayout;
    private LinearLayout customOptionsLayout;

    private Button updateButton;

    HashMap<Options, OptionsFragment> currentOptions;





    private void clearCustomOptions(){

        if(currentOptions != null){

            ArrayList<OptionsFragment> tempOptions = new ArrayList<>(currentOptions.values());

            for(int i=0; i < currentOptions.size(); i++){
                getFragmentManager().beginTransaction().remove(tempOptions.get(i)).commit();
            }
        }else{
            Log.d("Test", "null options fragments");
        }

    }

    public void changeCustomOptions(HashMap<Options, OptionsFragment> options){
        if(currentOptions != options){
            clearCustomOptions();

            currentOptions = options;

            ArrayList<OptionsFragment> tempOptions = new ArrayList<>(options.values());

            for(int i=0; i < options.size(); i++){
                getFragmentManager().beginTransaction().add(customOptionsLayout.getId(), tempOptions.get(i)).commit();
            }

        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_options_container, container, false);

        MainActivity.options = this;

        fixedOptionsLayout = (LinearLayout) v.findViewById(R.id.fixedOptionsLayout);
        customOptionsLayout = (LinearLayout) v.findViewById(R.id.customOptionsLayout);

        updateButton = (Button) v.findViewById(R.id.updateButton);

        final OptionsFragment f = QuantityOptionsFragment.newInstance(1);

        getFragmentManager()
                .beginTransaction()
                .add(fixedOptionsLayout.getId(), f)
                .commit();


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return v;
    }

}
