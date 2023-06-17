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

    public static long stringToLong(String str) {
        try {
            return Long.parseLong(str);
        }
        catch(Exception e) {
            return -1L;
        }
    }
}
