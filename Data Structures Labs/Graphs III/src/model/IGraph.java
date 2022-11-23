package model;

 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

 

/**

* The properties and methods associated with a graph.

*/

public interface IGraph {

               IVertex getVertexByID(char pID);

 

               /**

               *

                * @return The edges contained in the graph.

               */

               Set<IEdge> getEdges();

 

               /**

               * Sets the edges affiliated with this graph.

               *

                * @param pEdges

               *            The list of edges to add.

               * @see addEdge for a more granular approach. Edges should generally be set

               *      through that function

               */

               void setEdges(Set<IEdge> pEdges);

 

               /**

               *

                * @return The list of vertices in this graph.

               */

               Set<IVertex> getVertices();

 

               /**

               * Sets the vertices in this graph.

               *

                * @param pVertices

               *            The list of edges to add.

               * @see addVertex for a more granular approach. Vertices should generally be

               *      set through that function

               */

               void setVertices(Set<IVertex> pVertices);

 

               /**

               * Adds an edge to the graph.

               *

                * @param pEdge

               *            The edge to add to the graph.

               */

               void addEdge(IEdge pEdge, int pWeight);

 

               /**

               * Removes an edge from the graph.

               *

                * @param pIndex

               *            The index of the edge to remove from the graph.

               */

               void removeEdge(char start, char end);

 

               /**

               * Adds a vertex to the graph.

               *

                * @param pVertex

               *            The vertex to add to the graph.

               */

               void addVertex(IVertex pVertex);

 

               /**

               * Removes a vertex from the graph.

               *

                * @param pIndex

               *            The index of the vertex to remove from the graph.

               */

               void removeVertex(char pId);

 

               /**

               *

                * @return True if the graph is a connected graph.

               */

               boolean isConnected();

 

               /**

               *

                * @param pVertex1

               *            The first vertex.

               * @param pVertex2

               *            The second vertex.

               * @return True if the two vertices are adjacent.

               */

               boolean isAdjacent(IVertex pVertex1, IVertex pVertex2);

 

               /**

               * Finds the shortest path between vertices. In the case of duplicate short

               * paths, will pick one at random.

               *

                 * @param pVertex1

               *            The first vertex.

               * @param pVertex2

               *            The second vertex.

               * @return A character array of the ids of the vertices in the shortest

               *         path.

               */

               List<IEdge> getShortestPath(IVertex pVertex1, IVertex pVertex2);

 

               /**

               * Show a list of the ids of all adjacent vertices.

               *

                * @param pVertex

               *            The vertex id of which to show all adjacent vertices.

               * @return A character array of the ids of the vertices that are adjacent.

               */

               Set<IVertex> getAdjacentVertices(IVertex pVertex);

           	/**
           	 * Depth First Search of the given graph.
           	 * 
           	 * @return Returns an array of vertices representing the path taken during
           	 *         the search.
           	 */
           	List<IVertex> depthFirstSearch(IVertex pVertex);

           	/**
           	 * Breadth First Search of the given graph.
           	 * 
           	 * @return Returns an array of vertices representing the path taken during
           	 *         the search.
           	 */
			ArrayList<HashSet<IVertex>> breadthFirstSearch(IVertex pVertex);

           	/**
           	 * A Hamiltonian cycle visits each vertex in the graph once except the
           	 * starting vertex, which is visited twice.
           	 * 
           	 * @param pVertex
           	 *            The vertex on which to start/end the cycle.
           	 * @return Returns an array of vertices representing the path taken during
           	 *         the search.
           	 */
           	default List<IEdge> hamiltonianCycle(IVertex pVertex) {
           		throw new UnsupportedOperationException("Implement me for 10 bonus points");
           	}

           	/**
           	 * A Hamiltonian path visits each vertex in the graph once.
           	 * 
           	 * @param pVertex1
           	 *            The vertex on which to start the path
           	 * @param pVertex2
           	 *            The vertex on which to end the path
           	 * @return Returns an array of the path if it exists. Otherwise returns an
           	 *         array of size zero.
           	 */
           	 List<IEdge> hamiltonianPath(IVertex pVertex, IVertex pVertexEnd);
           	

           	/**
           	 * An Euler cycle traverses each edge in the graph once. In the case of this
           	 * function, we denote a strong Euler cycle to require a graph be connected.
           	 * 
           	 * @param pVertex
           	 *            The vertex on which to start/end the cycle.
           	 * @return Returns an array of the cycle if it exists. Otherwise returns an
           	 *         array of size zero.
           	 */
           	List<IEdge> strongEulerCycle(IVertex pVertex);

           	/**
           	 * An Euler cycle traverses each edge in the graph once. In the case of this
           	 * function, we denote a strong Euler cycle to require a graph be connected.
           	 * 
           	 * @return Returns true if the graph is connected and an Euler Cycle exists.
           	 * 
           	 */
  
           	/**
           	 * Is the graph complete.
           	 * 
           	 * @return Returns true if the graph is complete. To show a graph is
           	 *         complete, choose any two vertices--an edge will exist between
           	 *         them.
           	 */
           	boolean isComplete();


			Set<IVertex> getAdjVertices(char pVertexId);



			Set<IVertex> getAdjVertices(IVertex pVertex);



			List<IEdge> getShortestPath(char startId, char endId);


			List<IVertex> depthFirstSearch(char pId);


			List<IEdge> strongEulerCycle(char pId);



			boolean hasStrongEulerCycle();



			IVertex getElement(int pPosition);



			







}