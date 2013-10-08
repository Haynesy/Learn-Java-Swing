package com.haynesy;

import java.awt.event.ActionListener;
import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 30/09/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormEvent extends EventObject {


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;
    private int ageCat;
    private String name;
    private String occupation;
    private String employmentCategory;
    private String taxId;
    private boolean auCitizen;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation,
                     int ageCat, String employmentCategory,
                     String taxId, boolean auCitizen, String gender) {
        super(source);

        this.name = name;
        this.occupation = occupation;
        this.ageCat = ageCat;
        this.employmentCategory = employmentCategory;
        this.taxId = taxId;
        this.auCitizen = auCitizen;
        this.gender = gender;
    }



    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public int getAgeCategory() { return ageCat; }
    public void setAgeCategory(int ageCat) { this.ageCat = ageCat; }

    public String getEmploymentCategory() {
        return employmentCategory;
    }
}
