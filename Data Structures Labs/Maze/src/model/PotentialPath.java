package model;

import java.util.ArrayList;
import java.util.List;

public class PotentialPath implements Comparable<PotentialPath> {
	private static int instancesCreated = 0;
	private List<Integer> potentialPath = new ArrayList<>();
	private int fCost;
	
	


	@Override
	public int compareTo(PotentialPath pO) {
		// Thanks Jacob Smith for the nice sorting algorithm!
		if (fCost < pO.fCost) { // if the fCost is lower, we are done.
			return -1;
		} else if (fCost > pO.fCost) { // if the fCost is higher, we are done.
			return 1;
		} else { // if the fCosts are the same, return the shortest path.
			if (potentialPath.size() > pO.getPotentialPath().size()) {
				return -1;
			}
		}
		return 0;
	}

	public PotentialPath(List<Integer> pPotentialPath, int pFCost) {
		potentialPath = pPotentialPath;
		fCost = pFCost;
		instancesCreated++;
	}

	public int last() {
		return potentialPath.get(size());
	}
	//doesNotMatter
	public int size() {
		return potentialPath.size()-1;
	}
	
	public List<Integer> getPotentialPath() {
		return potentialPath;
	}

	public static int getInstancesCreated() {
		return instancesCreated;
	}
}
