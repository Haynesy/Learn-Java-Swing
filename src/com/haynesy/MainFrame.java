package com.haynesy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 26/09/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public MainFrame(){
        super("App");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel(null);

        setJMenuBar(createMenuBar());

        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.append(text);
            }
        });
        formPanel.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent e){
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String employment = e.getEmploymentCategory();
                String gender = e.getGender();

                textPanel.append(name +": "+ occupation +" [ "+ employment + " ] ( "+ ageCat + ", "+ gender +" )\n");
            }
        });


        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

        JMenuItem exportData = new JMenuItem("Export Data....");
        JMenuItem importData = new JMenuItem("Import Data....");

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Are you sure?", "Confirm xit",
                        JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION)
                    System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuItem.isSelected());
            }
        });

        // Use JRadioButton

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.add(exit);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        return menuBar;
    }
}
