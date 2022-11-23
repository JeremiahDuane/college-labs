package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Maze {
	private ArrayList<Integer> map = new ArrayList<>();
	private int length = 0;
	private int height = 0;
	Set<Integer> closedList = new HashSet<>();
	Set<Integer> openList = new HashSet<>();

	/**
	 * Private placeholder for sorting potential paths.
	 */
	Queue<PotentialPath> potentialPaths = new PriorityQueue<>();

	/**
	 * Constructor.
	 * 
	 * @param mazeToFindPath An array describing the maze. A value of 1 represents a
	 *                       "walkable" tile and a value of -1 represents a "wall."
	 *                       You will always start waking in the top left corner and
	 *                       the target will be the bottom right.
	 */
	public Maze(int[][] mazeToFindPath) {
		// TODO save the maze to a private placeholder and initialize anything else you
		// need here.

		length = mazeToFindPath[0].length;
		for (int[] array : mazeToFindPath) {
			height++;
			for (int integer : array) {
				map.add(integer);
			}

		}
	}

	/**
	 * Method to display the path taken in ASCII art.
	 * 
	 * @see Sample output in the lab assignment on CampusWeb.
	 */
	public void showPath() {
		// Find Path
		try {
			for (Integer index : findPath()) {
				map.set(index, 0);
			}
		} catch (NullPointerException e) {
			
		}
		// Output found path
		int counter = 0;
		int moves = 0;
		for (int n : map) {
			counter++;
			if (n == -1) {
				System.out.print("██");
			}
			if (n == 1) {
				System.out.print("  ");
			}
			if (n == 0) {
				System.out.print("* ");
				moves++;
			}
			if ((counter % length) == 0) {
				System.out.println();
			}

		}
		System.out.println("Number of moves required: " + moves);

//		List<String> dynamic = new LinkedList<>(mapFound);
//		int indexCounter = -1;
//		System.out.println(mapFound.size());
//		for (String node : mapFound) {
//			indexCounter++;
//			if (node.equals("* ")) {
//				boolean test = true;
//				try {
//					if (mapFound.get((indexCounter + 1)).equals("* ") && mapFound.get((indexCounter)).equals("* ")) {
//						dynamic.set(indexCounter, "⇒ ");
//					}
//				} catch (IndexOutOfBoundsException e) {
//
//				}
//				try {
//					if (mapFound.get((indexCounter - 1)).equals("* ") && mapFound.get((indexCounter)).equals("* ")) {
//						dynamic.set(indexCounter, "⇐ ");
//					}
//				} catch (IndexOutOfBoundsException e) {
//
//				}
//				try {
//					if (mapFound.get((indexCounter + length)).equals("* ") && mapFound.get((indexCounter)).equals("* ")) {
//						dynamic.set(indexCounter, "⇓ ");
//					}
//				} catch (IndexOutOfBoundsException e) {
//
//				}
//				try {
//					if (mapFound.get((indexCounter - length)).equals("* ") && mapFound.get((indexCounter)).equals("* ")) {
//						dynamic.set(indexCounter, "⇑ ");
//					}
//				} catch (IndexOutOfBoundsException e) {
//
//				}
//			}
//		}
//		for (String string : dynamic) {
//			System.out.print(string);
//		}
	}

	private List<Integer> findPath() {
		List<Integer> thisPath = new ArrayList<>();
		thisPath.add(0);
		potentialPaths.add(new PotentialPath(thisPath, getHCost(0)));
		PotentialPath cPath = new PotentialPath(thisPath, 0);
		try {
			while (getHCost(cPath.last()) != 0) {

				cPath = potentialPaths.poll();

				closedList.add(cPath.last());

				if (getHCost(cPath.last()) == 0) {
					break;
				}

				int current = cPath.last();
				try {
					if ((!closedList.contains(right(current)) && map.get(right(current)) != -1)) {
						List<Integer> temp = new ArrayList<>(cPath.getPotentialPath());
						temp.add(right(current));
						potentialPaths.add(new PotentialPath(temp, (cPath.size() + 1 + getHCost(right(current)))));

					}
				} catch (IndexOutOfBoundsException e) {

				}
				try {
					if ((!closedList.contains(down(current)) && map.get(down(current)) != -1)) {
						List<Integer> temp = new ArrayList<>(cPath.getPotentialPath());
						temp.add(down(current));
						potentialPaths.add(new PotentialPath(temp, (cPath.size() + 1 + getHCost(down(current)))));

					}
				} catch (IndexOutOfBoundsException e) {

				}
				try {
					if ((!closedList.contains(left(current)) && map.get(left(current)) != -1)) {
						List<Integer> temp = new ArrayList<>(cPath.getPotentialPath());
						temp.add(left(current));
						potentialPaths.add(new PotentialPath(temp, (cPath.size() + 1 + getHCost(left(current)))));
					}
				} catch (IndexOutOfBoundsException e) {

				}
				try {
					if ((!closedList.contains(up(current)) && map.get(up(current)) != -1)) {
						List<Integer> temp = new ArrayList<>(cPath.getPotentialPath());
						temp.add(up(current));
						potentialPaths.add(new PotentialPath(temp, (cPath.size() + 1 + getHCost(up(current)))));
					}
				} catch (IndexOutOfBoundsException e) {

				}

			}
			return cPath.getPotentialPath();
		} catch (NullPointerException e) {
			System.out.println("No path exists.");
			return null;
		}

	}

	// steps away from end
	public int getHCost(int pIndex) {
		int lengthDistance = length - (pIndex % length);
		int heightDistance = height - (pIndex / length);
		int hCost = lengthDistance + heightDistance - 2;
		return hCost;
	}

	// steps taken
	public int getGCost(PotentialPath pPath) {
		return pPath.size() - 1;
	}

	private Set<Integer> getNeighbors(int pIndex) {
		Set<Integer> moves = new HashSet<>();
		moves.add(right(pIndex));
		moves.add(down(pIndex));
		moves.add(left(pIndex));
		moves.add(up(pIndex));
		return moves;

	}

	private int up(int pIndex) {
		if ((pIndex - length) >= 0) {
			return (pIndex - length);

		} else {
			return (-1);
		}
	}

	private int down(int pIndex) {
		if ((pIndex - length) < map.size()) {
			return (pIndex + length);
		} else {
			return (-1);
		}
	}

	private int left(int pIndex) {
		if ((pIndex - 1) % length != 0) {
			return (pIndex - 1);
		} else {
			return -1;
		}
	}

	private int right(int pIndex) {
		if ((pIndex + 1) % length != 0) {
			return (pIndex + 1);
		} else {
			return -1;
		}
	}

}
