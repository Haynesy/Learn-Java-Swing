package com.haynesy.gui;

import com.haynesy.model.EmploymentCategory;
import com.haynesy.model.Gender;
import com.haynesy.model.Person;

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

    Person person;

    public String getGender() {
        return person.getGender().toString();
    }

    public void setGender(Gender gender) {
        person.setGender(gender);
    }

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation,
                     com.haynesy.model.AgeCategory ageCat, EmploymentCategory employmentCategory,
                     String taxId, boolean auCitizen, Gender gender) {
        super(source);

        person = new Person(gender, ageCat, name, occupation, employmentCategory,
                taxId, auCitizen);

    }

    public String getName() {
        return person.getName();
    }

    public String getOccupation() {
        return person.getOccupation();
    }

    public int getAgeCategory() {
        return person.getAgeCat().ordinal();
    }

    public String getEmploymentCategory() {
        return person.getEmploymentCategory().toString();
    }
}
