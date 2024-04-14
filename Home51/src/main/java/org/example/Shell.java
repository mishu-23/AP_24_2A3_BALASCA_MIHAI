package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Shell {
    private Map<String, Command> commands;
    public Shell() {
        commands = new HashMap<>();
        commands.put("view", new CommandView());
        commands.put("report", new CommandReport());
        commands.put("export", new CommandExport());
    }
    public void run() {
        Scanner sin = new Scanner(System.in);
        boolean exit = false;
        while(exit == false) {
            System.out.print("> ");
            String line = sin.nextLine();
            String[] words = line.split(" ");

            if(words.length == 0) {
                continue;
            }
            String mainCommand = words[0];
            if(mainCommand.equals("exit")) {
                exit = true;
                continue;
            }
            Command command = commands.get(mainCommand);
            if(command == null) {
                System.out.println("Invalid command: " + mainCommand);
            } else {
                System.out.println(command.execute());
            }
        }

    }

    public static void main(String[] args) {
        new Shell().run();
    }
}
