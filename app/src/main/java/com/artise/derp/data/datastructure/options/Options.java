package com.artise.derp.data.datastructure.options;

/**
 * Created by Candice on 16/02/2017.
 */

public class Options {

    private String name;
    private long addedPrice;

    public Options(String name){
        this.name = name;
        addedPrice = 0;
    }

    public Options(String name, long addedPrice){
        this.name = name;
        this.addedPrice = addedPrice;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(long addedPrice) {
        this.addedPrice = addedPrice;
    }



}
