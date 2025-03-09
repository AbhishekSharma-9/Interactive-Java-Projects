package Recursion.BackTracking_MazeProblem;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        path("",3,3);
        System.out.println(path1("",3,3));
        System.out.println(pathDiagonal("",3,3));
    }
    static int count(int r,int c){
        if(r==1||c==1){
            return 1;
        }
        int left = count(r-1,c);
        int right = count(r,c-1);
        return left+right;
    }
    static void path(String process,int r,int c){
        if(r==1&& c==1){
            System.out.println(process);
            return;
        }
        if(r>1){
            path(process+'D',r-1,c);
        }
        if(c>1){
            path(process+'R',r,c-1);
        }
    }
    static ArrayList<String> path1(String process, int r, int c){
        if(r==1&& c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1){
            ans.addAll(path1(process+'D',r-1,c));
        }
        if(c>1){
            ans.addAll(path1(process+'R',r,c-1));
        }
        return ans;
    }
    static ArrayList<String> pathDiagonal(String process, int r, int c){
        if(r==1&& c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1&&c>1){
            ans.addAll(pathDiagonal(process+'d',r-1,c-1));
        }
        if(r>1){
            ans.addAll(pathDiagonal(process+'D',r-1,c));
        }
        if(c>1){
            ans.addAll(pathDiagonal(process+'R',r,c-1));
        }
        return ans;
    }
}
