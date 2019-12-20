package dsa.ca1.person;

/*
* This is our person class
* Everything related to what a person is
* and has as an attribute will be here
* */
public class Person {

    /*
    * Private attributes for encapsulation
    * and good practice
    * */
    private String fName;
    private String lName;
    private String passportNo;
    private int age;
    private String id;
    private Priority priority;
    /*
    * Attributes next and prev will help us to
    * keep track of who is next and before in the queue
    * due it is needed in order t have a
    * Doubly Linked list structure, where every
    * object has to have a reference of its previous
    * and its next
    * */
    private Person next;
    private Person prev;

    /*Default constructor
    * good practise to have it
    * and it will help us to create a person
    * when we do not want to pass any parameters
    * */
    public Person() {

    }
    /*
    * Constructor with parameters or arguments so
    * when we want to add a person to the queue
    * we need to provide the following information in
    * order to "create" the person in the system that
    * will be add it to the queue
    * */
    public Person(String fName, String lName, String passportNo, int age, Priority priority ) {
        this.fName = fName;
        this.lName = lName;
        this.passportNo = passportNo;
        this.age = age;
        /*
        * As requirement is needed an ID
        * and it has to be unique. In real world
        * passports numbers are unique so the ID
        * of the person will be the same as passport number
        * */
        this.id = passportNo;
        this.priority = priority;
    }
    /*
    * toString method that will be used to display the queue
    * What it does is to help to print the actual values
    * of the attributes of a person and NOT the location in
    * memory. Then if we want to see this values user just
    * needs to print(person)
    * */
    @Override
    public String toString() {
        return "{ | Frist name: " + this.fName +" | Last Name: " + this.lName   +" | Passport no: "+ this.passportNo  +" | Priority: "+ this.priority + " | }";
    }
    /*
    *Getters and setters to access
    * to the attributes of the person.
    * Encapsulation and good practice
    * */
    public Priority getPriority() {
        return this.priority;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getPrev() {
        return prev;
    }

    public void setPrev(Person prev) {
        this.prev = prev;
    }
}
