package model;

public class LinkedList<T> {
	Link<T> start;
	Link<T> end;
	int size = 0;

	public int getSize() {
		return size;
	}

	public void clearLinkedList() {
		while (size > 0) {
			removeLeft();
		}			
		
	}

	public void insertLeft(Link<T> pLinkToInsert) {
		if (getSize() == 0) {
			start = pLinkToInsert;
			end = pLinkToInsert;
		} else {
			start.setPrevious(pLinkToInsert);
			pLinkToInsert.setNext(start);
			start = pLinkToInsert;
		}
		size++;
	}

	public void insertLeft(T pValueToInsert) {
		insertLeft(new Link<T>(pValueToInsert));
	}

	public void insertRight(Link<T> pLinkToInsert) {
		if (getSize() == 0) {
			end = pLinkToInsert;
			start = pLinkToInsert;
		} else {
			end.setNext(pLinkToInsert);
			pLinkToInsert.setPrevious(end);
			end = pLinkToInsert;
		}
		size++;
	}

	public void insertRight(T pValueToInsert) {
		insertRight(new Link<T>(pValueToInsert));
	}

	public Link<T> removeLeft() {
		Link<T> temp = start;

		if (size > 1) {
			start = start.getNext();
			start.setPrevious(null);		
			size--;			
		} else if (size == 1) {
			size--;
			start = start.getNext();
			end = start;
		} else {
			start = null;
		}
		return temp;
	}

	public Link<T> removeRight() {
		Link<T> temp = end;
		if (size > 1) {
			end = end.getPrevious();
			end.setNext(null);		
			size--;			
		} else if (size == 1) {
			size--;
			end = end.getPrevious();
			start = end;
		} else {
			end = null;
		}
		return temp;
	}

	public String toString() {
		Link<T> current = start;
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append(current.getValue() + " -> ");
			current = current.getNext();

		}
		return "[" + sb.toString().replaceAll(" -> $", "") + "]";

	}

}
