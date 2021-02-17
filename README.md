# DSACA
## This assignment is focused upon the utilisation of a Doubly Linked List data storage solution as underlying structure for a queue.

• There should be three priority levels:
o High Priority
o Medium Priority
o Low Priority
• When a low priority person has been added to the queue, they must go straight to the end of it.
• When a high priority person has been added to the queue, they must go straight to the start of the queue, unless the first person is of high priority, in such case they should be added after the last high priority person in the queue.
• When a medium priority person has been added to the queue, the must go after all the high priority people, but before all the low priority people in the queue.
• At any time, the staff member should have the ability to delete a person from the system by entering in their unique ID number. If the person is removed from the queue, their object should be removed and whoever was in front of them should be jointed to the person who was behind them.
• For each of the operations which are being performed on the queue, individual methods should be created to encapsulate the functionality.
• A method should exist to cut off the last N number of records from the queue. If the staff member types in 3. Then the last 3 objects on the linked list should be removed.
• Given a person unique number, the staff member should be able to update the information for that person, without impacting where they currently are in the queue
