package app;

import com.example.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SetLocale setLocale = new SetLocale();
        Locale currentLocale = setLocale.getCurrentLocale();

        while (true) {
            ResourceBundle messages = ResourceBundle.getBundle("res/Messages", currentLocale);
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("locales")) {
                new DisplayLocales().execute(currentLocale);
            } else if (command.startsWith("set")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    setLocale.execute(parts[1]);
                    currentLocale = setLocale.getCurrentLocale();
                } else {
                    System.out.println(messages.getString("invalid"));
                }
            } else if (command.startsWith("info")) {
                new Info().execute(currentLocale);
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}
