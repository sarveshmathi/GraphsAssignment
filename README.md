# GraphsAssignment

In this assignment, we modified a custom Java graph implementation and wrote methods used for analyzing the graph.

For complete details on this project refer to **Module-8-Programming-Assignment.pdf**.

**Learning Objectives**

* Become more familiar with the “adjacency list” representation of a graph
* Apply what you have learned about how to traverse a graph
* Demonstrate that you can use graphs to solve common problems in Computer Science

Methods implemented: 

**minDistance:** Given a Graph, this method returns the shortest distance (in terms of number of edges) from the 
node labeled src to the node labeled dest. The method should return -1 for any invalid inputs, 
including: null values for the Graph, src, or dest; there is no node labeled src or dest in the graph; 
there is no path from src to dest. Keep in mind that this method does not just 
return the distance of any path from src to dest, it must be the shortest path.

**nodesWithinDistance:** Given a Graph, this method returns a Set of the values of all nodes within the specified 
distance (in terms of number of edges) of the node labeled src, i.e. for which the minimum number of edges from src
to that node is less than or equal to the specified distance. The value of the node itself should not 
be in the Set, even if there is an edge from the node to itself. The method should return null for any invalid inputs, 
including: null values for the Graph or src; there is no node labeled ​src​ in the graph; distance less than 1. 
However, if distance is greater than or equal to 1 and there are no nodes within that distance (meaning: src is the only node in the graph), 
the method should return an empty Set.

**isHamiltonianCycle:** Given a Graph, this method indicates whether the List of node values represents a Hamiltonian Cycle. 
A Hamiltonian Cycle is a valid path through the graph in which every node in the graph is visited exactly once, except for the 
start and end nodes, which are the same, so that it is a cycle. If the values in the input List represent a Hamiltonian Cycle given 
the order in which they appear in the List, the method should return true, but the method should return false otherwise, 
e.g. if the path is not a cycle, if some nodes are not visited, if some nodes are visited more than once, if some values do not 
have corresponding nodes in the graph, if the input is not a valid path (i.e., there is a sequence of nodes in the 
List that are not connected by an edge), etc. The method should also return false if the input Graph or List is null.
