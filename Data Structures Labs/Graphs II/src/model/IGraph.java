package model;

 

import java.util.List;
import java.util.Set;

 

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

               void addEdge(IEdge pEdge);

 

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

               List<Character> getShortestPath(IVertex pVertex1, IVertex pVertex2);

 

               /**

               * Show a list of the ids of all adjacent vertices.

               *

                * @param pVertex

               *            The vertex id of which to show all adjacent vertices.

               * @return A character array of the ids of the vertices that are adjacent.

               */

               Set<IVertex> getAdjacentVertices(IVertex pVertex);



			void addEdge(char start, char end);



			void addVertex(char pId);


			List<Character> depthFirstSearch(IVertex pVertex);



			Set<IVertex> getAdjVertices(char pVertexId);



			Set<IVertex> getAdjVertices(IVertex pVertex);



			List<Character> getShortestPath(char startId, char endId);

 

}