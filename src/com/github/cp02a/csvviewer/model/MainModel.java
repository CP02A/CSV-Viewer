package com.github.cp02a.csvviewer.model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainModel {
    private String[] lines;

    public MainModel(){
        lines = new String[0];
        JFileChooser chooser = new JFileChooser();
        int rueckgabeWert = chooser.showOpenDialog(null);
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
            BufferedReader objReader = null;
            String strCurrentLine = "";
            try {
                String[] temp;
                objReader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                while ((strCurrentLine = objReader.readLine()) != null) {
                    temp = lines.clone();
                    lines = new String[lines.length + 1];
                    for(int i = 0; i < temp.length; i++)
                        lines[i] = temp[i];
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
}
