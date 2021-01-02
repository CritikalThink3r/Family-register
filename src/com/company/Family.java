package com.company;

import java.util.*;

public class Family implements Comparable<Family>{

    private String surname;


    private static final TreeMap<Family,List<Person>> familyTree = new TreeMap<>();
   private static  final List<Family> arrayOfFamily = new ArrayList<>();

    Person p = new Person();

    public Family(String surname) {
        this.surname = surname;
    }
    public Family(){}

    // add the people from the person arrayList to their respective families in the Map.
    private void putPeopleToMap() {
        addObjectWhenMapIsEmpty();
        addObjectToListThatExist();

        if (familyTree.isEmpty()) {
            System.out.println("Entry empty");
        }
    }

    //loop through the list of people and add the person to the arrayList that belongs to that key
    private void addObjectToListThatExist() {

        for (Map.Entry<Family, List<Person>> entry : familyTree.entrySet()) {
            List<Person> listAllPeople = entry.getValue();
            Family family = entry.getKey();
            for (Person peopleInArray : p.arrayPerson()) {
                if (family.surname.equalsIgnoreCase(peopleInArray.getSurname()) &&
                        !listAllPeople.contains(peopleInArray)) {

                    listAllPeople.add(peopleInArray);
                }
            }
        }
    }

    // add a family to the map with a person when the map is empty from the start
    private void addObjectWhenMapIsEmpty() {
        for (Person person : p.arrayPerson()) {
            for (Family family : arrayOfFamily) {
                if (familyTree.isEmpty() || !familyTree.containsKey(family)) {
                    if (family.surname.equalsIgnoreCase(person.getSurname())) {
                        List<Person> people = new ArrayList<>();
                        people.add(person);
                        familyTree.put(family, people);
                    }
                }
            }
        }
    }

    // this is used in the person class while a person object is created create a family object from that person
    // if the surname exits in the arraylist dont add
    public void addFamily (String surname){
        for (Family family1 : arrayOfFamily){
            if(family1.surname.equalsIgnoreCase(surname)){
                System.out.println("family exists");
                return;
            }
        }
        Family family = new Family(surname);
        arrayOfFamily.add(family);
    }

    //
    public Map<Family,List<Person>> getFamilyTree() {
        putPeopleToMap();
        return familyTree;
    }

    public void getArrayOfFamily(){
        if (arrayOfFamily.isEmpty() && p.arrayPerson().isEmpty()){
            System.out.println("Database empty");
        }else{
            System.out.println(arrayOfFamily);
        }
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Family){
            Family k = (Family)obj;
            return  k.surname.equals(surname);
        }else{

            return false;
        }
    }

    @Override
    public int compareTo(Family o) {
        return o.surname.compareToIgnoreCase(surname);
    }

    @Override
    public String toString() {
        return "\n surname='" + surname;
    }
}
