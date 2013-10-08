package com.haynesy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 8/10/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    private ArrayList<Person> people;

    public Database(){
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }

}
