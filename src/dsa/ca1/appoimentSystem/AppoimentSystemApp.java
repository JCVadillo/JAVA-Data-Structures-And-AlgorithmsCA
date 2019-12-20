package dsa.ca1.appoimentSystem;

import dsa.ca1.person.Priority;
import dsa.ca1.queue.Queue;


public class AppoimentSystemApp {

    public static void main(String[] args) {

        //instance of the queue
        Queue myQueue = new Queue();

        //trying all the possible add methods in no order
        myQueue.addPerson("Jennifer", "Orizaba", "A11111111", 32, Priority.LOW);
        myQueue.addPerson("Oscar", "Villasenior", "B22222222", 30, Priority.HIGH);
        myQueue.addPerson("Alfonso", "Alcantara", "C33333333", 22, Priority.MEDIUM);
        myQueue.addPerson("Hugo", "Velazquez", "D44444444", 25, Priority.MEDIUM);
        myQueue.addPerson("Carlos", "Cuevas", "E55555555", 21, Priority.MEDIUM);
        myQueue.addPerson("Juan", "Perez", "F66666666", 21, Priority.LOW);
        myQueue.addPerson("Pedro", "Gomez", "G77777777", 18, Priority.MEDIUM);
        myQueue.addPerson("Edgar", "Cobarrubias", "H88888888", 27, Priority.LOW);
        myQueue.addPerson("Amilcar", "Aponte", "I99999999", 30, Priority.HIGH);
        myQueue.addPerson("Alex", "Perez", "J11111111", 34, Priority.LOW);
        myQueue.addPerson("Daniel", "Juarez", "K22222222", 23, Priority.MEDIUM);
        myQueue.addPerson("Juan", "Vadillo", "M33333333", 33, Priority.MEDIUM);

        myQueue.displayQueue();
        myQueue.getSize();

        //updating the queue
        myQueue.updatePerson("I99999999", "Mario", "Castañeda", "G55555555", 54);
        myQueue.displayQueue();

        //calling dequeue
        myQueue.dequeue();
        myQueue.displayQueue();
        myQueue.getSize();

        //calling dequeueN
        myQueue.dequeueN(3);
        myQueue.displayQueue();
        myQueue.getSize();

        //removing N
        myQueue.removeNPerson(2);
        myQueue.displayQueue();
        myQueue.getSize();

        //removing from anywhere
        myQueue.removeFromAnywhere("K22222222");
        myQueue.displayQueue();
        myQueue.getSize();

        //getting a person
        myQueue.getAPerson("M33333333");
        }

}
