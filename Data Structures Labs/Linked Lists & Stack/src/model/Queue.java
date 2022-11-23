package model;

public class Queue<T> extends LinkedList<T> {
	public void clear() {
		clearLinkedList();		
	}

	public void enqueue(T dataItem) {
		insertRight(dataItem);
	}

	public Link<T> dequeue() {
		return removeLeft();
	}

}
