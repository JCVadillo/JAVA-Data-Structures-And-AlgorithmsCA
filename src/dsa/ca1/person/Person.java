package dsa.ca1.person;

import java.util.Date;

import dsa.ca1.priority.Priority;

public class Person {

    private String fName;
    private String lName;
    private String passportNo;
    private int age;
    private String id;
    //private Date dateOfApp;
    private Priority priority;
    public Person next;
    public Person prev;

    public Person() {

    }
    public Person(String fName, String lName, String passportNo, int age, /*Date dateOfApp,*/ Priority priority ) {
        this.fName = fName;
        this.lName = lName;
        this.passportNo = passportNo;
        this.age = age;
        this.id = passportNo;
        this.passportNo = passportNo;
        //this.dateOfApp = dateOfApp;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "{ | Frist name: " + this.fName +" | Last Name: " + this.lName   +" | Passport no: "+ this.passportNo  +" | Priority: "+ this.priority + " | }";
    }

    public Priority getPriority() {
        return this.priority;
    }
}
