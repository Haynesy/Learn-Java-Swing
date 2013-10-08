package com.haynesy.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 27/09/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToolBar extends JPanel implements ActionListener{

    private JButton testButton;
    private JButton quitButton;
    private StringListener textListener;

    public ToolBar(){
        testButton = new JButton("Foo");
        quitButton = new JButton("Quit");

        testButton.addActionListener(this);
        quitButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(testButton);
        add(quitButton);
    }

    public void setStringListener(StringListener listener){
        textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton clicked = (JButton) e.getSource();

        if(textListener == null)
            return;

        if(clicked == testButton)
            textListener.textEmitted("Test\n");

        if(clicked == quitButton)
            textListener.textEmitted("Quit\n");

    }
}
