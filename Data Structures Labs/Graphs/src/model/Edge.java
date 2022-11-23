package model;

import java.util.HashSet;
import java.util.Set;

public class Edge implements IEdge {

	private int weight = 1;
	private IVertex vertex1;
	private IVertex vertex2;
	private String id;
	public Edge(IVertex iVertex, IVertex iVertex2) {
		vertex1 = iVertex;
			vertex2 = iVertex2;	
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String pId) {
		id = pId;
	}
	
	@Override
	public Set<IVertex> getAdjVertices() {
		Set<IVertex> returnSet = new HashSet<IVertex>();
		returnSet.add(vertex1);
		returnSet.add(vertex2);

		return returnSet;
	}

	@Override
	public void setAdjVertex1(IVertex pVertices) {
		vertex1 = pVertices;
	}

	@Override
	public void setAdjVertex2(IVertex pVertices) {
		vertex2 = pVertices;
	}

	@Override
	public IVertex getAdjVertex1() {
		return vertex1;
	}

	@Override
	public IVertex getAdjVertex2() {
		return vertex2;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int pWeight) {
		weight = pWeight;
	}

	@Override
	public String toString() {
		return ("" + vertex1 + "--" + weight + "--" + vertex2 + "");
	}


}
