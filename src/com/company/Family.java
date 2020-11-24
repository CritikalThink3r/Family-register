package com.company;

import java.util.*;

public class Family implements Comparable{

    private String surname;


    private static final TreeMap<Family,List<Person>> familyTree = new TreeMap<>();
   private static final List<Family> arrayOfFamily = new ArrayList<>();

    Person p = new Person();

    public Family(String surname) {
        this.surname = surname;
    }
    public Family(){}

    public void addToArraL(Family family){
        arrayOfFamily.add(family);
    }

    // get all teh people from the people arayList in hte person class and add them (their surname) to
    // family arrayList
    public void findPerson(){
        for(Person k: p.arrayPerson()){
            for(Family f: arrayOfFamily){
                if(f.surname.contains(k.getSurname())){
                    return;
                }
            }
                    Family fam = new Family(k.getSurname());
                    addToArraL(fam);
        }
    }

    // list familyies in the arayList
    public void getArrayOfFamily() {
        findPerson();
        if(arrayOfFamily.isEmpty()){
            System.out.println("Database empty");
        }else{
            System.out.println(arrayOfFamily);
        }
    }

    // add the people to their respective families.
    public void putPeopleToMap(){
        if(p.arrayPerson().isEmpty() & arrayOfFamily.isEmpty()){
            System.out.println("no family in registry");
            return;
        }
        findPerson();
        List<Person> per = new ArrayList<>();

            if(familyTree.isEmpty()){
                for(Person a: Person.personlist){
                    for(Family fam: arrayOfFamily){
                        if(fam.getSurname().equalsIgnoreCase(a.getSurname())){
                            Family f = fam;
                            per.add(a);
                            familyTree.put(f,per);

                            System.out.println(familyTree.entrySet());
                        }
                    }
                }
            }
    }

    public TreeMap<Family, List<Person>> getFamilyTree() {
        return familyTree;
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
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "surname='" + surname + " "+ p +" \n";
    }
}
