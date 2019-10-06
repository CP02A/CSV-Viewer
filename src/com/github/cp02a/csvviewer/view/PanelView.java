package com.github.cp02a.csvviewer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the main JPanel class
 *
 * @author CP02A
 * @version 04.08.2019
 */
public class PanelView extends JPanel {
    private JButton prev;
    private JButton nex;
    private JLabel[] info;

    /**
     * Constructor
     * @param al An object of the ActionListener class (Controller)
     */
    public PanelView(ActionListener al){
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        prev = new JButton("Prev");
        nex = new JButton("Next");
        prev.setEnabled(false);
        prev.setActionCommand("prev");
        nex.setActionCommand("nex");
        prev.addActionListener(al);
        nex.addActionListener(al);
        this.add(prev, BorderLayout.LINE_START);
        this.add(nex, BorderLayout.LINE_END);
    }

    /**
     * This method creates the grid and sets the header
     * @param header The header string
     */
    public void setGrid(String header) {
        String[] splitted = header.split(";");
        JPanel jp = new JPanel(new GridLayout(splitted.length, 2, 0, 0));
        info = new JLabel[splitted.length];
        for(int i = 0; i < splitted.length*2; i++){
            if(i%2 == 0) {
                JLabel jl = new JLabel(splitted[i/2] + ": ");
                jl.setHorizontalAlignment(SwingConstants.RIGHT);
                jp.add(jl);
            } else {
                JLabel jl = new JLabel();
                jl.setHorizontalAlignment(SwingConstants.LEFT);
                jp.add(jl);
                info[i/2] = jl;
            }
        }
        this.add(jp, BorderLayout.CENTER);
    }

    /**
     * Updated the grid with the values in the parameter line.
     * If the values do not fit in the grid set by setGrid(), the values will either be thrown out or nothing will be shown at that place
     * @param line The line containing the values that is to are shown
     */
    public void updateGrid(String line) {
        String[] temp = line.split(";");
        for(int i = 0; i < info.length; i++)
            try {
                info[i].setText(temp[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                info[i].setText("");
            }
    }

    /**
     * Enables the button described in the parameter
     * @param btn String describing the button ("prev" and "nex")
     */
    public void enableBtn(String btn) {
        if(btn.equals("prev"))
            prev.setEnabled(true);
        if(btn.equals("nex"))
            nex.setEnabled(true);
    }

    /**
     * Disables the button described in the parameter
     * @param btn String describing the button ("prev" and "nex")
     */
    public void disableBtn(String btn) {
        if(btn.equals("prev"))
            prev.setEnabled(false);
        if(btn.equals("nex"))
            nex.setEnabled(false);
    }
}
