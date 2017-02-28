package com.artise.derp.data.parser;

import android.util.Log;

import com.artise.derp.data.datastructure.Menu;
import com.artise.derp.data.datastructure.MenuItem;
import com.artise.derp.data.datastructure.MenuTitle;
import com.artise.derp.data.datastructure.options.AddonOption;
import com.artise.derp.data.datastructure.options.CheckboxOption;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Candice on 10/02/2017.
 */

public class SampleJSONMenuDataParser extends MenuDataParser {

    private JSONObject menu;

    public SampleJSONMenuDataParser(InputStream jsonInput){
        super();

        try{
            menu = new JSONObject(IOUtils.toString(jsonInput));

            initialize();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected Menu traverseData() {
        Menu m = new Menu();

        try {
//            Menu Options
            JSONArray jsonOptions = menu.getJSONArray("menuSettings");
            for(int i=0; i < jsonOptions.length(); i++){
                JSONObject jsonAddon = jsonOptions.optJSONObject(i);

                AddonOption addon = new AddonOption(jsonAddon.getString("addonKey"));

                JSONArray jsonAddonItems = jsonAddon.getJSONArray("addonItems");

                for(int j=0; j < jsonAddonItems.length(); j++){
                    JSONObject jsonAddonItem = jsonAddonItems.getJSONObject(j);

                    String name = jsonAddonItem.getString("name");
                    long addedPrice = 0;

                    if(jsonAddonItem.has("addedPrice"))
                        addedPrice = jsonAddonItem.getLong("addedPrice");

                    addon.addOption(name, addedPrice);
                }

                m.addAddons(jsonAddon.getString("addonKey"), addon);
            }



//            Menu Titles
            JSONArray jsonMenu = menu.getJSONArray("menu");

            for(int i=0; i < jsonMenu.length(); i++){
                JSONObject jsonMenuTitle = jsonMenu.getJSONObject(i);

                MenuTitle menuTitle = new MenuTitle(jsonMenuTitle.getString("menuTitle"));

                JSONArray jsonMenuItems = jsonMenuTitle.getJSONArray("menuItems");


//                Menu Items
                for(int j=0; j < jsonMenuItems.length(); j++){
                    JSONObject jsonMenuItem = jsonMenuItems.getJSONObject(j);

                    MenuItem menuItem = new MenuItem(jsonMenuItem.getString("name"), jsonMenuItem.getLong("price"));

//                    Menu Addons

                    if(jsonMenuItem.has("attributes")){
                        JSONArray jsonMenuItemAddons = jsonMenuItem.getJSONArray("attributes");

                        for(int k=0; k < jsonMenuItemAddons.length(); k++){
                            JSONObject jsonMenuItemAddon = jsonMenuItemAddons.getJSONObject(k);

                            String type = jsonMenuItemAddon.getString("type");

                            if(type.equals("checkbox")){
                                long addedPrice = 0;
                                if(jsonMenuItemAddon.has("addedPrice"))
                                    addedPrice = jsonMenuItemAddon.getLong("addedPrice");

                                menuItem.addOptions(new CheckboxOption(jsonMenuItemAddon.getString("name"), addedPrice));

                            }else if(type.equals("addon")){

                                menuItem.addOptions(m.getAddonOption(jsonMenuItemAddon.getString("addonKey")).duplicate(jsonMenuItemAddon.getString("name")));
                            }

                        }
                    }

                    menuTitle.add(menuItem);


                }

                m.addMenu(menuTitle);

            }

            return m;



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
