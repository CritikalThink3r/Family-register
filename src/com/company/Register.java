package com.company;

import java.util.*;

public class Register {

    Scanner scan = new Scanner(System.in);
    Person p = new Person();
    Family family = new Family();

    private void options(){
        System.out.println("Choose of the above");
        System.out.println("  ");
        System.out.println("Register yourself by typing - \"Register\"");
        System.out.println("List people in the database by typing -  \"List people\"");
        System.out.println("List families by typing - \"Families\" ");
        System.out.println("List my family and people belonging to the family by typing - \"List families\"");
        System.out.println("typ \"Exit\" to exit");
    }

    public void loopOptions(){
        options();
        boolean done = false;

        while(!done){
            System.out.print("choose one of the above: ");
            String entered = scan.nextLine();
            entered = entered.trim();

        switch (entered){

                case"List p":
                    listPeople();
                    break;

                case"Reg":
                    addPerson();
                    break;

                case"List f":
                    familyRegistry();
                    break;

                case"List indi":
                    listFamily();
                    break;

                case"Exit":
                    done = true;
                    break;

                default:
                    System.out.println(" Invalid input, try again ");
            }
    }
    }

    public void ifEmptyString(String string){

        while(string.trim().isEmpty()){
            System.out.println("cannot be empty!");
            string = scan.nextLine();
        }
    }

    // adding a person to an arrayList in the person class
    private void addPerson(){


        System.out.println("Enter your name");
        String name = scan.nextLine();
        ifEmptyString(name);

        System.out.println("Enter your surname");
        String surname = scan.nextLine();
        ifEmptyString(surname);

        System.out.println("Enter your date of birth i the format, YYYY-mm-dd");
        String dateOfBirth = scan.nextLine();

        Person person = new Person(name,surname,dateOfBirth);
        p.addPersonTo(person);
        System.out.println(person.getName() + " you have been added to the register");
    }

    private void listPeople(){
        p.getPersonlist();
    }

    public void listFamily(){
        family.getArrayOfFamily();
    }

    public void familyRegistry(){
        family.putPeopleToMap();
    }

}
