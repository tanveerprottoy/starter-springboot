package com.github.tanveerprottoy.starterspringboot.utils;

public class AdapterUtils {

    public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        }
        catch(Exception e) {
            return -1;
        }
    }
}
