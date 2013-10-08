package com.haynesy.controller;

import com.haynesy.gui.FormEvent;
import com.haynesy.model.*;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 8/10/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    Database db = new Database();

    public void addPerson(FormEvent e){
        String name = e.getName();
        String occupation = e.getOccupation();
        AgeCategory ageCat = e.getAgeCategory();
        EmploymentCategory employment = EmploymentCategory.valueOf(e.getEmploymentCategory());
        Gender gender = Gender.valueOf(e.getGender());
        boolean isAu = e.getAuCitizen();
        String taxId = e.getTaxId();

        Person person = new Person(gender, ageCat, name, occupation, employment, taxId, isAu);
        db.addPerson(person);
    }
}
