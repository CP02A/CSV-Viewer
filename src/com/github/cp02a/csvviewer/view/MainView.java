package com.github.cp02a.csvviewer.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private PanelView jp;

    public MainView(ActionListener al){
        super("CSV-Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 165);
        setVisible(true);

        jp = new PanelView(al);
        add(jp);
    }

    public void setGrid(String header) {
        jp.setGrid(header);
    }

    public void updateGrid(String line) {
        jp.updateGrid(line);
    }

    public void enableBtn(String btn) {
        jp.enableBtn(btn);
    }

    public void disableBtn(String btn) {
        jp.disableBtn(btn);
    }
}
