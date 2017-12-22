package assignment09;

import java.util.ArrayDeque;

/**
 * Graph and the graph data structure is used by PathFinder to find the shortest
 * path of a maze. This class includes methods to define the maze matrix as a 1D
 * and 2D array. Additionally, there is a method to define all possible
 * neighbors of a certain position in the maze
 * 
 * @author Gabrielle Hoyer and Ashton Schmidt
 *
 */
public class Graph {
	Node startNode;
	 Node goalNode;
	int height;
	int width;
	char[][] matrix;
	Node[][] nodeMatrix = makeNodeMatrix(matrix);
	Node[] oneD = new Node[height * width];
	int counter;


	ArrayDeque<Node> arrDeq;

	public Graph(char[][] matrix, int height, int width) 
	{
		this.height = height;
		this.width = width;
		this.matrix = matrix;
	}

	/**
	 * This method defines the maze positions in terms of row and column. The
	 * number of rows is defined by height, while the number of columns is
	 * defined by width. Thus making the same matrix but containing new nodes
	 * that can be accessed throughout the class so that you can replace the path
	 * backwards.
	 * 
	 * @param charMatrix
	 * @return Node[][] 2D array of maze positions
	 */
	public Node[][] makeNodeMatrix(char[][] charMatrix)
	{
		Node[][] nodeMatrix = new Node[height][width];
		int counter = 0;
		for (int row = 0; row < height; row++) 
		{
			for (int col = 0; col < width; col++) 
			{
				nodeMatrix[row][col] = new Node(counter);
				nodeMatrix[row][col].data = matrix[row][col];
				counter++;
			}
		}
		return nodeMatrix;
	}
	
	
	/**
	 * This method takes in the goal node so that we know when we reach the end.
	 * We create a queue that adds the starting node and then removes it and
	 * makes it the current node so that we can check its neighbors. If the current node
	 * is the goal node then we work backwards and place a "." in the path. If current
	 * is not the goal then it checks the neighbors for a path to go, and adds the neighbors
	 * to the queue, as well as sets the neighbors' parents to the current node. 
	 * 
	 * @param goal_node_id , oneD [] 
	 * @param oneD
	 */

	public void bfs(int goal_node_id, Node[] oneD) 
	{

		arrDeq = new ArrayDeque<Node>();
		Node currNode = startNode;
		arrDeq.offer(currNode);		//add

		while (!arrDeq.isEmpty()) 
		{ // process each vertex
			 currNode = arrDeq.poll(); //remove
			 
			 if (currNode == goalNode) //if the current node is the goal node we want to go back.
				{
					
					while(oneD[currNode.parent]!= startNode)
					{
						currNode = oneD[currNode.parent]; 
						matrix[currNode.row][currNode.col] = '.'; //sets the backward path as a .
					}

					break;

				}

			for (int index = 0; index < oneD.length; index++) 
			{
				if (!currNode.visited) 
				{ 
					currNode.isVisited(); //makes the node visited boolean true
					counter++;
					
					if(currNode.neighbors[0] != null) //if its not an X
					{
						if(currNode.neighbors[0].parent == 0) //if there has been no parent set before.
						{
						currNode.neighbors[0].parent = currNode.id; //sets the neighbor nodes parent to the current id
						arrDeq.offer(currNode.neighbors[0]);
						}
					}
					if(currNode.neighbors[1] != null) //if its not an X
					{
						if(currNode.neighbors[1].parent == 0) //if there has been no parent set before.
						{
						currNode.neighbors[1].parent = currNode.id; //sets the neighbor nodes parent to the current id
						arrDeq.offer(currNode.neighbors[1]);
						}

					}
					if(currNode.neighbors[2] != null) //if its not an X
					{
						if(currNode.neighbors[2].parent == 0) //if there has been no parent set before.
						{
						currNode.neighbors[2].parent = currNode.id; //sets the neighbor nodes parent to the current id
						arrDeq.offer(currNode.neighbors[2]);
						}

					}
					if(currNode.neighbors[3] != null ) //if its not an X
					{
						if(currNode.neighbors[3].parent == 0) //if there has been no parent set before.
						{
						currNode.neighbors[3].parent = currNode.id; //sets the neighbor nodes parent to the current id
						arrDeq.offer(currNode.neighbors[3]);
						}
					}
					
				}

			}


		}


	}

	/**
	 * This method distinguishes neighbors from blockades in the maze, and
	 * specifies/comments the neighbors as from the north, south, west, or east,
	 * accordingly for the user
	 * 
	 * @param oneD
	 */
	public void createNeighbors(Node[] oneD) 
	{
		for (int indexOfOneD = 0; indexOfOneD < oneD.length; indexOfOneD++) 
		{
			int row = oneD[indexOfOneD].row;
			int col = oneD[indexOfOneD].col;
			if (row > 0 && row < height-1 && col > 0 && col < width-1) //as long as they are not the edges
			{

				// north
				if (matrix[row - 1][col] != 'X') 
				{
					
					Node temp = nodeMatrix[row - 1][col]; //creates a temp node from the node matrix
					oneD[indexOfOneD].neighbors[0]= temp; 

				}
				// south
				if (matrix[row + 1][col] != 'X') 
				{
					Node temp = nodeMatrix[row + 1][col];//creates a temp node from the node matrix
					oneD[indexOfOneD].neighbors[1] = temp;
				}
				// east
			

				if (matrix[row][col + 1] != 'X' && col < width) 
				{
					Node temp = nodeMatrix[row][col + 1];//creates a temp node from the node matrix
					oneD[indexOfOneD].neighbors[2] = temp;
				}
				// west
				if (matrix[row][col - 1] != 'X') 
				{
					Node temp = nodeMatrix[row][col-1];//creates a temp node from the node matrix
					oneD[indexOfOneD].neighbors[3] = temp;
				}
			}

		}
	
	}

	/**
	 * This method takes a 2D array, previously defined by row and column, and
	 * makes it into a 1D array for future use. Additionally, it specifies the
	 * placement of the starting and goal nodes in the maze.
	 * 
	 * @return Node[]
	 */
	public Node[] make1D() 
	{
		Node[] oneD = new Node[height * width];
		int counter = 0; //used for the array to keep track of the index
		nodeMatrix = makeNodeMatrix(matrix);
		for (int row = 0; row < height; row++) 
		{
			for (int col = 0; col < width; col++) 
			{
				
				oneD[counter] = nodeMatrix[row][col]; //initializes all nodes
				oneD[counter].row = row; //sets the position of row for the node so that it can be accessed later
				oneD[counter].col = col; //sets the position of col for the node so that it can be accessed later
				


				if (matrix[row][col] == 'S') 
				{
					startNode = nodeMatrix[row][col]; 

				}
				if (matrix[row][col] == 'G') 
				{
					goalNode = nodeMatrix[row][col];

				}
				counter++;

			}
		}
		return oneD;
	}
}
