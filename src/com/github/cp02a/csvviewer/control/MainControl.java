package com.github.cp02a.csvviewer.control;

import com.github.cp02a.csvviewer.model.MainModel;
import com.github.cp02a.csvviewer.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControl implements ActionListener {
    private MainModel model;
    private MainView view;

    public MainControl(){
        model = new MainModel(this);
        view = new MainView(this);
        view.setGrid(model.getHeader());
        view.updateGrid(model.getLine(0));
    }

    public void enable(String btn){
        //TODO
    }
    
    public void disable(String btn){
        //TODO
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
