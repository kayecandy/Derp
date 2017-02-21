package com.artise.derp.data.parser;

import com.artise.derp.data.datastructure.Menu;
import com.artise.derp.data.datastructure.MenuTitle;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Candice on 10/02/2017.
 */

public abstract class MenuDataParser {

    protected Menu menu;


    protected void initialize(){
        menu = traverseData();
    }

    protected abstract Menu traverseData();

    public Menu getMenu(){
        return menu;
    }

}
