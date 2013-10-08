package com.haynesy.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 27/09/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton submitButton;
    private JList ageList;
    private JComboBox employmentCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    private FormListener formListener;

    public FormPanel(String ageCat){

        nameLabel = new JLabel("Name");
        nameField = new JTextField(10);
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);

        occupationLabel = new JLabel("Occupation");
        occupationField = new JTextField(10);

        ageList = new JList();
        ageList.setPreferredSize(new Dimension(100, 60));
        ageList.setBorder(BorderFactory.createEtchedBorder());

        employmentCombo = new JComboBox();

        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax ID: ");

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = citizenCheck.isSelected();

                taxField.setEnabled(isTicked);
                taxLabel.setEnabled(isTicked);
            }
        });
        taxField.setEnabled(false);
        taxLabel.setEnabled(false);

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        ageList.setModel(ageModel);
        ageList.setSelectedIndex(0);

        DefaultComboBoxModel employmentModel = new DefaultComboBoxModel();
        employmentModel.addElement("Foo");
        employmentModel.addElement("Bar");
        employmentModel.addElement("Baz");
        employmentCombo.setModel(employmentModel);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String employmentCategory = (String) employmentCombo.getSelectedItem();
                String taxId = taxField.getText();
                boolean auCitizen = citizenCheck.isSelected();
                String gender = genderGroup.getSelection().getActionCommand();

                FormEvent event = new FormEvent(this, name, occupation, ageCat.getId(),
                        employmentCategory, taxId, auCitizen, gender);

                if (formListener != null)
                    formListener.formEventOccurred(event);
            }
        });

        maleRadio = new JRadioButton("male");
        femaleRadio = new JRadioButton("female");

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        maleRadio.setSelected(true);
        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Foo");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // ROW 1
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(nameField, gc);

        // ROW 2
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(occupationField, gc);

        // Row 3
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Age"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList, gc);

        // Row 4
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Employment"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(employmentCombo, gc);

        // Row 4
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("AU Citizen"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(citizenCheck, gc);

        // Row 4
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(taxLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(taxField, gc);

        // Row 4
        gc.gridy++;

        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(maleRadio, gc);

        // Row 4
        gc.gridy++;

        gc.weighty = 0.2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(femaleRadio, gc);

        // Row 5
        gc.gridy++;

        gc.weighty = 1.0;

        gc.gridx = 1;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(submitButton, gc);
    }

    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }
}

class AgeCategory {
    private final int id;
    private final String text;

    public AgeCategory(int id, String text){
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

    public String getText() {
        return text;
    }

    public int getId(){
        return id;
    }
}
