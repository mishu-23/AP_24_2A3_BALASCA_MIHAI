package com.example;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public void execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("res/Messages", locale);
        System.out.println(messages.getString("locales"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale loc : locales) {
            System.out.println(loc.getDisplayName(locale));
        }
    }
}
