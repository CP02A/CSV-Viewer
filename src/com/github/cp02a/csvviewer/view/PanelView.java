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
        JPanel jp = new JPanel(new GridLayout(2, header.split(";").length, 0, 0));
        for (String str : header.split(";")) {
            JLabel jl = new JLabel(str);
            jl.setHorizontalAlignment(SwingConstants.CENTER);
            jp.add(jl);
        }
        info = new JLabel[header.split(";").length];
        for(int i = 0; i < info.length; i++){
            JLabel jl = new JLabel();
            jl.setHorizontalAlignment(SwingConstants.CENTER);
            jp.add(jl);
            info[i] = jl;
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
