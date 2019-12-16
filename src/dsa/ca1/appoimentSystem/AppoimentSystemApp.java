package dsa.ca1.appoimentSystem;

import dsa.ca1.queue.Queue;
import dsa.ca1.person.Person;
import dsa.ca1.priority.*;


public class AppoimentSystemApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Queue myQueue = new Queue();
       myQueue.addPerson("Hugo", "Velazquez", "G142523BB", 2, Priority.LOW);
        myQueue.addPerson("Carlos", "Cuevas", "G142523AA", 21, Priority.LOW);
       myQueue.addPerson("Juan", "Perez", "G142523CC", 21, Priority.LOW);
       myQueue.addPerson("Pedro", "Gomez", "2222222", 15, Priority.MEDIUM);
//        myQueue.addPerson("Hugo", "Velazquez", "G142523AA", 2, Priority.HIGH);
//        myQueue.addPerson("Hugo", "Velazquez", "G142523CC", 32, Priority.HIGH);
        myQueue.addPerson("Alex", "Perez", "G24578s", 30, Priority.LOW);
        myQueue.addPerson("Daniel", "Juarez", "G142523SS", 2, Priority.MEDIUM);
//        myQueue.addPerson("Juan", "Vadillo", "585ABC", 32, Priority.MEDIUM);


        myQueue.displayQueue();

    }

}
