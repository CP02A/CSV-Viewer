package com.github.cp02a.csvviewer.control;

import com.github.cp02a.csvviewer.model.MainModel;
import com.github.cp02a.csvviewer.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControl implements ActionListener {
    private MainModel model;
    private MainView view;

    public MainControl(){
        model = new MainModel();
        view = new MainView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Make Buttons Work!
    }
}
