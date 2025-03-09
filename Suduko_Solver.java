package Recursion.BackTracking_MazeProblem;

public class Suduko_Solver {
    public static void main(String[] args) {
        int[][]board = new int[][]{
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
        if (solve(board)) {
            display(board);
        }
        else{
            System.out.println("Cannot Solve");
        }
    }
    static boolean solve(int[][]board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        //This is how we are replacing the R,C from the Arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft = false;
                    break;
                }
            }
            //If you found some empty element in row, the break
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft==true){
            return true;
            //Suduko is Solved
        }
        //BackTrack
        for (int number = 1; number < 10; number++) {
            if(isSafe(board,row,col,number)){
                board[row][col] = number;
                if(solve(board)){
                    //Found the answer
                    return true;
                }
                else{
                    //Backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static void display(int[][]board){
        for (int[] row: board ) {
            for (int num : row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][]board,int row,int cols,int num){
        //Check the Row
        for (int i = 0; i < board.length; i++) {
            //Check if the number is in the row
            if(board[row][cols]==num){
                return false;
            }
        }
        //Check for cols
        for (int[] nums: board) {
            //Check if the Number is in the cols
            if(nums[cols]==num){
                return false;
            }
        }
        int srqt = (int)(Math.sqrt(board.length));
        int rowstart = row - row % srqt;
        int colstart = cols-cols%srqt;
        for (int r = rowstart; r < rowstart+srqt; r++) {
            for (int c = colstart; c < colstart+srqt; c++) {
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
