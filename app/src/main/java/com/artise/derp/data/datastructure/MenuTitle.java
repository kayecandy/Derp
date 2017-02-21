package com.artise.derp.data.datastructure;


import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Candice on 16/02/2017.
 */

public class MenuTitle extends ArrayList<MenuItem> {

    private String name;

    public MenuTitle(String name){
        this.name = name;

    }

    public String getName(){
        return name;
    }
}
