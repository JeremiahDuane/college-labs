package model;

/**
 * Basic interface that all lists will implement.
 * 
 * @author cberkstresser
 * 
 */
public interface Queueable<T> {
	final int MAX_SIZE = 10;

	/**
	 * 
	 * @return True if the list is full.
	 */
	boolean isFull();

	/**
	 * 
	 * @return Returns the actual size of the list.
	 */
	int getSize();

	/**
	 * 
	 * @return Returns the maximum capacity of the list.
	 */
	int getCapacity();

	/**
	 * 
	 * @return Returns whether this queue should consider priority.
	 */
	boolean isPriorityQueue();

	/**
	 * 
	 * @param pIsPriorityQueue
	 *            Sets whether this queue is a priority queue.
	 */
	void setPriorityQueue(boolean pIsPriorityQueue);

	/**
	 * Clears the array to an initialized, size=0 state.
	 */
	void clear();

	/**
	 * Inserts an item in the list.
	 * 
	 * @param dataItem
	 *            The item to insert into the list.
	 */
	void enqueue(T dataItem);

	/**
	 * 
	 * @return Removes the last item pushed onto the stack back to the user.
	 */
	T dequeue();

	/**
	 * 
	 * @return Shows the last item pushed onto the stack without removing it
	 *         from the stack.
	 */
	T peek();
}