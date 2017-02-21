package com.artise.derp.data.datastructure;

import android.util.Log;

import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.data.datastructure.options.Options;
import com.artise.derp.data.parser.MenuDataParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Candice on 16/02/2017.
 */

public class Menu {

    private ArrayList<MenuTitle> menuTitles;
    private MenuTitle all;

    private HashMap<String, AddonOption> addons;

    public Menu(){
        menuTitles = new ArrayList<>();
        all = new MenuTitle("All");

        addons = new HashMap<>();


    }

    public void addAddons(String key, AddonOption option){
        this.addons.put(key, option);
    }

    public AddonOption getAddonOption(String key){
        return addons.get(key);
    }

    public void addMenu(MenuTitle menuTitle){
        this.menuTitles.add(menuTitle);
        all.addAll(menuTitle);
    }

    public int getMenuTitleCount(){
        return menuTitles.size() + 1;
    }

    public int getTotalItems(){
        return all.size();
    }

    public ArrayList<String> getMenuTitles(){
        ArrayList<String> titles = new ArrayList<>();

        for(int i=0; i<menuTitles.size(); i++){
            titles.add(menuTitles.get(i).getName());
        }

        return titles;
    }


    public MenuTitle getMenuTitleAt(int index){
        if(index == menuTitles.size())
            return all;

        return menuTitles.get(index);
    }

    public MenuItem getMenuItemAt(int iMenuTitle, int iMenuItem){
        return getMenuTitleAt(iMenuTitle).get(iMenuItem);
    }

    public Options getMenuItemOptionAt(int iMenuTitle, int iMenuItem, int iMenuItemOption){
        return getMenuItemAt(iMenuTitle, iMenuItem).getOptionsList().get(iMenuItemOption);
    }



}
