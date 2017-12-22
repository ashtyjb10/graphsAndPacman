package assignment09;

/**
 * Node class will be utilized in the maze and PathFinder in order to specify
 * which positions have be visited, and which are blockaded. Furthermore,
 * utilizing nodes will allow the pacman to move backwards during the PathFinder
 * process to find and mark the shortest path to the Goal Node.
 * 
 * @author Gabrielle Hoyer and Ashton Schmidt
 *
 */
public class Node {
	int id;
	int row;
	int col;
	Node[] neighbors = new Node[4];
	int parent;
	char data;
	boolean visited;



	Node(int id) 
	{
		this.id = id;

	}


	/**
	 * boolean flag that changes if a node has been visited
	 */
	public void isVisited() 
	{
		visited = true;

	}
}
