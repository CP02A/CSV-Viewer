package com.github.cp02a.csvviewer.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    public MainView(ActionListener al){
        super("CSV-Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 165);
        setVisible(true);

        JPanel jp = new PanelView(al);
        add(jp);
    }
}
