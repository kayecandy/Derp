package com.artise.derp.data.datastructure.options;

import java.util.ArrayList;

/**
 * Created by Candice on 16/02/2017.
 */

public class AddonOption extends Options {

    private String key;
    private ArrayList<Options> options;

    public AddonOption(String name){
        super(name);

        this.key = name;
        this.options = new ArrayList<>();
    }

    public AddonOption(String key, String name, ArrayList<Options> options){
        super(name);

        this.key = key;
        this.options = options;
    }

    public void addOption(String name, long addedPrice){
        options.add(new Options(name, addedPrice));
    }

    @Override
    public long getAddedPrice(){
        return  0;
    }


    public AddonOption duplicate(String name){
        return new AddonOption(this.key, name, this.options);
    }

}
