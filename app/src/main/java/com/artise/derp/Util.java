package com.artise.derp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Candice on 11/02/2017.
 */

public class Util {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId(){
        while(true){
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
