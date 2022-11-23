package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Listable;

public class UnsortedList implements Listable {
	private boolean duplicatesAllowed;
	private int[] values = new int[MAX_SIZE];
	private int currentInsertPosition = 0;
	private int a = 0;
	private int b = 0;

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
			} else if (!duplicatesAllowed && currentInsertPosition !=0) {
				if (values[(currentInsertPosition - 1)] != pValueToInsert) {
					values[currentInsertPosition++] = pValueToInsert;
				}
			} else {
				values[currentInsertPosition++] = pValueToInsert;
			}
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		if (currentInsertPosition > 0 && currentInsertPosition < MAX_SIZE) {
			a = 0;
			for (int n = 0; n <= currentInsertPosition; n++) {
				if (values[n] == pValueToDelete && a == 0) {
					a++;
					b++;
				}
				if (n + a < MAX_SIZE) {
				values[n] = values[n + a];
				} else {
				values[n] = 0;
				currentInsertPosition--;
				}
				
			}
			currentInsertPosition = currentInsertPosition - 1;
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		b = 0; 
		
			for (int n = 0; n <= currentInsertPosition; n++) {
				delete(pValueToDelete);
				currentInsertPosition++;
			

		}
		currentInsertPosition = currentInsertPosition - b;
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		// For each element to insert, get random number, get random number at current
		// position.
		if (pSizeOfList <= MAX_SIZE) {
			for (int n = 0; n < pSizeOfList; ++n) {
				int randomNumber = (int) (Math.random() * MAX_SIZE);

				values[n] = randomNumber;
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

	//
	// public void insertAt(int pValueToInsert, int pCurrentInsertPosition) {
	// if (duplicatesAllowed) {
	// values[currentInsertPosition++] = pValueToInsert;
	// } else if (!duplicatesAllowed) {
	// if (values[(currentInsertPosition - 1)] != pValueToInsert) {
	// values[currentInsertPosition++] = pValueToInsert;
	// }
	// }
	// }
	//
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < currentInsertPosition; ++n) {
			sb.append(values[n] + ",");
		}
		return "[" + sb.toString().replaceAll(",$", "") + "]";

	}
}
