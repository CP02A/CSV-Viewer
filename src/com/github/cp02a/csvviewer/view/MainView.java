package com.github.cp02a.csvviewer.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This is the main View/JFrame class
 *
 * @author CP02A
 * @version 04.08.2019
 */
public class MainView extends JFrame {
    private PanelView jp;

    /**
     * Constructor
     * @param al An object of the ActionListener class (Controller)
     */
    public MainView(ActionListener al){
        super("CSV-Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 600, 250);
        setVisible(true);

        jp = new PanelView(al);
        add(jp);
    }

    /**
     * Method passed on to PanelView class
     * @param header header string
     */
    public void setGrid(String header) {
        jp.setGrid(header);
    }

    /**
     * Method passed on to PanelView class
     * @param line line string
     */
    public void updateGrid(String line) {
        jp.updateGrid(line);
    }

    /**
     * Method passed on to PanelView class
     * @param btn Button string
     */
    public void enableBtn(String btn) {
        jp.enableBtn(btn);
    }

    /**
     * Method passed on to PanelView class
     * @param btn Button string
     */
    public void disableBtn(String btn) {
        jp.disableBtn(btn);
    }
}
