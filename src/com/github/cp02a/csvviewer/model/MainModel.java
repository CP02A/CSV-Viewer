package com.github.cp02a.csvviewer.model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainModel {
    private String header;
    private String[] lines;
    private int currentLine;

    public MainModel(){
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

    public String getHeader(){
        return header;
    }

    public String getLine(int i){
        currentLine = i;
        return lines[i];
    }

    public int getCurrentLine() {
        return currentLine;
    }
}
