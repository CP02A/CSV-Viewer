package com.github.cp02a.csvviewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main implements ActionListener {
    public static void main(String[] args){
        // TODO
        JFileChooser chooser = new JFileChooser();
        int rueckgabeWert = chooser.showOpenDialog(null);
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
            BufferedReader objReader = null;
            String strCurrentLine = "";
            try {
                objReader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                while ((strCurrentLine = objReader.readLine()) != null) {
                    System.out.println(strCurrentLine);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }
}
