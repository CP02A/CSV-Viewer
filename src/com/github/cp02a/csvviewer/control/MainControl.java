package com.github.cp02a.csvviewer.control;

import com.github.cp02a.csvviewer.model.MainModel;
import com.github.cp02a.csvviewer.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the main Control class
 *
 * @author CP02A
 * @version 04.08.2019
 */
public class MainControl implements ActionListener {
    private MainModel model;
    private MainView view;

    /**
     * Constructor
     */
    public MainControl(){
        model = new MainModel(this);
        view = new MainView(this);
        view.setGrid(model.getHeader());
        view.updateGrid(model.getLine(0));
    }

    /**
     * Enables the button described in the parameter
     * @param btn String describing the button ("prev" and "nex")
     */
    public void enableBtn(String btn){
        view.enableBtn(btn);
    }

    /**
     * Disables the button described in the parameter
     * @param btn String describing the button ("prev" and "nex")
     */
    public void disableBtn(String btn){
        view.disableBtn(btn);
    }

    /**
     * ActionEvent listener that catches the button clicks from the JPanel (PanelView)
     * @param e The ActionEvent object
     */
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
