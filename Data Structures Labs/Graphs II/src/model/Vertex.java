package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Vertex implements IVertex {
	private char id;
	private Set<IEdge> edges = new HashSet<>();

	private boolean connected;

	public Vertex(char id) {
		super();
		this.id = id;
	}

	@Override
	public char getId() {
		return id;
	}

	@Override
	public void setId(char pId) {
		id = pId;
	}

	@Override
	public Set<IEdge> getAdjEdges() {
		return edges;
	}
	
	@Override
	public void addEdge(IEdge pEdgeToAdd) {
		edges.add(pEdgeToAdd);
	}

	@Override
	public IEdge removeEdge(IEdge pEdgeToRemove) {
		if (edges.contains(pEdgeToRemove)) {
		edges.remove(pEdgeToRemove);
		return pEdgeToRemove;
		} else {
			return null;
		}
	}

	@Override
	public int getNumberOfAdjEdges() {
		return edges.size();
	}

	@Override
	public String toString() {
		return "(" + id + ")" ;
	}
}
