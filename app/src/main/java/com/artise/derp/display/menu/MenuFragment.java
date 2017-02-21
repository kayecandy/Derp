package com.artise.derp.display.menu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artise.derp.R;


public class MenuFragment extends Fragment {

    private TabLayout menuTitlesTabLayout;
    private ViewPager menuItemsViewPager;

    private PagerAdapter pageAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        menuTitlesTabLayout = (TabLayout) v.findViewById(R.id.menuTitlesTabLayout);
        menuItemsViewPager = (ViewPager) v.findViewById(R.id.menuItemsViewPager);

        pageAdapter = new MenuFragmentPagerAdapter(getFragmentManager());
        menuItemsViewPager.setAdapter(pageAdapter);
        menuTitlesTabLayout.setupWithViewPager(menuItemsViewPager);

        return v;
    }


}
