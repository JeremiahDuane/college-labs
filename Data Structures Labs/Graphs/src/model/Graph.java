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
	@Override
	public void addEdge(char pStart, char pEnd) {
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
		addEdge(newEdge);
	}

	@Override
	public void addEdge(IEdge pEdge) {
		StringBuilder sb = new StringBuilder();
		sb.append(pEdge.getAdjVertex1().getId());
		sb.append(pEdge.getAdjVertex2().getId());
		int num = 0;

		for (IEdge edge : allEdges) {
			num++;
		}
		sb.append(num);
		pEdge.setId(sb.toString());
		allEdges.add(pEdge);
	}

//Add Vertex
	@Override
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
		for (IEdge v1 : pVertex1.getAdjEdges()) {
			for (IEdge v2 : pVertex2.getAdjEdges()) {
				if (v1 == v2) {
					return true;
				}
			}
		}

		return false;
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

//Get Shortest Path
	@Override
	public List<Character> getShortestPath(char startId, char endId) {
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
	public List<Character> getShortestPath(IVertex pVertex1, IVertex pVertex2) {
		shortestPath.clear();
		List<Character> travVertex = new ArrayList<>();
		recursive(travVertex, pVertex1, pVertex2);
		return shortestPath;
	}

	private List<Character> shortestPath = new LinkedList<>();

	public List<Character> recursive(List<Character> pTravVertex, IVertex current, IVertex pVertex2) {
		List<Character> travVertex = new LinkedList<>(pTravVertex);
		travVertex.add(current.getId());
		Character currentVert = travVertex.get(travVertex.size() - 1);
		if (currentVert == pVertex2.getId()) {
			if (shortestPath.isEmpty() || shortestPath.size() > travVertex.size()) {
				shortestPath = travVertex;
			}
			return travVertex;
		} else {
			Set<IVertex> adVerts = getAdjVertices(currentVert);
			for (IVertex vertex : adVerts) {
				if (!travVertex.contains(vertex.getId())) {
					recursive(travVertex, vertex, pVertex2);

				}

			}
		}
		return null;
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
	public Set<IVertex> getAdjacentVertices(IVertex pVertex) {
		Set<IVertex> returnSet = new HashSet<IVertex>();
		for (IEdge edges : pVertex.getAdjEdges()) {
			if (edges.getAdjVertex1() == pVertex) {
				returnSet.add(edges.getAdjVertex2());
			} else if (edges.getAdjVertex2() == pVertex) {
				returnSet.add(edges.getAdjVertex1());

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
		return rBreadthFirstSearch(pVertex, path);
	}

	ArrayList<HashSet<IVertex>> dual = new ArrayList<HashSet<IVertex>>();

	public ArrayList<HashSet<IVertex>> rBreadthFirstSearch(IVertex pVertex, HashSet<IVertex> pPath) {
		HashSet<IVertex> group = new HashSet<IVertex>();
		HashSet<IVertex> size = new HashSet<IVertex>(pPath);
		if (!pPath.contains(pVertex)) {
			HashSet<IVertex> init = new HashSet<IVertex>();
			pPath.add(pVertex);
			init.add(pVertex);
			dual.add(init);
		}
		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			if (!pPath.contains(vertex)) {
				pPath.add(vertex);
				group.add(vertex);
			}
		}
		if (group.size() != 0) {
			dual.add(group);
		}
		if (pPath.size() != size.size()) {
			for (IVertex vertex : group) {
				rBreadthFirstSearch(vertex, pPath);
			}
		}

		return dual;
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
	public List<IEdge> strongEulerCycle(IVertex pVertex) {
		List<IEdge> path = new ArrayList<IEdge>();
		List<String> ids = new ArrayList<String>();
		return rEulerCycle(pVertex, path, ids);
	}

	private List<IEdge> rEulerCycle(IVertex pVertex, List<IEdge> pPath, List<String> pIds) {
		if (pVertex != null) {
			for (IEdge edge : pVertex.getAdjEdges()) {
				if (!pIds.contains(edge.getId())) {
					List<IEdge> rPath = new ArrayList<IEdge>(pPath);
					List<String> rIds = new ArrayList<String>(pIds);

					if (!rIds.contains(edge.getId())) {
						rPath.add(edge);
						rIds.add(edge.getId());

						if ((getOtherVertex(pVertex, edge) == rPath.get(0).getAdjVertex1())) {

							if (rPath.size() == allEdges.size()) {
								return rPath;
							} else {
								return rEulerCycle(getOtherVertex(pVertex, edge), rPath, rIds);
							}
						} else {
							return rEulerCycle(getOtherVertex(pVertex, edge), rPath, rIds);
						}
					}
				}
			}
		}
		return null;
	}
//Get adjacent vertex along an edge. 

	private IVertex getOtherVertex(IVertex pVertex, IEdge edge) {
		if (edge.getAdjVertex1().getId() == pVertex.getId()) {
			return edge.getAdjVertex2();
		} else {
			return edge.getAdjVertex1();
		}
	}

//Has Euler Cycle
	@Override
	public boolean hasStrongEulerCycle() {
		for (IVertex vertex : allVertices) {
			int numberOfEdges = 0;
			for (IEdge edge : vertex.getAdjEdges()) {
				if (edge.getAdjVertex1() == edge.getAdjVertex2()) {
					numberOfEdges+=2;
				} else {
					numberOfEdges++;
				}
			}
			if (numberOfEdges % 2 != 0) {
				return false;
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
	public List<IVertex> hamiltonianCycle() {
		if (getElement(0) != null) {
			return hamiltonianCycle(getElement(0));
		} else {
			return null;
		}
	}

	public List<IVertex> hamiltonianCycle(char pId) {
		for (IVertex vertex : allVertices) {
			if (vertex.getId() == pId) {
				return hamiltonianCycle(vertex);
			}
		}
		return hamiltonianCycle(new Vertex(pId));
	}

	@Override
	public List<IVertex> hamiltonianCycle(IVertex pVertex) {
		ArrayList<IVertex> path = new ArrayList<IVertex>();
		if (rHamiltonianCycle(pVertex, pVertex, path) != null) {
			ArrayList<IVertex> cycle = new ArrayList<IVertex>(rHamiltonianCycle(pVertex, pVertex, path));
			cycle.add(pVertex);
			return cycle;
		} else {
			return null;
		}
	}

	public List<IVertex> rHamiltonianCycle(IVertex pVertex, IVertex pVertex2, ArrayList<IVertex> pPath) {
		if (!pPath.contains(pVertex)) {
			pPath.add(pVertex);
		}
		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			ArrayList<IVertex> rPath = new ArrayList<IVertex>(pPath);
			if (!rPath.contains(vertex)) {
				rPath.add(vertex);
			}
			if (rPath.size() != pPath.size()) {
				if (rPath.size() == allVertices.size()) {
					if (isAdjacent(vertex, pVertex2)) {
						return rPath;
					} else {
						return null;
					}
				} else {
					return rHamiltonianCycle(vertex, pVertex2, rPath);
				}
			}
		}

		return null;
	}

	// Hamiltonian Path
	public List<IVertex> hamiltonianPath(char pId, char pId2) {
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

	public List<IVertex> hamiltonianPath(IVertex pVertex, IVertex pVertexEnd) {
		ArrayList<IVertex> path = new ArrayList<IVertex>();
		if (rHamiltonianPath(pVertex, pVertexEnd, path) != null) {
			ArrayList<IVertex> cycle = new ArrayList<IVertex>(rHamiltonianPath(pVertex, pVertexEnd, path));
			cycle.add(pVertexEnd);
			return cycle;
		} else {
			return null;
		}
	}

	public List<IVertex> rHamiltonianPath(IVertex pVertex, IVertex pVertexEnd, ArrayList<IVertex> pPath) {
		if (!pPath.contains(pVertex)) {
			pPath.add(pVertex);
		}
		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			ArrayList<IVertex> rPath = new ArrayList<IVertex>(pPath);
			if (!rPath.contains(vertex)) {
				if (vertex.getId() != pVertexEnd.getId()) {
					rPath.add(vertex);
				}
			}
			if (rPath.size() != pPath.size()) {
				if (rPath.size() == allVertices.size()) {
					if (isAdjacent(vertex, pVertexEnd)) {
						return rPath;
					} else {
						return null;
					}
				} else {
					return rHamiltonianPath(vertex, pVertexEnd, rPath);
				}
			}
		}
		return null;

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

	@Override
	public Stack<Character> recurDepth(IVertex pVertex) {
		// TODO Auto-generated method stub
		return null;
	}

}
