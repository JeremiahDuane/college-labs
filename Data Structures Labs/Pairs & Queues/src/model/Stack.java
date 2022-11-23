package model;

public class Stack<T> implements Stackable<T> {
	// private priorityValues<T>[] values = (priorityValues<T> new Object[Max_SIZE];
	private Object[] values = new Object[MAX_SIZE];
	protected int cIP = 0;

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
		// TODO Auto-generated method stub
		return MAX_SIZE;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int n = 0; n < cIP; n++) {
			values[n] = null;
		}
		cIP = 0;
	}

	@Override
	public void push(T dataItem) {
		if (cIP <= MAX_SIZE) {
			values[cIP] = dataItem;
			cIP++;
		}

	}

	@Override
	public T pop() {
		if (cIP > 0) {
			T returnValue = (T) values[--cIP];
			values[cIP] = null;
			return returnValue;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (cIP != 0) {
			return (T) values[cIP - 1];
		} else {
			return null;
		}
	}

}
