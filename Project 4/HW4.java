import java.util.*;

public class HW4 {
  //check function will verify invalid locations and prevent recursive calls to the locations
  public static boolean check(int maze[][], int startRow, int startCol, boolean marked[][]){
    int numRows = maze.length, numCols = maze[0].length;
    if(startRow < numRows && startRow > -1 && startCol < numCols && startCol > -1){   //checks bounds
      if(marked[startRow][startCol] != true){                                         //checks if visited
        if(maze[startRow][startCol] != 1){                                            //check walls
          return true;
        }
      }
    }
    return false;                 //fails check if test is failed
  }

   // Returns true if it is possible to solve the maze,
   // starting in the top-left and ending in the bottom-right.
   public static boolean winnable(int maze[][]) {
      boolean marked[][] = new boolean[maze.length][maze[0].length];
      return winnable(maze, 0, 0, marked);
   }

   // Returns true if it is possible to solve the maze,
   // starting in the location maze[startRow][startCol] and ending in the bottom-right.
   // If the maze is winnable, this method modifies the maze array by filling in the winning path with 2s.
   // Otherwise, the maze is not modified.
   public static boolean winnable(int maze[][], int startRow, int startCol, boolean[][] marked) {
      int numRows = maze.length, numCols = maze[0].length;

      // If you already won, fill in the entry with 2 and return true.
      if(startRow == numRows-1 && startCol == numCols-1){
        maze[startRow][startCol] = 2;
        return true;
      }
      // Call winnable recursively on each adjacent location that hasn't been visited yet.
      // check function verfifies invalid locations, i.e. locations that contain walls or locations outside the maze)
      if(check(maze, startRow, startCol, marked)){
        // Mark the current location as visited if it passes the check
        marked[startRow][startCol] = true;
        //recursive calls
        // If you can win from any adjacent location, fill in the entry with 2 and return true.
        if(winnable(maze, startRow, startCol+1, marked)){   //right
            maze[startRow][startCol] = 2;
            return true;
        }
        if(winnable(maze, startRow+1, startCol, marked)){   //down
            maze[startRow][startCol] = 2;
            return true;
        }
        if(winnable(maze, startRow, startCol-1, marked)){   //left
            maze[startRow][startCol] = 2;
            return true;
        }
        if(winnable(maze, startRow-1, startCol, marked)){   //up
            maze[startRow][startCol] = 2;
            return true;
        }
      }
      //Not the correct path
      return false;
   }

   public static void print(int maze[][]) {
      for (int[] row : maze)
         System.out.println(Arrays.toString(row));
   }

   public static void main(String[] args) {
      int[][] maze1 = {{0, 0, 0, 1, 1},
                       {1, 1, 0, 1, 1},
                       {0, 0, 0, 1, 1},
                       {0, 1, 1, 1, 1},
                       {0, 0, 0, 0, 0}};

      int[][] maze2 = {{0, 0, 0, 0, 1},
                       {0, 1, 0, 1, 1},
                       {0, 1, 1, 0, 0},
                       {0, 0, 0, 1, 0},
                       {1, 0, 1, 0, 0}};

      int[][] maze3 = {{0, 0, 0, 0, 1},
                       {0, 1, 1, 0, 1},
                       {0, 1, 1, 0, 1},
                       {0, 0, 1, 1, 1},
                       {1, 0, 0, 0, 0}};

      int[][] maze4 = {{0, 1, 0, 0, 0},
                       {0, 1, 0, 1, 0},
                       {0, 0, 1, 0, 0},
                       {0, 1, 0, 1, 0},
                       {0, 0, 0, 1, 0}};

      int[][] maze5 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

      // For each maze, call the winnable method, then print the maze.
      // Winnable mazes should have their winning paths filled in with 2s.

      System.out.println("maze1: " + winnable(maze1)); // true
      print(maze1);

      System.out.println("\nmaze2: " + winnable(maze2)); // false
      print(maze2);

      System.out.println("\nmaze3: " + winnable(maze3)); // true
      print(maze3);

      System.out.println("\nmaze4: " + winnable(maze4)); // false
      print(maze4);

      System.out.println("\nmaze5: " + winnable(maze5)); // true
      print(maze5);
   }
}
