package com.artise.derp.display;

import java.text.DateFormat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.artise.derp.R;
import com.artise.derp.data.datastructure.Menu;
import com.artise.derp.data.parser.MenuDataParser;
import com.artise.derp.data.parser.SampleJSONMenuDataParser;
import com.artise.derp.display.cart.CartFragment;
import com.artise.derp.display.cart.CartItemFragment;
import com.artise.derp.display.options.OptionsContainerFragment;
import com.artise.derp.display.options.OptionsFragment;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static Menu menu;
    public static CartFragment cart;
    public static OptionsContainerFragment options;


    public static void addCartItem(int iMenuTitle, int iMenuItem){
        cart.addCartItem(iMenuTitle, iMenuItem);
    }

    private void setCurrentDateTime(){
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        TextView currentDateTime = (TextView) findViewById(R.id.currentDateTime);
        currentDateTime.setText(currentDateTimeString);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MenuDataParser menuDataParser = new SampleJSONMenuDataParser(getResources().openRawResource(R.raw.menu_json));


        menu = menuDataParser.getMenu();

        setContentView(R.layout.activity_main);


        setCurrentDateTime();

    }

}
