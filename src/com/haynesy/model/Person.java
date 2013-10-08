package com.haynesy.model;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 8/10/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    private static int count = 0;

    private int id;
    private Gender gender;
    private AgeCategory ageCat;
    private String name;
    private String occupation;
    private EmploymentCategory employmentCategory;
    private String taxId;
    private boolean auCitizen;

    public Person(Gender gender, AgeCategory ageCat, String name,
                  String occupation, EmploymentCategory employmentCategory,
                  String taxId, boolean auCitizen) {

        this.id = count++;
        this.gender = gender;
        this.ageCat = ageCat;
        this.name = name;
        this.occupation = occupation;
        this.employmentCategory = employmentCategory;
        this.taxId = taxId;
        this.auCitizen = auCitizen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AgeCategory getAgeCat() {
        return ageCat;
    }

    public void setAgeCat(AgeCategory ageCat) {
        this.ageCat = ageCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public EmploymentCategory getEmploymentCategory() {
        return employmentCategory;
    }

    public void setEmploymentCategory(EmploymentCategory employmentCategory) {
        this.employmentCategory = employmentCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isAuCitizen() {
        return auCitizen;
    }

    public void setAuCitizen(boolean auCitizen) {
        this.auCitizen = auCitizen;
    }
}
