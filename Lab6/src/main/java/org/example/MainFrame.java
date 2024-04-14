package org.example;
import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends Frame {
    ConfigurationPanel configurationPanel = new ConfigurationPanel();
    ControlPanel controlPanel = new ControlPanel();

    public MainFrame(String title) {
        super(title);
        setLayout(new BorderLayout());
        add(configurationPanel, BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.NORTH);
    }
//        f.add(b1, BorderLayout.SOUTH);
//        f.add(b2, BorderLayout.SOUTH);
//        f.pack();
//        f.setVisible(true);
}
