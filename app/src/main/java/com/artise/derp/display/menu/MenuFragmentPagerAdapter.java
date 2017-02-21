package com.artise.derp.display.menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.artise.derp.display.MainActivity;

/**
 * Created by Candice on 10/02/2017.
 */

public class MenuFragmentPagerAdapter extends FragmentPagerAdapter {
    public MenuFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return MenuItemsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MainActivity.menu.getMenuTitleCount();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return MainActivity.menu.getMenuTitleAt(position).getName();
    }
}
