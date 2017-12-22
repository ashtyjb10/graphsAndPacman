package assignment09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * PathFinder class utilizes graph and graph pathfinding in order to solve 
 * the shortest path for a given maze in Pacman, and return answer in a 
 * text file.
 * @author Ashton Schmidt and Gabrielle Hoyer
 *
 */
public class PathFinder 
{
	static int height;
	static int width;
	
	/**
	 * This method will read in a maze text file find the shortest path
	 * and return the solved maze in an output file
	 * @param inputFileName must retain the directory and name given 
	 * @param outputFileName
	 */
	public static void solveMaze(String inputFileName, String outputFileName) 
	{
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(inputFileName)));
			String [] dimention = br.readLine().split(" ");
			height = Integer.parseInt(dimention[0]);
			width = Integer.parseInt(dimention[1]);
			
			String line;
			
			int counter_height = 0;
			char[][] matrix = new char [height][width];
			
			while (counter_height < height && (line = br.readLine()) != null)
			{
				char[] rows = line.toCharArray();

					for(int col = 0; col < width; col++)
					{
						matrix[counter_height][col] = rows[col]; //makes the matrix of all the chars
						
					}

				counter_height++;

			}
			Graph graph = new Graph(matrix, height, width); //creates the new graph 
			Node[] oneD = graph.make1D(); //makes the matrix in to an array of nodes
			graph.createNeighbors(oneD); //adds the neighbors to the node
			 graph.bfs(graph.goalNode.id,oneD); //does the breath first search
			 System.out.print(graph.counter+ "\n");
			 
			 //create a string for each row in graph.matrix
			 try(PrintWriter output = new PrintWriter(new FileWriter(outputFileName)))
				{
				 	output.println(height+ " "+ width);
				 	output.print(matrixToString(graph.matrix)); //gets the graph matrix which has the correct path
				 	output.close();
				}
			 br.close();
			
		
			
		
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found...");
		} 
		catch (IOException e) 
		{
			System.out.println("Oh no!");
		}
		
		
	}

	/**
	 * 
	 * Makes a string of the matrix that is passed
	 * into the method so that we can print it out 
	 * in the text file.
	 * @param matrix
	 * @return string of matrix 
	 */
		
	public static String matrixToString (char[][] matrix)
	{
		String  result = "";
		for(int index = 0; index < height; index++)
		{
			for(int index2 = 0; index2 < width; index2++)
			{
				result += matrix[index][index2];
			}
			result += "\n"; //makes it look like the matrix for the text
		}
		
		return result;
	}
		

}
