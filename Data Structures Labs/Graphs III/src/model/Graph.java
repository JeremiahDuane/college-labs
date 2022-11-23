package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph implements IGraph {
//Initialization
	Set<IEdge> allEdges = new HashSet<IEdge>();
	Set<IVertex> allVertices = new HashSet<IVertex>();

//Get Edges
	@Override
	public Set<IEdge> getEdges() {
		return allEdges;
	}

//Get Vertices
	@Override
	public Set<IVertex> getVertices() {
		return allVertices;
	}

//Set Edges
	@Override
	public void setEdges(Set<IEdge> pEdges) {
		allEdges = pEdges;
	}

//Set Vertices
	@Override
	public void setVertices(Set<IVertex> pVertices) {
		allVertices = pVertices;

	}

//Get Vertex By ID
	@Override
	public IVertex getVertexByID(char pID) {
		for (IVertex n : allVertices) {
			if (n.getId() == pID) {
				return n;
			}
		}
		return null;
	}

//Add Edge 
	public void addEdge(char pStart, char pEnd, int pWeight) {
		IVertex presetVertex1 = new Vertex(pStart);
		IVertex presetVertex2 = new Vertex(pEnd);
		IEdge newEdge = new Edge(presetVertex1, presetVertex2);

		for (IVertex ver : allVertices) {
			if (ver.getId() == pStart) {
				presetVertex1 = ver;
			}
			if (ver.getId() == pEnd) {
				presetVertex2 = ver;
			}
		}

		newEdge.setAdjVertex1(presetVertex1);
		newEdge.setAdjVertex2(presetVertex2);
		presetVertex1.addEdge(newEdge);
		presetVertex2.addEdge(newEdge);
		allVertices.add(presetVertex1);
		allVertices.add(presetVertex2);
		addEdge(newEdge, pWeight);
	}

	@Override
	public void addEdge(IEdge pEdge, int pWeight) {
		StringBuilder sb = new StringBuilder();
		sb.append(pEdge.getAdjVertex1().getId());
		sb.append(pEdge.getAdjVertex2().getId());
		int num = 0;

		for (IEdge edge : allEdges) {
			num++;
		}
		sb.append(num);
		pEdge.setId(sb.toString());
		pEdge.setWeight(pWeight);

		allEdges.add(pEdge);
	}

//Add Vertex
	public void addVertex(char pId) {
		IVertex vertex = new Vertex(pId);
		addVertex(vertex);
	}

	@Override
	public void addVertex(IVertex pVertex) {
		allVertices.add(pVertex);
	}

//Remove Edge
	@Override
	public void removeEdge(char start, char end) {
		Set<IEdge> rEdges = new HashSet<>();
		for (IEdge edge : allEdges) {
			if (edge.getAdjVertex1().getId() == start && edge.getAdjVertex2().getId() == end) {
				rEdges.add(edge);
			} else if (edge.getAdjVertex2().getId() == end && edge.getAdjVertex2().getId() == start) {
				rEdges.add(edge);
			}
		}
		for (IEdge r : rEdges) {
			allEdges.remove(r);
		}
	}

//Remove Vertex
	@Override
	public void removeVertex(char pId) {
		Set<IVertex> verticesToRemove = new HashSet<IVertex>();
		Set<IEdge> edgesToRemove = new HashSet<IEdge>();

		for (IVertex n : allVertices) {
			if (n.getId() == pId) {
				verticesToRemove.add(n);
				for (IEdge edges : n.getAdjEdges()) {
					edgesToRemove.add(edges);
				}
			}
		}

		for (IVertex v : verticesToRemove) {
			allVertices.remove(v);
		}
		for (IEdge e : edgesToRemove) {
			allEdges.remove(e);
		}
	}

//Is Adjacent
	@Override
	public boolean isAdjacent(IVertex pVertex1, IVertex pVertex2) {
		for (IEdge edge : pRoutes(pVertex1)) {
			if (edge.getAdjVertex2() == pVertex2) {
				return true;
			}
		}

		return false;
	}

//Get Potential Route
	public List<IEdge> pRoutes(IVertex pVertex) {
		List<IEdge> routes = new LinkedList<IEdge>();
		for (IEdge edge : pVertex.getAdjEdges()) {
			if (edge.getAdjVertex1() == pVertex) {
				routes.add(edge);
			}
		}

		return routes;
	}

//Depth First Search
	public List<IVertex> depthFirstSearch() {
		if (getElement(0) != null) {
			return depthFirstSearch(getElement(0));
		} else {
			return null;
		}
	}

	@Override
	public List<IVertex> depthFirstSearch(char pId) {
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				return depthFirstSearch(vertex);
			}
		}
		return depthFirstSearch(new Vertex(pId));
	}

	@Override
	public List<IVertex> depthFirstSearch(IVertex pVertex) {
		dPath.clear();
		dPath.add(pVertex);
		return rDepthFirstSearch(pVertex);
	}

	private List<IVertex> dPath = new ArrayList<>();

	public List<IVertex> rDepthFirstSearch(IVertex pVertex) {
		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			List<IVertex> size = new ArrayList<>(dPath);
			if (!dPath.contains(vertex)) {
				dPath.add(vertex);
			}
			if (dPath.size() != size.size()) {
				rDepthFirstSearch(vertex);
			}
		}
		return dPath;
	}

	// Get Shortest Path
	@Override
	public List<IEdge> getShortestPath(char startId, char endId) {
		boolean test = false;
		boolean testEnd = false;
		IVertex start = null;
		IVertex end = null;
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == startId) {
				test = true;
				start = vertex;
			}
			if (vertex.getId() == endId) {
				testEnd = true;
				end = vertex;
			}
		}
		if (test && testEnd) {
			return getShortestPath(start, end);

		} else {
			System.out.println(
					"Action could not be completed, as either the specified entity or parameters do not exist.");
			return null;
		}
	}

	@Override
	public List<IEdge> getShortestPath(IVertex pVertex1, IVertex pVertex2) {
		shortestPath.clear();
		allPaths.clear();
		List<IEdge> path = new ArrayList<>();
		return recursive(path, pVertex1, pVertex2);

	}

	private List<IEdge> shortestPath = new LinkedList<>();
	private List<List<IEdge>> allPaths = new LinkedList<>();

	public List<IEdge> recursive(List<IEdge> pPath, IVertex current, IVertex pVertex2) {
		for (IEdge edge : pRoutes(current)) {
			List<IEdge> rPath = new LinkedList<>(pPath);
			if (!rPath.contains(edge)) {
				rPath.add(edge);
				if (edge.getAdjVertex2() == pVertex2) {
					allPaths.add(rPath);
				} else {
					recursive(rPath, edge.getAdjVertex2(), pVertex2);
				}
			}
		}
		for (List<IEdge> path : allPaths) {
			if (shortestPath.isEmpty() || getWeight(shortestPath) > getWeight(path)) {
				shortestPath = path;
			}
		}
		return shortestPath;
	}

	private int getWeight(List<IEdge> pList) {
		int weight = 0;
		for (IEdge edge : pList) {
			weight = weight + edge.getWeight();
		}
		return weight;
	}

//Adjacency Methods
	@Override
	public Set<IVertex> getAdjVertices(IVertex pVertex) {
		Set<IVertex> adjVertices = new HashSet<>();
		for (IEdge edge : pVertex.getAdjEdges()) {
			if (edge.getAdjVertex1() == pVertex) {
				adjVertices.add(edge.getAdjVertex2());
			} else if (edge.getAdjVertex2() == pVertex) {
				adjVertices.add(edge.getAdjVertex1());
			}
		}
		return adjVertices;
	}

	@Override
	public Set<IVertex> getAdjVertices(char pVertexId) {
		for (IVertex ver : allVertices) {
			if (ver.getId() == pVertexId) {
				return getAdjacentVertices(ver);
			}
		}
		return null;
	}

	@Override
	public HashSet<IVertex> getAdjacentVertices(IVertex pVertex) {
		HashSet<IVertex> returnSet = new HashSet<IVertex>();
		for (IEdge edges : pVertex.getAdjEdges()) {
			if (edges.getAdjVertex1() == pVertex) {
				returnSet.add(edges.getAdjVertex2());
			}
		}
		return returnSet;
	}

//Cycles and Graph Properties
	@Override
	public boolean isConnected() {
		return depthFirstSearch().size() == allVertices.size();
	}

	@Override
	public boolean isComplete() {
		for (IVertex vertex : allVertices) {
			Set<IVertex> verts = new HashSet<>(allVertices);
			verts.remove(vertex);
			for (IVertex vertex2 : verts) {
				if (!getAdjacentVertices(vertex).contains(vertex2)) {
					return false;
				}
			}

		}
		return true;
	}

//Breadth First Search
	public ArrayList<HashSet<IVertex>> breadthFirstSearch() {
		if (getElement(0) != null) {
			return breadthFirstSearch(getElement(0));
		} else {
			return null;
		}
	}

	public ArrayList<HashSet<IVertex>> breadthFirstSearch(char pId) {
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				return breadthFirstSearch(vertex);

			}
		}
		return breadthFirstSearch(new Vertex(pId));
	}

	@Override
	public ArrayList<HashSet<IVertex>> breadthFirstSearch(IVertex pVertex) {
		HashSet<IVertex> path = new HashSet<IVertex>();
		path.add(pVertex);
		searchResult.add(path);
		return rBreadthFirstSearch(pVertex);
	}

	ArrayList<HashSet<IVertex>> searchResult = new ArrayList<HashSet<IVertex>>();

	public ArrayList<HashSet<IVertex>> rBreadthFirstSearch(IVertex pVertex) {
		HashSet<IVertex> closed = new HashSet<IVertex>();
		HashSet<IVertex> toAdd = new HashSet<IVertex>();

		for (HashSet<IVertex> group : searchResult) {
			for (IVertex vertex : group) {
				closed.add(vertex);
			}
		}
		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			if (!closed.contains(vertex)) {
				toAdd.add(vertex);
			}
		}
		if (!toAdd.isEmpty()) {
			searchResult.add(toAdd);
		}
		for (IVertex vertex : toAdd) {
			rBreadthFirstSearch(vertex);
		}

		return searchResult;
	}

//EulerCycle
	public List<IEdge> strongEulerCycle() {
		if (getElement(0) != null) {
			return strongEulerCycle(getElement(0));
		} else {
			return null;
		}
	}

	@Override
	public List<IEdge> strongEulerCycle(char pId) {
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				return strongEulerCycle(vertex);
			}
		}
		return strongEulerCycle(new Vertex(pId));

	}

	@Override
	public List<IEdge> strongEulerCycle(IVertex pVertex1) {
		List<IEdge> path = new ArrayList<>();
		return rStrongEulerCycle(path, pVertex1, pVertex1);

	}

	public List<IEdge> rStrongEulerCycle(List<IEdge> pPath, IVertex current, IVertex pEnd) {
		for (IEdge edge : pRoutes(current)) {
			List<IEdge> rPath = new LinkedList<>(pPath);
			if (!rPath.contains(edge)) {
				rPath.add(edge);
				if (edge.getAdjVertex2() == pEnd) {
					if (rPath.size() == allEdges.size()) {
						return rPath;
					} else {
						return rStrongEulerCycle(rPath, edge.getAdjVertex2(), pEnd);
					}
				} else {
					return rStrongEulerCycle(rPath, edge.getAdjVertex2(), pEnd);
				}
			}
		}
		return null;
	}

//Has Euler Cycle
	@Override
	public boolean hasStrongEulerCycle() {
		for (IVertex vertex : allVertices) {
			int enter = 0;
			int exit = 0;
			for (IEdge edge : vertex.getAdjEdges()) {
				if (edge.getAdjVertex1() == vertex) {
					enter++;
				}
				if (edge.getAdjVertex2() == vertex) {
					exit++;
				}
			}
			if (enter == 0 && exit == 0) {

			} else if (exit == 0) {
				return false;
			} else {
				if (enter / exit != 1) {
					return false;
				}
			}
		}
		return true;
	}

//Get element of allVertices at a particular position 
	@Override
	public IVertex getElement(int pPosition) {
		List<IVertex> list = new ArrayList<IVertex>();
		list.addAll(allVertices);
		if (!list.isEmpty()) {
			return list.get(pPosition);
		}
		return null;
	}

//Hamiltonian Cycle
	public List<IEdge> hamiltonianCycle() {
		n=1;

		if (getElement(0) != null) {
			return hamiltonianCycle(getElement(0));
		} else {
			return null;
		}
	}

	public List<IEdge> hamiltonianCycle(char pId) {
		n=1;

		IVertex start = new Vertex(pId);
		IVertex end = new Vertex(pId);
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				start = vertex;
			}
			if (vertex.getId() == pId) {
				end = vertex;
			}
		}

		hPath.clear();
		allH.clear();
		List<IEdge> path = new ArrayList<>();
		return rHam(path, start, end);
	}

	@Override
	public List<IEdge> hamiltonianCycle(IVertex pVertex1) {		
		n=1;
		hPath.clear();
		List<IEdge> path = new ArrayList<>();
		return rHam(path, pVertex1, pVertex1);

	}


	// Hamiltonian Path
	public List<IEdge> hamiltonianPath(char pId, char pId2) {
		IVertex start = new Vertex(pId);
		IVertex end = new Vertex(pId2);
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				start = vertex;
			}
			if (vertex.getId() == pId2) {
				end = vertex;
			}
		}
		return hamiltonianPath(start, end);
	}

	@Override
	public List<IEdge> hamiltonianPath(IVertex pVertex1, IVertex pVertex2) {
		n = 0;
		hPath.clear();
		allH.clear();
		List<IEdge> path = new ArrayList<>();
		return rHam(path, pVertex1, pVertex2);

	}

	private List<IEdge> hPath = new LinkedList<>();
	private List<List<IEdge>> allH = new LinkedList<>();

	public List<IEdge> rHam(List<IEdge> pPath, IVertex current, IVertex pVertex2) {
		for (IEdge edge : pRoutes(current)) {
			List<IEdge> rPath = new LinkedList<>(pPath);
			if (!rPath.contains(edge)) {
				
				rPath.add(edge);
				if (edge.getAdjVertex2() == pVertex2) {
					allH.add(rPath);
					
				} else {
					rHam(rPath, edge.getAdjVertex2(), pVertex2);
				}
			}
		}
		for (List<IEdge> path : allH) {
			if (containsAllVertices(path)) {
				if (hPath.isEmpty() || getWeight(hPath) > getWeight(path)) {
					hPath = path;
				}
			}
		}
		return hPath;
	}

	private int n = 0;
	private boolean containsAllVertices(List<IEdge> pList) {
		List<IVertex> containedVertices = new LinkedList<>();
		containedVertices.add(pList.get(0).getAdjVertex1());
		for (IEdge edge : pList) {
				containedVertices.add(edge.getAdjVertex2());			
		}

		HashSet<IVertex> dupes = new HashSet<>(containedVertices);
		if (containedVertices.containsAll(allVertices)) {
			if ((dupes.size()  + n )== containedVertices.size()) {
			return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

//ToString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices: ");
		for (IVertex ver : allVertices) {
			sb.append(ver.toString());
		}
		sb.append("\nEdges: ");
		for (IEdge edge : allEdges) {
			sb.append(edge.toString() + ", ");
		}
		return sb.toString();
	}

}
