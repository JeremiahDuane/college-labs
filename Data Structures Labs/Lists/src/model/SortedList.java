package model;

import model.UnsortedList;

import java.util.ArrayList;
import java.util.List;

public class SortedList extends UnsortedList {

	public int find(int pValueToFind) {
		int start = 0;
		int end = currentInsertPosition - 1;
		int mid = (start + end) / 2;
		while (values[mid] != pValueToFind && mid < end && mid > start) {
			if (values[mid] < pValueToFind) {
				start = mid;
				mid = (start + end) / 2;
			}
			if (values[mid] > pValueToFind) {
				end = mid;
				mid = (start + end) / 2;
			}
			if (values[mid] == pValueToFind) {
				return mid;
			} else if (values[start] == pValueToFind) {
				return start;
			} else if (values[end] == pValueToFind) {
				return end;
			}
		}
		if (values[mid] == pValueToFind) {
			return mid;
		} else {
			return -1;
		}
	}

	public int[] findAll(int pValueToFind) {
		List<Integer> foundArr = new ArrayList<Integer>();
		int foundIndex = find(pValueToFind);
		if (duplicatesAllowed) {

			int i = 0;

			if (foundIndex != -1) {
				while (values[foundIndex] == values[foundIndex - i]) {
					foundArr.add(foundIndex - i);
					i++;
				}
				int n = 1;
				while (values[foundIndex] == values[foundIndex + n]) {
					foundArr.add(foundIndex + n);
					n++;
				}
			}
		} else {
			foundIndex = find(pValueToFind);
			foundArr.add(foundIndex);

		}
		return foundArr.stream().mapToInt(x -> x.intValue()).toArray();

	}

	public void insert(int pValueToInsert) {
		super.insert(pValueToInsert);
	bubbleSort();}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		super.initializeWithRandomData(pSizeOfList);
		bubbleSort();

	}

	@Override
	public Listable bubbleSort() {
		int tempVar;
		for (int i = 0; i < currentInsertPosition; i++) {
			for (int j = 1; j < (currentInsertPosition - i); j++) {
				if (values[j - 1] > values[j]) {
					// swap elements
					tempVar = values[j - 1];
					values[j - 1] = values[j];
					values[j] = tempVar;

				}

			}
		}
		return null;
	}

	@Override
	public Listable selectionSort() {
		int p = currentInsertPosition;
		for (int i = 0; i < p; i++) {
			int small = values[i];
			int pos = i;

			for (int j = i + 1; j < p; j++) {
				if (values[j] < small) {
					small = values[j];
					pos = j;
				}
			}

			int temp = values[pos];
			values[pos] = values[i];
			values[i] = temp;
		}
		return null;
	}

}
