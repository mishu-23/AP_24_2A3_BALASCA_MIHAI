package com.example;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public void execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("res/Messages", locale);
        System.out.println(messages.getString("info").replace("{0}", locale.toString()));

        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);

        System.out.println("Country: " + locale.getDisplayCountry(locale) + " (" + locale.getDisplayCountry() + ")");
        System.out.println("Language: " + locale.getDisplayLanguage(locale) + " (" + locale.getDisplayLanguage() + ")");
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        System.out.println("Week Days: " + String.join(", ", dfs.getWeekdays()));
        System.out.println("Months: " + String.join(", ", dfs.getMonths()));
        System.out.println("Today: " + df.format(System.currentTimeMillis()));
    }
}
