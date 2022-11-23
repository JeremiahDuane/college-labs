package ui;

import java.util.HashSet;
import java.util.Set;

import model.Graph;
import model.IEdge;
import model.Vertex;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex('b');
		g.addVertex('a');
		g.removeEdge('a', 'b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		g.addVertex('f');
		g.addEdge('b', 'a');
		g.addEdge('a', 'f');
		g.addEdge('b', 'c');
		g.addEdge('c', 'd');
		g.addEdge('a', 'c');
		g.addEdge('b', 'd');
		g.addEdge('b', 'e');
		g.addEdge('e', 'f');
		
System.out.println("Shortest Path: " + g.getShortestPath('a', 'f'));
System.out.println(g.isConnected());
System.out.println(g);


	}

}
