package Recursion.BackTracking_MazeProblem;

public class Queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        queens(board,0);

    }
    static int queens(boolean[][]board,int row){
        if(row== board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //Placing the Queen and checking for every row and column
        for (int cols = 0; cols < board.length; cols++) {
            //Place the Queen if it's safe
            if(isSafe(board,row,cols)){
                board[row][cols] = true;
                count += queens(board,row+1);
                board[row][cols] = false;
            }
        }
        return count;
    }
    private static boolean isSafe(boolean[][]board,int row,int cols){
        //Check Vertical Row
        for (int i = 0; i < row; i++) {
            if(board[i][cols]){
                return false;
            }
        }
        //Diagonal left
        int maxLeft = Math.min(row,cols);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][cols-i]){
                return false;
            }
        }
        //Diagonal right
        int maxRight = Math.min(row, board.length - cols - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][cols+i]){
                return false;
            }
        }
        return true;
    }
    private static void display(boolean[][] board) {
        for(boolean[]row:board){
            for (boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
