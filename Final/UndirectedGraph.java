import java.util.Iterator;
/**
   A class that implements the ADT undirected graph.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T>
{
	public UndirectedGraph()
	{
		super();
	} // end default constructor
	
	public boolean addEdge(T begin, T end, double edgeWeight)
	{
		return super.addEdge(begin, end, edgeWeight) &&
             super.addEdge(end, begin, edgeWeight);
	  // Assertion: edge count is twice its correct value due to calling addEdge twice
	} // end addEdge
	
	public boolean addEdge(T begin, T end)
	{
		return this.addEdge(begin, end, 0);
	} // end addEdge
	
	public int getNumberOfEdges()
	{
		return super.getNumberOfEdges() / 2;
	} // end getNumberOfEdges

	public boolean removeEdge(T begin, T end)
	{
		return this.removeEdge(begin, end, 0);
	}

	//call remove method from directed graph 
	public boolean removeEdge(T begin, T end, double edgeWeight)
	{
		return super.removeEdge(begin, end, edgeWeight) &&
			super.removeEdge(end, begin, edgeWeight);
	}

	public StackInterface<T> getTopologicalOrder() 
	{
		throw new UnsupportedOperationException("Topological sort illegal in an undirected graph.");		
	} // end getTopologicalOrder

	public boolean removeVertex(T vertexLabel)
	{
		return super.removeVertex(vertexLabel);
	}

} // end UndirectedGraph

// To make addEdge more efficient, DirectedGraph needs to provide accessors 
// to its data fields. (See Project 3, Chapter 29.)