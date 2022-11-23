package ui;

import java.util.HashSet;
import java.util.Set;

import model.Graph;
import model.IEdge;
import model.Vertex;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();

		g.addEdge('a', 'b');
		g.addEdge('c', 'a');
		g.addEdge('b', 'c');
				
		
	
		

		
		System.out.println("H-Path: " + g.hamiltonianPath('a', 'a'));
		System.out.println("H-Cycle: " + g.hamiltonianCycle());
		System.out.println("Has Euler-Cycle: " + g.hasStrongEulerCycle());
		System.out.println("Euler-Cycle: " + g.strongEulerCycle());
		System.out.println("BreadthFirstSearch: " + g.breadthFirstSearch());
		System.out.println("DepthFirstSearch: " + g.depthFirstSearch());
		System.out.println("IsComplete: " + g.isComplete());
		System.out.println("IsConnected: " + g.isConnected());




		


		

	}

}
