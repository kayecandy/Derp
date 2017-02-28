package com.artise.derp.display.options.custom;

import android.view.View;
import android.widget.CheckBox;

import com.artise.derp.display.options.OptionsFragment;

/**
 * Created by Candice on 22/02/2017.
 */

public class CheckboxOptionsFragment extends OptionsFragment {



    @Override
    protected View initializeInput() {
        CheckBox c = new CheckBox(getContext());

        c.setText(label);

        optionsLayout.removeView(optionsLabelText);

        return c;
    }

    @Override
    public String getInputValue() {
        return null;
    }
}
