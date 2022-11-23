package model;

public class Stack<T> extends LinkedList<T> {
	public void clear() {
		clearLinkedList();		
	}

	public void push(T dataItem) {
		insertRight(dataItem);
	}

	public Link<T> pop() {
		return removeRight();
	}

}
