package com.company;

import java.util.*;

public class Family implements Comparable<Family>{

    private String surname;


    private static  TreeMap<Family,List<Person>> familyTree = new TreeMap<>();
   private static  List<Family> arrayOfFamily = new ArrayList<>();

    Person p = new Person();

    public Family(String surname) {
        this.surname = surname;
    }
    public Family(){}



    /*Iterator iter = (Iterator) familyTree.keySet().iterator();

        while(iter.hasNext()) {

        Map.Entry entry = (Map.Entry) iter.next();
        System.out.println(entry.getKey() + " - " + entry.getValue());

    }*/
    // add the people to their respective families.
    private void putPeopleToMap() {
        if (familyTree.isEmpty()) {
            for (Person person : p.arrayPerson()) {
                for (Family family : arrayOfFamily) {
                    if (family.getSurname().equalsIgnoreCase(person.getSurname())) {
                        List<Person> people = new ArrayList<>();
                        people.add(person);
                        familyTree.put(family, people);
                    }
                }
            }
        } else {
            for (Map.Entry<Family, List<Person>> map : familyTree.entrySet()) {
                for (Person person : p.arrayPerson()) {
                    for (Family family : arrayOfFamily) {
                        List<Person> people = map.getValue();
                        if (familyTree.containsKey(family)) {
                            if (family.getSurname().equalsIgnoreCase(person.getSurname())) {
                                people.add(person);
                                familyTree.put(family, people);
                            }
                        } else {
                            if (!familyTree.containsKey(family)) {

                                if (family.getSurname().equalsIgnoreCase(person.getSurname())) {
                                    people.add(person);
                                    familyTree.put(family, people);


                                }

                            }
                        }

                    }
                }
            }
        }
        if (familyTree.isEmpty()) {
            System.out.println("Entry empty");
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
