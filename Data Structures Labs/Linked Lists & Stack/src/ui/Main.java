package ui;

import model.Link;
import model.LinkedList;
import model.Queue;
import model.Stack;

public class Main {

	public static <T> void main(String[] args) {
		Queue<String> sl = new Queue<>();

		System.out.println("after clearing the list the size is: " + sl.getSize());
		sl.enqueue("hey");
		sl.enqueue("hegsgy");
		sl.enqueue("gsgs");
		System.out.println("the size now being: " + sl.getSize() + "and the capacity at: " + sl.getSize());
		System.out.println("the value to pop is: ");
		System.out.println("the size is now: " + sl.getSize());
		sl.dequeue();

System.out.println(sl);
	}

}
