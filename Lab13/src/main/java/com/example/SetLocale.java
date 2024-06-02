package com.example;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    private Locale currentLocale;

    public SetLocale() {
        this.currentLocale = Locale.getDefault();
    }

    public void execute(String languageTag) {
        Locale newLocale = Locale.forLanguageTag(languageTag);
        this.currentLocale = newLocale;
        ResourceBundle messages = ResourceBundle.getBundle("res/Messages", newLocale);
        System.out.println(messages.getString("locale.set").replace("{0}", newLocale.toString()));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
