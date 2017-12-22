package assignment09;

/**
 * This class allows the user to choose a maze file to input to the program,
 * as well as an output file that will print out the maze with the addition of 
 * the shortest path. If the output file name cannot be found, it will create 
 * the file to output the new maze. Our placement of input and output files is in
 * the folder "Resources1"
 * @author Ashton Schmidt and Gabrielle Hoyer
 *
 */
public class TestPathFinder 
{

	//driver
	 public static void main(String[] args)
     {
       // The below code assumes you have a file "tinyMaze.txt" in your project folder.
       // If PathFinder.solveMaze is implemented, it will create a file
       //   "tinyMazeOutput.txt" in your project folder.
       //  * REMEMBER - You have to refresh your project to see the output
       // file in your package explorer.
       // You are still required to make JUnit tests...just lookin' at text files ain't gonna fly. 
		 
       PathFinder.solveMaze("Resources1/tinyMaze.txt", "Resources1/tinyMazeOutput.txt");
       PathFinder.solveMaze("Resources1/bigMaze.txt", "Resources1/bigMazeOutput.txt");
       PathFinder.solveMaze("Resources1/classic.txt", "Resources1/classicMazeOutput.txt");
       PathFinder.solveMaze("Resources1/demoMaze.txt", "Resources1/demoMazeOutput.txt");
       PathFinder.solveMaze("Resources1/mediumMaze.txt", "Resources1/mediumMazeOutput.txt");
       PathFinder.solveMaze("Resources1/turn.txt", "Resources1/turnMazeOutput.txt");
       PathFinder.solveMaze("Resources1/unsolvable.txt", "Resources1/unsolvableMazeOutput.txt");
       PathFinder.solveMaze("Resources1/randomMaze.txt", "Resources1/randomMazeOutput.txt");
       PathFinder.solveMaze("Resources1/straight.txt", "Resources1/straightMazeOutput.txt");
       
       

     }
}
