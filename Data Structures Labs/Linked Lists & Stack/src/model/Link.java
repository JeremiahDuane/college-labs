package model;

public class Link<T> {
	private T value;
	private Link<T> next;
	private Link<T> previous;
	public T getValue() {
		return value;
	}
	
	public Link(T pValueToInsert) {
		value = pValueToInsert;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Link<T> getNext() {
		return next;
	}
	public void setNext(Link<T> next) {
		this.next = next;
	}
	public Link<T> getPrevious() {
		return previous;
	}
	public void setPrevious(Link<T> previous) {
		this.previous = previous;
	}
	
	public String toString() {
		
		return String.valueOf(getValue());

	}
}