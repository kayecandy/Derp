package com.artise.derp.data.datastructure;

import com.artise.derp.data.datastructure.options.Options;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Candice on 16/02/2017.
 */

public class MenuItem {

    private String name;
    private long price;
    private ArrayList<Options> optionsList;

    public MenuItem(String name, long price){
        this.name = name;
        this.price = price;
        this.optionsList = new ArrayList<>();

    }

    public MenuItem(String name, long price, ArrayList<Options> optionsList){
        this.name = name;
        this.price = price;
        this.optionsList = optionsList;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public ArrayList<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(ArrayList<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public void addOptions(Options options){
        this.optionsList.add(options);
    }




}
