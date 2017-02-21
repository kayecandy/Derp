package com.artise.derp.display.options.types;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.artise.derp.display.options.OptionsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuantityOptionsFragment extends OptionsFragment {

    private int quantity = 1;


    public static QuantityOptionsFragment newInstance(int quantity){
        Bundle b = new Bundle();
        b.putString("label", "Quantity");
        b.putInt("quantity", quantity);

        QuantityOptionsFragment fragment = new QuantityOptionsFragment();
        fragment.setArguments(b);


        return fragment;
    }


    @Override
    protected void readExtraBundle(Bundle bundle) {
        quantity = bundle.getInt("quantity");
    }

    @Override
    protected View initializeInput() {
        EditText input = new EditText(getContext());

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setText(quantity+"");

        return input;
    }

    @Override
    public String getInputValue() {
        return ((EditText)super.input).getText().toString();
    }
}
