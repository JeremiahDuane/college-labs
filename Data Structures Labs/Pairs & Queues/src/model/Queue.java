package model;

import model.Pairing;

public class Queue<T> implements Queueable<T> {
	private Object[] values = new Object[MAX_SIZE];
	protected int cIP = 0;
	protected boolean pQ;

	@Override
	public boolean isFull() {
		if (cIP == MAX_SIZE + 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSize() {
		return cIP;
	}

	@Override
	public int getCapacity() {
		return MAX_SIZE;
	}

	@Override
	public void clear() {
		for (int n = 0; n < cIP; n++) {
			values[n] = null;
		}
		cIP = 0;
	}

	@Override
	public T peek() {
		return (T) values[0];
	}

	@Override
	public boolean isPriorityQueue() {
		return pQ;
	}

	@Override
	public void setPriorityQueue(boolean pIsPriorityQueue) {
		pQ = pIsPriorityQueue;
	}

	@Override
	public void enqueue(T dataItem) {
		if (pQ == false) {
			values[cIP] = dataItem;
			cIP++;
		} else {
			values[cIP] = dataItem;
			cIP++;
			bubbleSort();
		}
	}

	@Override
	public T dequeue() {
		T temp = (T) values[0];
		for (int n = 0; n < cIP; n++) {
			values[n] = values[n + 1];
		}
		cIP--;
		return temp;

	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < cIP; ++n) {
			sb.append(values[n] + ",");
		}
		return "[" + sb.toString().replaceAll(",$", "") + "]";

	}
	public void bubbleSort() {
		T tempVar;
		for (int i = 0; i < cIP; i++) {
			for (int j = 1; j < (cIP - i); j++) {
				if (((Pairing<T>) values[j-1]).getPriorityValue() > ((Pairing<T>) values[j]).getPriorityValue()) {
					// swap elements
					tempVar = (T) values[j - 1];
					values[j-1] = values[j];
					values[j] = tempVar;

				}

			}
		}
	}
}

