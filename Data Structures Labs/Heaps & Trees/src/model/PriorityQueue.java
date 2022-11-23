package model;

public class PriorityQueue<T extends Comparable<T>> {
	Heap<Pairing<T>> heap = new Heap<>();
	public void enqueue(T itemToInsert, int priorityValue) {
		heap.insert(new Pairing<T>(itemToInsert, priorityValue));
	}
	
	public Pairing<T> dequeue() {
		return heap.delete();

	}
	
	public void clear() {
		heap.clear();

	}
	
	public String toString() {
		return heap.toString();
	}
}
