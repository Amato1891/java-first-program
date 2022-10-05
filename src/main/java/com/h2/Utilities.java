package com.h2;

public class Utilities {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static long getLongValue(String in) {
        long out = Long.MIN_VALUE;

        try {
            out = Long.parseLong(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(in + " cannot be converted into a 'long' value. Exiting program.");
        }
        return(out);
    }

    public static int getIntValue(String in) {
        int out = Integer.MIN_VALUE;

        try {
            out = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(in + " cannot be converted into a 'int' value. Exiting program.");
        }
        return(out);
    }

    public static float getFloatValue(String in) {
        float out = Float.MIN_VALUE;

        try {
            out = Float.parseFloat(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(in + " cannot be converted into a 'float' value. Exiting program.");
        }
        return(out);
    }

}
