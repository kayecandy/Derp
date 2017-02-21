package com.artise.derp.display.options.types;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.display.MainActivity;
import com.artise.derp.display.options.OptionsFragment;

/**
 * Created by Candice on 21/02/2017.
 */

public class AddonOptionsFragment extends OptionsFragment {

    private int iMenuTitle;
    private int iMenuItem;
    private int iMenuItemOption;

    private AddonOption addonOption;

    public static AddonOptionsFragment newInstance(int iMenuTitle, int iMenuItem, int iMenuItemOption){
        Bundle b = new Bundle();

        b.putString("label", MainActivity.menu.getMenuItemOptionAt(iMenuTitle, iMenuItem, iMenuItemOption).getName());

        b.putInt("iMenuTitle", iMenuTitle);
        b.putInt("iMenuItem", iMenuItem);
        b.putInt("iMenuItemOption", iMenuItemOption);


        AddonOptionsFragment fragment = new AddonOptionsFragment();
        fragment.setArguments(b);

        return fragment;

    }

    @Override
    protected void readExtraBundle(Bundle bundle) {
        iMenuTitle = bundle.getInt("iMenuTitle");
        iMenuItem = bundle.getInt("iMenuItem");
        iMenuItemOption = bundle.getInt("iMenuItemOption");


        addonOption = (AddonOption) MainActivity.menu.getMenuItemOptionAt(iMenuTitle, iMenuItem, iMenuItemOption);
    }

    @Override
    protected View initializeInput() {
        TextView t = new TextView(getContext());

        t.setText("Example Addon");

        return t;
    }

    @Override
    public String getInputValue() {
        return null;
    }
}
