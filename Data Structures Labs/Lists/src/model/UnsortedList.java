package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnsortedList implements Listable {
	protected boolean duplicatesAllowed;
	protected int[] values = new int[MAX_SIZE];
	protected int currentInsertPosition = 0;
	private int a = 0;
	private int b = 0;
	protected int rej = 0;

	@Override
	public int getSizeOfList() {
		// Is this enough?
		return currentInsertPosition;
	}

	@Override
	public boolean areDuplicatesAllowed() {
		// Is this enough?
		return duplicatesAllowed;
	}

	@Override
	public void setDuplicatesAllowed(boolean pDuplicatesAllowed) {
		duplicatesAllowed = pDuplicatesAllowed;

	}

	@Override
	public void clear() {
		for (int n = 0; n <= currentInsertPosition; n++) {
			values[n] = values[0];
		}
		currentInsertPosition = 0;

	}

	@Override
	public void insert(int pValueToInsert) {
		if (currentInsertPosition >= 0 && currentInsertPosition < MAX_SIZE) {
			if (duplicatesAllowed) {
				values[currentInsertPosition++] = pValueToInsert;
			} else if (!duplicatesAllowed && currentInsertPosition != 0) {
				boolean t = true;
				for (int n = 0; n < currentInsertPosition; n++) {
					if (values[n] == pValueToInsert) {
						t = false;
						rej = rej + 1;

					}
				}
				if (t != false) {
					values[currentInsertPosition++] = pValueToInsert;
				}
			} else {
				values[currentInsertPosition++] = pValueToInsert;
			}
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		if (currentInsertPosition > 0 && currentInsertPosition <= MAX_SIZE) {
			a = 0;
			for (int n = 0; n < currentInsertPosition; n++) {
				if (values[n] == pValueToDelete && a == 0) {
					a++;
					b++;
				}
				if (n + a < MAX_SIZE) {
					values[n] = values[n + a];
				} else {
					values[n] = 0;
				}

			}
			if (a != 0) {
				currentInsertPosition = currentInsertPosition - 1;
			}
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		b = 0;

		for (int n = 0; n < currentInsertPosition; n++) {
			delete(pValueToDelete);
		}
		
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		
		// For each element to insert, get random number, get random number at current
		// position.
		System.out.println("MEMEMEMEME");
		boolean test = false;
		if (pSizeOfList + rej <= MAX_SIZE) {
			for (int n = 0; n < pSizeOfList + rej; n++) {
				int randomNumber = (int) (Math.random() * MAX_SIZE);

				if (!duplicatesAllowed) {
					insert(randomNumber);
				} else {
					values[n] = randomNumber;

				}
			}

			currentInsertPosition = pSizeOfList;
		}
	}

	@Override 
	public int find(int pValueToFind) {
		for (int n = 0; n < currentInsertPosition; n++) {
			if (values[n] == pValueToFind) {
				return n;
			}
		}
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		// Loop through all
		if (!duplicatesAllowed) {
			int result = find(pValueToFind);
			if (result == -1) {
				return new int[0];
			} else {
				return new int[] { result };
			}
		} else {
			List<Integer> returnValues = new ArrayList<Integer>();
			for (int n = 0; n < currentInsertPosition; n++) {
				if (values[n] == pValueToFind) {
					returnValues.add(n);
				}
			}
			return returnValues.stream().mapToInt(x -> x.intValue()).toArray();

		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < currentInsertPosition; ++n) {
			sb.append(values[n] + ",");
		}
		return "[" + sb.toString().replaceAll(",$", "") + "]";

	}
}
