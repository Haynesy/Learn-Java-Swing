package com.haynesy.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 27/09/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextPanel extends JPanel {

    private JTextArea textArea;
    public TextPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void append(String text){
        textArea.append(text);
    }
}
