package model;

import java.util.Set;

public interface IEdge {
	Set<IVertex> getAdjVertices();
	void setAdjVertex1(IVertex pVertices);
	void setAdjVertex2(IVertex pVertices);

	IVertex getAdjVertex1();
	IVertex getAdjVertex2();

	int getWeight();
	void setWeight(int pWeight);
	String getId();
	void setId(String pId);

	

}
