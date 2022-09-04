package com.maftei.licenta;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String args[]) {
        Date dt = new Date();
        DateFormat dateFormat;
        // Date Format MEDIUM constant
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH);
        System.out.println("Locale FRENCH = " + dateFormat.format(dt));
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("RO"));
        System.out.println("Locale GERMANY = " + dateFormat.format(dt));
    }
}
