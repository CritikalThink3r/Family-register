package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    private  String name;
    private  String surname;
    private  String dateOfBirth;
    LocalDate Dob;

    private static final ArrayList<Person> personlist = new ArrayList<>();

    Person (String name, String surname, String dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    Person(){}

    public void getPersonlist() {
        if(personlist.isEmpty()){
            System.out.println("Database empty");
        }else{
            System.out.println(personlist);
        }
    }

    // used in the family class
    public ArrayList<Person> arrayPerson() {
        return personlist;
    }

    // add person to arraylist at the same time add person to family array if family name
    // is not already in the array
    public void addPersonTo(Person person){
        Family family = new Family();
        family.addFamily(person.getSurname());
        personlist.add(person);
    }

   private static int calAge(LocalDate Dob){
        LocalDate currentDate = LocalDate.now();
        return Period.between(Dob, currentDate).getYears();
    }

    private int getAge() {
        Dob = LocalDate.parse(getDateOfBirth());
        return calAge(Dob);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public String toString() {
        return "name='" + name +", surname='" + surname + ", dateOfBirth=" + getDateOfBirth()
                + ", age=" +getAge() + "\n";
    }
}
