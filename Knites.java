package Recursion.BackTracking_MazeProblem;

public class Knites {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board,0,0,4);
    }
    static void knight(boolean[][]board,int row,int cols,int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return;
        }
        if(row== board.length - 1 && cols == board.length){
            return;
        }
        if(cols== board.length){
            knight(board,row+1,0,knights);
        }
        if(isSafe(board,row,cols)){
            board[row][cols] = true;
            knight(board,row,cols+1,knights-1);
            board[row][cols] = false;
        }
        knight(board,row,cols+1,knights);
    }
    private static void display(boolean[][] board) {
        for(boolean[]row:board){
            for (boolean element : row){
                if(element){
                    System.out.print("K ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isSafe(boolean[][] board, int row,int cols){
        if(isValid(board,row-2,cols-1)){
            if(board[row-2][cols-1]){
                return false;
            }
        }
        if(isValid(board,row-1,cols-2)){
            if(board[row-1][cols-2]){
                return false;
            }
        }
        if(isValid(board,row-2,cols+1)){
            if(board[row-2][cols+1]){
                return false;
            }
        }
        if(isValid(board,row-1,cols+2)){
            if(board[row-1][cols+2]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][]board,int row,int cols){
        if(row>=0 && row< board.length && cols>= 0 && cols< board.length){
            return true;
        }
        return false;
    }
}
