package dsa.ca1.queue;

import dsa.ca1.person.Person;
import dsa.ca1.person.Priority;

/*
* This class is where Queue will rely on
* which as it is mentioned in the Person class where the
* attributes next and prev are, it has a Doubly Linked List
* structure. Person object will be added or removed from this queue
* and all regarding to behaviours and attributes of a Queue will be here
* */
public class Queue {
    /*Attributes of the Queue*/
    private Person first;// Reference to the Person at the beginning of the queue
    private Person last;// Reference to the Person at the end of the queue
    private int size; // Number of Person objects stored in the queue

    //Constructor of our Queue
    public Queue() {
        /*
        * Every single time the user wants to create a new queue
        * it has to have a first and las position and a size
        * is te queue has no person objects yet, first and las will be
        * null and size 0
        * */
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /*
    * Getters and setters for encapsulation
    * and good practice
    * */
    public Person getFirst() {
        return first;
    }

    public void setFirst(Person first) {
        this.first = first;
    }

    public Person getLast() {
        return last;
    }

    public void setLast(Person last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /*
    * Users might want to be able to
    * see the size of the queue son in this method
    * a print statement is added to be able to see
    * what is the size of our queue
    * which is the number of person objects in it
    * if the queue is empty it will print 0, if there are
    * 3 person objects it will print 3 and so on.
    * */
    public int getSize() {
        System.out.println("\n People in the queue: " + this.size + "\n");
        return size;
    }
    /*
    * This method will return either true or false
    * is the queue is empty or not
    * and this will help user as a starter point
    * of organizing the person object
    * */
    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        }else {
            return false;
        }
    }
    /*
    * the addPerson method is the method that will be responsible of adding person objects to
    * the queue. It receives as parameters the first and last name of the person, passport number, age and priority of the person.
    * is not necessary to give it the ID because we set id = to passport number already in Person class
    */
    public void addPerson(String fName, String lName, String passportNo, int age, Priority priority) {
        //As soon as the method is called, it will create automatically the new person object assigning it the parameters given to the method
        Person newPerson = new Person (fName, lName, passportNo, age, priority);

        //the first IF statement will check if the queue is empty calling the isEmpty method
        if (isEmpty()){
            //If it is empty the new person will be the first and the last in the queue and size will be incremented by 1
            this.last = newPerson;
            this.first = newPerson;
            this.size++;
        } else {
            /*If it is not empty we have this switch case which will help to validate the priority of
            * the new person trying to be added in case is either low, medium or high priority status
            * */
            switch (priority){
                // if the priority of the new person is LOW it will call the addLow method
                case LOW: addLow(newPerson);
                break;
                // if the priority of the new person is MEDIUM it will call the addMed method
                case MEDIUM: addMed(newPerson);
                break;
                // if the priority of the new person is HIGH it will call the addHigh method
                case HIGH: addHigh(newPerson);
                break;
            }
        }
    }
    /*
    * The following three methods are the addLow
    * addMed and addHigh. If whichever of these methods
    * is called that will mean that the switch statement of the
    * addPerson method has been reached, therefore the list is not empty
    * and there is/are person object(s) already in the queue
    * and the three of them receive the newPerson created
    * by the addPerson method as a parameter
    * */

    // The first case we try to add a low priority person
    public void addLow(Person newPerson){
        // As the queue is not empty we set a "current" person as the first in the list.
        Person current = this.first;
        /*
        * If the user wants to add a low priority person to the queue we need to send it at the end
        * or the last position of the queue. so this while loop will evaluate first if the  value of current next
        * is not null to avoid a Null pointer exc. AND whether current next priority value is high, medium or low
        * */
        while (current.getNext() != null && (current.getNext().getPriority().equals(Priority.HIGH) ||
                current.getNext().getPriority().equals(Priority.MEDIUM)|| current.getNext().getPriority().equals(Priority.LOW))){

            //if the conditions are met we move current one position to the next person due we want to reach the end of the queue
            current = current.getNext();
        }
        /*
        * Once current next value is null, that means that we have reached the end of
        * the que so we set current equals the last position
        * */
        this.last = current;
        current.setNext(newPerson);// Then we set its next value to the new person, is low so we want it after it
        newPerson.setPrev(current);// Point the previous value of the new person to current
        this.last = newPerson;// Now new person is the last one in the queue
        newPerson.setNext(null);// And its next value is null
        this.size++; // Size will be incremented by one every time this method is called
    }


    //This method is called by the switch statement when user wants to add a medium priority new person
    public void addMed(Person newPerson){
        // As the queue is not empty we set a "current" person as the first in the list.
        Person current = this.first;
        /*this time we do not want to reach the end of the queue straight away. The medium priority new person should be added BEFORE
        * the first low priority in queue. So first we check if current person priority is Low */
        if(current.getPriority().equals(Priority.LOW)){
            // If it is, as we set current to First it means that the first is also low priority, so then...
            newPerson.setNext(current);// we point the next value of the new person to current
            current.setPrev(newPerson);// point the current previous value to the new person
            this.first = newPerson;// And set new person as the first on the queue

            // Now if current has not a priority value of low but medium....
        }else if (current.getPriority().equals(Priority.MEDIUM)) {
            /*We need to allocate the new person after the last medium but before the first low priority person in queue
            * so this while loop checks first that current next value is not null tp avoid a Null pointer ex.
            * AND current next priority value is equals medium
            * */
            while ( current.getNext()!=null && current.getNext().getPriority().equals(Priority.MEDIUM)) {
                //if the conditions are met we move current one position to the next person due we want to reach the position
                // between the last medium and the first low..... if current next priority value is low it won't move to the next
                current = current.getNext();
            }
            newPerson.setNext(current.getNext());// Set value of new person next to whatever value of current next is which will be the first low priority
            newPerson.setPrev(current);// set the new person previous value to current which will be medium priority because it did not go to the next
            current.setNext(newPerson);// and set the value of current next of the new Person

        }else{ //If we reach this point is because current has to have a priority value of high
                /*for that case is just needed to add one more condition to the while loop
                * which is that also if the value of current next priority is high OR medium go tu next until reach the last medium priority of the queue*/
                while(current.getNext() != null &&(current.getNext().getPriority().equals(Priority.HIGH)
                        || (current.getNext().getPriority().equals(Priority.MEDIUM)))){
                   // if the conditions are met we move current one position to the next
                    current = current.getNext();
                }
            newPerson.setNext(current.getNext());// Set value of new person next to whatever value of current next is which will be the first medium priority
            newPerson.setPrev(current);// set the new person previous value to current which will be high priority because it did not go to the next
            current.setNext(newPerson);// and set the value of current next of the new Person
        }
        this.size ++;// and whatever is the case size is incremented by when for each new person added
    }

    //This method is called by the switch statement when user wants to add a high priority new person
    public void addHigh(Person newPerson){
        // Again as the queue is not empty we set a "current" person as the first in the list.
        Person current = this.first;

        /*As in the addMed method do not want to reach the end of the queue straight away. The high priority new person should be added BEFORE
         * the first low priority in queue. So first we check if current person priority is Low */
        if(current.getPriority().equals(Priority.LOW)){
            // If it is, as we set current to First it means that the first is also low priority, so then...
            newPerson.setNext(current);// we point the next value of the new person to current
            current.setPrev(newPerson);// point the current previous value to the new person
            this.first = newPerson;// And set new person as the first on the queue

            //Same if current is medium priority. the new high priority person should be added before the fist medium priority
        } else if (current.getPriority().equals(Priority.MEDIUM)){
            // If it is, as we set current to First it means that the first is also medium priority, so then...
            newPerson.setNext(current);//we point the next value of the new person to current
            current.setPrev(newPerson);// point the current previous value to the new person
            this.first = newPerson;// And set new person as the first on the queue

        }else{//If we reach this point is because current has to have a priority value of high
                // and we want to add this new high priority person after the last high but before the first medium
                while(current.getNext() != null && current.getNext().getPriority().equals(Priority.HIGH)){
                    //if the conditions are met we move current one position to the next person due we want to reach the position
                    // between the last high and the first medium..... if current next priority value is medium it won't move to the next
                    current = current.getNext();
                }
            newPerson.setNext(current.getNext());// Set value of new person next to whatever value of current next is which will be the first medium priority
            newPerson.setPrev(current);// set the new person previous value to current which will be high priority because it did not go to the next
            current.setNext(newPerson);// and set the value of current next of the new Person
        }
        this.size++;// and whatever is the case size is incremented by when for each new person added
    }

    /*Is important to mention that the following four methods are made to remove person(s) from the queue.
    * And is not that we actually remove something. In the background we are just loosing the references
    * that the person object to be "removed" has with its previous and its next so it has no more
    * references and the Java garbage collector will pick up away, therefore is not needed to create a local variable*/

    /* The dequeue method will help to remove a person from the beginning of the queue once
    * it has been looking after. It is not necessary */
    public void dequeue(){
        this.first = this.first.getNext();// we set the First position equals to the first next...
        this.first.setPrev(null);//once done that whoever used to be the next of the first is now the first and the previous first is lost as we set first previous as null
        this.size--; //decrement size by 1 every time this method is called
    }

    /*the following method is also for dequeueing but N amount of people from the biginning of the queue
    * where N is an integer number of people to removed that user pass as parameter
    * the user needs to be sure that the N people to remove has to be smaller or equal thn the size of the queue
    * which could be done by the method getSize()*/
    public void dequeueN(int n){
        Person current = this.first; //set Current as the first in the queue
        int i = 1;// initialized a counter = 1
        //if our counter is less or equales than N ....
        if (i <= n){
            this.first = current.getNext();//set the value of First equals to value of current next
            this.first.setPrev(null);// and the value of the new first previous equals to null
            size--;//decrement the size of the queue by 1 every time this happens
            /*I decided to use recursive method approche  so after doing the previous steps
            * the method will call again itself we the value of n-1 therefore the will be a moment that
            * n will be smaller than i and the if will no be reach, therefore the method will not call again itself */
            dequeueN(n-1);
        }
    }
    //same as dequeueN method but removing from the end of the queue as a request of the CA
    public void removeNPerson(int n){
        Person current = this.last;// this time we want to start from the end so set current to last position
        int i = 1;// initialized a counter = 1
        if (i <= n){//if our counter is less or equales than N ....
            this.last = current.getPrev();//set the value of last equals to value of current previous
            this.last.setNext(null);// and the value of the new last next equals to null
            size--;//decrement the size of the queue by 1 every time this happens
            //same recursive method approche explained in the dequeueN method
            removeNPerson(n-1);
        }
    }

    /* As part of the requirements of the CA it is needed to remove a person from anywhere of the queue and keeping the track
    * of the elements that are NOT been removed. For that this method receives the ID (remember same as passportNo) as parameter
    * and will look for the person with that ID to remove it from the queue*/
    public void removeFromAnywhere(String id){
        Person current = this.first; //Set current equals to first position to start looping
        while(id != current.getId()){
            //While the ID given is not equals to the id of the current person... go to the next
            current = current.getNext();
        }
        if(id == current.getId()){
            // once the ID given matches the id of the current person...
            current.getPrev().setNext(current.getNext());//Set the next value of the previous of the current to be equals to the value of next of the current
            current.getNext().setPrev(current.getPrev());//Set the previous value of the next of the current to be equals to the value of previous of the current
            this.size--;//decrement the size of the queue by 1 every time this happens
        }
    }

    //This method will print out the person with the same ID as the give as a parameter with its position in the queue
    public void getAPerson(String id){
        Person current = this.first;//set current to be the first
        int position = 1;//counter to keep tracking the positions of the person in the queue
        while(id != current.getId()){
            //While the ID given is not equals to the id of the current person... go to the next and....
            current = current.getNext();
            position++;//... increment the counter position by 1
        }
        if(id == current.getId()){
            // once the ID given matches the id of the current person print out the person and its position
            //it will not print the allocation in memory thanks to the toString method in Person class
            System.out.println("\n The Person is: " + current + " at position: " + position);
        }
    }

    //Method to update a person without altering the queue
    /*This method will first take as a parameter the ID of the person we are looking for
    * then IT HAS TO RECEIVE AS PARAMETER THE NEW INFORMATION THAT USER DECIDES
    * e.g. the parameter fName has to e the new first name
    * it will not receive priority as parameter because as requirement of the CA we do not want
    * to alter the queue, so there is not point to*/
    public void updatePerson(String id, String fName, String lName, String passportNo, int age){
        Person current = this.first;//set current to be the first
        while(id != current.getId()){
            //While the ID given is not equals to the id of the current person... go to the next
            current = current.getNext();
        }
        if (id == current.getId()){// once the ID given matches the id of the current person print out the person and its position
            // we just set the new values using the setters of the Person class
            current.setfName(fName);
            current.setlName(lName);
            current.setAge(age);
            current.setPassportNo(passportNo);
        }
    }

    //And the last method... the ona tha display the elements, in this cases people in the queue
    public void displayQueue() {
        System.out.println("High------>low");//print statement telling we are going from high to low
        Person current  = this.first;//set current to be the first
        while(current != null) {//While the current has a value diferent that null
            System.out.println(current);//print out current thanks to the toString method
            current = current.getNext();// current move to the next... until the value of current is null
        }
    }

}
