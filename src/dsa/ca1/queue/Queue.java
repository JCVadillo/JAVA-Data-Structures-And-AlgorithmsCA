package dsa.ca1.queue;

import java.util.Date;

import dsa.ca1.person.Person;
import dsa.ca1.priority.Priority;

public class Queue {
    public Person first;
    public Person last;
    public Person highLast;
    public Person midLast;
    public int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        }else {
            return false;
        }
    }

    public void addPerson(String fName, String lName, String passportNo, int age, Priority priority) {
        Person newPerson = new Person (fName, lName, passportNo, age, priority);

        if (isEmpty()){
            this.last = newPerson;
            this.first = newPerson;
            this.size++;
        } else {
            switch (priority){
                case LOW: addLow(newPerson);
                break;
                case MEDIUM: addMed(newPerson);
            }
        }
    }

    public void addLow(Person newPerson){
        this.last.next = newPerson;
        newPerson.prev = this.last;
        this.last = newPerson;
        newPerson.next = null;
        this.size++;
    }

    public void addMed(Person newPerson){
        Person current = this.first;
        if(current.getPriority().equals(Priority.LOW)){
            current = this.first;
            newPerson.next = current;
            current.prev = newPerson;
            this.first = newPerson;
        }else if (current.getPriority().equals(Priority.MEDIUM) && current.next == null){
            
        }
    }



    public void displayQueue() {
        System.out.println("High------>low");
        Person current  = this.first;
        while(current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

}
