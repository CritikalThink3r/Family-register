package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    private  String name;
    private String surname;
    private  String dateOfBirth;
    private static int age;
    LocalDate Dob;

    static ArrayList<Person> personlist = new ArrayList<>();

    Person (String name, String surname, String dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    Person(){}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    static int calAge(LocalDate Dob){
        LocalDate currentDate = LocalDate.now();
        age = Period.between(Dob,currentDate).getYears();
        return age;
    }

    public void getPersonlist() {
        if(personlist.isEmpty()){
            System.out.println("Database empty");
            return;
        }else{
            System.out.println(personlist);
        }
    }

    public int getAge() {
        Dob = LocalDate.parse(dateOfBirth);
        return calAge(Dob);
    }

    public ArrayList<Person> arrayPerson() {
    return personlist;
    }

    public void addPersonTo(Person person){
       personlist.add(person);
    }

    @Override
    public String toString() {
        return "name='" + name +", surname='" + surname + ", dateOfBirth=" + dateOfBirth + ", age=" + getAge();
    }
}
