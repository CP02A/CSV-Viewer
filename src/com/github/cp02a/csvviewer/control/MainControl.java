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
        view.setGrid(model.getHeader(), model.getLine(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "nex":
                view.updateGrid(model.getLine(model.getCurrentLine()+1));
                break;
            case "prev":
                view.updateGrid(model.getLine(model.getCurrentLine()-1));
                break;
        }
    }
}
