package Recursion.BackTracking_MazeProblem;

import java.util.Arrays;

public class Maze_With_Obsticle {
    public static void main(String[] args) {
        boolean[][] board = {{true,true,true},{true,true,true},{true,true,true}};
        obsticle("",board,0,0);
        AllPath("",board,0,0);
        int[][] path = new int[board.length][board[0].length];
        AllPathPrint("",board,0,0,path,1);
    }
    public static void obsticle(String p,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r< maze.length-1){
            obsticle(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            obsticle(p+'R',maze,r,c+1);
        }
    }
    public static void AllPath(String p,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        //I am considering this block in my path
        maze[r][c] = false;
        if(r< maze.length-1){
            AllPath(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            AllPath(p+'R',maze,r,c+1);
        }
        if(r>0){
            AllPath(p+'U',maze,r-1,c);
        }
        if(c>0){
            AllPath(p+'L',maze,r,c-1);
        }
        //This line is where the function will be over
        //So before the function gets removed, also removes the changes that were made by that function
        maze[r][c] = true;
    }
    public static void AllPathPrint(String p,boolean[][] maze,int r,int c,int[][]path,int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            for(int[]arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        //I am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            AllPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            AllPathPrint(p + 'R', maze, r, c + 1, path, step + 1);
        }
        if (r > 0) {
            AllPathPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }
        if (c > 0) {
            AllPathPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }
        //This line is where the function will be over
        //So before the function gets removed, also removes the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
