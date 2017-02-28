package com.artise.derp.display.options.custom;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.display.options.OptionsFragment;

import com.artise.derp.data.datastructure.options.Options;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Candice on 21/02/2017.
 */

public class AddonOptionsFragment extends OptionsFragment {


    @Override
    protected View initializeInput() {
        Spinner s = new Spinner(getContext(), Spinner.MODE_DROPDOWN);

        List<String> addons = new ArrayList<>();

        ArrayList<Options>  addonList = ((AddonOption) option).getOptions();

        for(int i=0; i < addonList.size(); i++){
            addons.add(addonList.get(i).getName());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, addons);

        s.setAdapter(adapter);

        return s;
    }

    @Override
    public String getInputValue() {
        return null;
    }
}
