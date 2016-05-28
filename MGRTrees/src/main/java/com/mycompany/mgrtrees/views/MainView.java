/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mgrtrees.views;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import static javax.swing.SwingConstants.HORIZONTAL;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kosa1010
 */
public class MainView extends javax.swing.JFrame {

    private final String TITLE = "MGRTrees";
    private final JMenuBar MENUBAR = new JMenuBar();
    private final JMenu JMENU_FILE = new JMenu("File");
    private final JMenuItem JMF_FCOPEN = new JMenuItem("Open and load data");
    private final JMenuItem JMF_FCSAVE = new JMenuItem("Save your data");
    private final JMenuItem JMF_CLOSE = new JMenuItem("EXIT");
    private final JSeparator JSEPAR = new JSeparator(HORIZONTAL);
    


  
        //widok okna głównego
    public void showMainView() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setTitle(TITLE);
        JSEPAR.contains(5, 50);
        JSEPAR.setVisible(true);
        add(JSEPAR);
        JMENU_FILE.add(JMF_FCOPEN);
        JMENU_FILE.add(JMF_FCSAVE);
        JMF_FCSAVE.setEnabled(false);
        JMENU_FILE.add(JMF_CLOSE);
        MENUBAR.add(JMENU_FILE);
        MENUBAR.setVisible(true);
        setJMenuBar(MENUBAR);
        setVisible(true);
    }

    //przypisanie akcji komponentom
    public void setActions() {
        JMF_FCOPEN.addActionListener((ActionEvent e) -> {
            fchOpenFile("Open file with data", "csv", "txt");
            JMF_FCSAVE.setEnabled(true);
        });
        JMF_FCSAVE.addActionListener((ActionEvent e) -> {
            try {
                fchSaveFile("Open file with data", "csv", "txt");
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        JMF_CLOSE.addActionListener((ActionEvent e) -> {
            System.exit(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        });
    }

    //file chooser otwieranie
    private String fchOpenFile(String title, String... extensions) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(title, extensions);
        jfc.setFileFilter(filter);
        jfc.showOpenDialog(jfc);
        return jfc.getSelectedFile().getPath();
    }

    //file chooser zapisywanie
    private void fchSaveFile(String title, String... extensions) throws IOException {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(title, extensions);
        jfc.setFileFilter(filter);
        jfc.showSaveDialog(jfc);
        try (FileWriter fw = new FileWriter(jfc.getSelectedFile() + ".txt")) {
            fw.write("zawartość pliku jako String");
        }
    }
}
