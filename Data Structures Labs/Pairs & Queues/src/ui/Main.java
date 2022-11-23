package ui;

import java.util.ArrayList;
import java.util.List;

import model.Pairing;
import model.Queue;
import model.Stack;

public class Main {

public static void main(String[] args) {
List<Stack> objectList = new ArrayList<>();
//Pairing<Integer> myPriorityValue = new Pairing<>();
 
Queue<Pairing> myPriorityQueue = new Queue<>();
//test for Priority queue
myPriorityQueue.setPriorityQueue(true);
System.out.println("is full: " + myPriorityQueue.isFull());
System.out.println("the size is: " + myPriorityQueue.getSize());
System.out.println("the capacity is: " + myPriorityQueue.getCapacity());
System.out.println("is priority queue: " + myPriorityQueue.isPriorityQueue());
myPriorityQueue.clear();
System.out.println("after clearing the list the size is " + myPriorityQueue.getSize());
myPriorityQueue.enqueue(new Pairing<>("first added with lower priority",4));
myPriorityQueue.enqueue(new Pairing<>("second added with higher priority",2));
myPriorityQueue.enqueue(new Pairing<>("third added but will fail to add because of capacity with highest priority",1));
System.out.println("after enqueuing three priority values the size is: " + myPriorityQueue.getSize() + " and the capacity is: " + myPriorityQueue.getCapacity());
System.out.println("is full: " + myPriorityQueue.isFull());
System.out.println("peeking at value: " + myPriorityQueue.peek().getInput());
System.out.println("peeking at priority: " + myPriorityQueue.peek().getPriorityValue());
Pairing<Integer> priorityValueToSave = myPriorityQueue.dequeue();
System.out.println("Looking at firts dequed value: " + priorityValueToSave.getInput());
System.out.println("Looking at dequed priority: " + priorityValueToSave.getPriorityValue());
Pairing<Integer> priorityValueToSave2 = myPriorityQueue.dequeue();
System.out.println("Looking at second dequed value: " + priorityValueToSave2.getInput());
System.out.println("Looking at dequed priority: " + priorityValueToSave2.getPriorityValue());
System.out.println("Trying to deque an empty list: " + (myPriorityQueue.dequeue()));

 

//test for queue
Queue<Integer> myQueue = new Queue<>();
myQueue.setPriorityQueue(false);
System.out.println("is full: " + myQueue.isFull());
System.out.println("the size is: " + myQueue.getSize());
System.out.println("the capacity is: " + myQueue.getCapacity());
System.out.println("is priority queue: " + myQueue.isPriorityQueue());
myQueue.clear();
System.out.println("after clearing the list the size is " + myQueue.getSize());
myQueue.enqueue(4);
myQueue.enqueue(7);
System.out.println("after enqueuing 4 and 7 the size is: " + myQueue.getSize());
System.out.println("is full: " + myQueue.isFull());
myQueue.enqueue(6);
System.out.println("peeking at value: " + myQueue.peek());
System.out.println("dequeue value: " + myQueue.dequeue());
System.out.println("peeking at value: " + myQueue.peek());
System.out.println("dequeue value: " + myQueue.dequeue());
System.out.println("peeking at value: " + myQueue.peek());
System.out.println("dequeue value: " + myQueue.dequeue());




//test for stack
Stack<Integer> sl = new Stack<>();
System.out.println("is full: " + sl.isFull());
System.out.println("the size is: " + sl.getSize());
System.out.println("the capasity is: " + sl.getCapacity());
sl.clear();
System.out.println("after clearing the list the size is: " + sl.getSize());
sl.push(2);
sl.push(0); 
sl.push(7);
sl.push(4);
sl.push(0);
System.out.println("pushed values {2, 0, 7, 4, 0} with the size now being: " + sl.getSize() + "and the capacity at: " + sl.getCapacity());
System.out.println("peeking at the value: " + sl.peek());
System.out.println("the value to pop is: " +sl.pop());
System.out.println("peeking at the value: " +sl.peek());
System.out.println("the size is now: " + sl.getSize());
sl.clear();
System.out.println("cleared the list, the value to pop is: " + sl.pop());
System.out.println("peeking at the value: " + sl.peek());

 
 
}

}