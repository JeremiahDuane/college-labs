package ui;

import java.util.HashSet;
import java.util.Set;

import model.Graph;
import model.IEdge;
import model.Vertex;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge('a', 'b', 1);
		g.addEdge('c', 'a', 4);
		g.addEdge('b', 'c', 1);
		g.addEdge('a', 'b', 1);
		g.addEdge('c', 'a', 1);
		g.addEdge('c', 'd', 1);
		g.addEdge('d', 'e', 1);


		


		System.out.println("BreadthFirstSearch: " +g.breadthFirstSearch());
		System.out.println("DepthFirstSearch: " +g.depthFirstSearch());
		System.out.println("GetShortestPath :" +g.getShortestPath('a', 'c'));
		System.out.println("Hamiltonian :" +g.hamiltonianCycle());
		System.out.println("HamiltonianPath :" +g.hamiltonianPath('a', 'd'));
		System.out.println("Euler :" +g.strongEulerCycle());
		System.out.println("hasEuler: " + g.hasStrongEulerCycle());





		


		

	}

}
