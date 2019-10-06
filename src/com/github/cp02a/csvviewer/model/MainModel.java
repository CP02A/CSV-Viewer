package com.github.cp02a.csvviewer.model;

import com.github.cp02a.csvviewer.control.MainControl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is the main Model class
 *
 * @author CP02A
 * @version 04.08.2019
 */
public class MainModel {
    private String header;
    private String[] lines;
    private int currentLine;
    private MainControl mc;

    /**
     * Contructor
     * @param mc An object of the MainControl class (Controller)
     */
    public MainModel(MainControl mc){
        this.mc = mc;
        lines = new String[0];
        JFileChooser chooser = new JFileChooser();
        int rueckgabeWert = chooser.showOpenDialog(null);
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
            BufferedReader objReader = null;
            String strCurrentLine;
            try {
                String[] temp;
                objReader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                header = objReader.readLine();
                while ((strCurrentLine = objReader.readLine()) != null) {
                    temp = lines.clone();
                    lines = new String[lines.length + 1];
                    System.arraycopy(temp, 0, lines, 0, temp.length);
                    lines[lines.length-1] = strCurrentLine;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objReader != null)
                        objReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Getter method for the header string
     * @return Header string
     */
    public String getHeader(){
        return header;
    }

    /**
     * Returns the line at an index
     * @param i The index
     * @return Line string
     */
    public String getLine(int i){
        currentLine = i;
        if(i <= 0)
            mc.disableBtn("prev");
        else if(i == 1)
            mc.enableBtn("prev");
        if(i >= lines.length-1)
            mc.disableBtn("nex");
        else if(i == lines.length-2)
            mc.enableBtn("nex");
        return lines[i];
    }

    /**
     * Getter of the current index value
     * @return The index
     */
    public int getCurrentLine() {
        return currentLine;
    }
}
