package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph implements IGraph {
	Set<IEdge> allEdges = new HashSet<IEdge>();
	Set<IVertex> allVertices = new HashSet<IVertex>();

	@Override
	public Set<IEdge> getEdges() {
		return allEdges;
	}

	@Override
	public Set<IVertex> getVertices() {
		return allVertices;
	}

	@Override
	public void setEdges(Set<IEdge> pEdges) {
		allEdges = pEdges;
	}

	@Override
	public IVertex getVertexByID(char pID) {
		for (IVertex n : allVertices) {
			if (n.getId() == pID) {
				return n;
			}
		}
		return null;
	}

	@Override
	public void setVertices(Set<IVertex> pVertices) {
		allVertices = pVertices;

	}

	@Override
	public void addEdge(char pStart, char pEnd) {
		IEdge newEdge = new Edge();
		IVertex presetVertex1 = new Vertex(pStart);
		IVertex presetVertex2 = new Vertex(pEnd);

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
		allEdges.add(newEdge);
	}

	@Override
	public void addEdge(IEdge pEdge) {
		allEdges.add(pEdge);
	}

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

	@Override
	public void addVertex(char pId) {
		IVertex vertex = new Vertex(pId);
		addVertex(vertex);
	}

	@Override
	public void addVertex(IVertex pVertex) {
		allVertices.add(pVertex);
	}

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

	@Override
	public boolean isConnected() {
		return depthFirstSearch(allVertices.stream().findFirst().get()).size() == allVertices.size();
	}

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

	@Override
	public Stack<Character> depthFirstSearch(IVertex pVertex) {
		Stack<Character> st = new Stack<>();
		st.add(pVertex.getId());
		for (IEdge edge : pVertex.getAdjEdges()) {
			if (edge.getAdjVertex1().getId() == pVertex.getId()) {
				if (!st.contains(edge.getAdjVertex2().getId())) {
					st.add(edge.getAdjVertex2().getId());
				}
			} else if (edge.getAdjVertex2().getId() == pVertex.getId()) {
				if (!st.contains(edge.getAdjVertex1().getId())) {
					st.add(edge.getAdjVertex1().getId());
				}
			}
		}
		return st;
	}

	@Override
	public List<Character> getShortestPath(char startId, char endId) {
		boolean test = false;
		boolean testEnd = false;
		IVertex start = null;
		IVertex end= null;
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
			System.out.println("Action could not be completed, as either the specified entity or parameters do not exist.");
			return null;
		}
	}
	
	@Override
	public List<Character> getShortestPath(IVertex pVertex1, IVertex pVertex2) {
		shortestPath.clear();
		List<Character> travVertex = new ArrayList<>();
		recursive(travVertex, pVertex1,pVertex2);
//		System.out.println("shortest"+shortestPath);
		return shortestPath;
	}
	private static int count = 0;
	private List<Character> shortestPath = new LinkedList<>();
	public List<Character> recursive(List<Character> pTravVertex, IVertex current, IVertex pVertex2) {
		List<Character> travVertex = new LinkedList<>(pTravVertex);
		travVertex.add(current.getId());
		Character currentVert = travVertex.get(travVertex.size()-1);
		if (currentVert == pVertex2.getId()) {
			if (shortestPath.isEmpty()||shortestPath.size()>travVertex.size()) {
				shortestPath = travVertex;
			}
//			System.out.println("found path:"+travVertex);
			return travVertex;
		} else {
		
		Set<IVertex> adVerts = getAdjVertices(currentVert);
		for (IVertex vertex : adVerts) {
//			System.out.println("verts:"+travVertex);
//			System.out.println("currentEval:"+currentVert+ " friesn " + adVerts);
//			System.out.println(vertex+"if"+!travVertex.contains(vertex.getId()));
			if (!travVertex.contains(vertex.getId())) {
				
//				System.out.println(count++);
				recursive(travVertex, vertex,pVertex2);
				
			}

		}
		}
		return null;
	}

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
