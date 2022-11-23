package model;

import java.util.Set;

public interface IVertex {
	char getId();
	void setId(final char pId);

	Set<IEdge> getAdjEdges();
	void addEdge(final IEdge pEdgeToAdd);
	IEdge removeEdge(final IEdge pEdgeToRemove);
	int getNumberOfAdjEdges();
	
}
