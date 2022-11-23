package ui;

import model.Heap;
import model.Pairing;
import model.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.enqueue(2, 1);
		pq.enqueue(2, 2);
		pq.enqueue(2, 4);
		pq.enqueue(2, 1);
		pq.enqueue(2, 7);
		pq.enqueue(2, 1);

		System.out.println(pq.toString());
		System.out.println("Deleted node:" + pq.dequeue());
		System.out.println(pq.toString());
		System.out.println(pq.dequeue());
		System.out.println(pq.toString());

	}

}
