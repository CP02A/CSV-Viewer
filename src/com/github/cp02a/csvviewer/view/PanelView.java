package com.github.cp02a.csvviewer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelView extends JPanel {
    private JButton prev;
    private JButton nex;
    private JLabel[] info;

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

    public void updateGrid(String line) {
        String[] temp = line.split(";");
        for(int i = 0; i < info.length; i++)
            try {
                info[i].setText(temp[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                info[i].setText("");
            }
    }

    public void enableBtn(String btn) {
        if(btn.equals("prev"))
            prev.setEnabled(true);
        if(btn.equals("nex"))
            nex.setEnabled(true);
    }

    public void disableBtn(String btn) {
        if(btn.equals("prev"))
            prev.setEnabled(false);
        if(btn.equals("nex"))
            nex.setEnabled(false);
    }
}
