package com.example.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
//        int[][] maze = new int[2][2];
//        System.out.println(countPaths(maze.length, maze[0].length, 0, 0));
//        printPaths(maze.length, maze[0].length, 0, 0, "");
//        System.out.println(paths(maze.length, maze[0].length, 0, 0, ""));
//        System.out.println(pathsDiagonal(maze.length, maze[0].length, 0, 0, ""));
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        printPathsAllDir("", maze, 0, 0, path, 1);
    }

    public static int countPaths(int row, int col, int tarRow, int tarCol){
        if(row == tarRow || col == tarCol){
            return 1;
        }
        int right = countPaths(row, col-1, tarRow, tarCol);
        int below = countPaths(row -1 , col, tarRow, tarCol);
        return right + below;
    }

    public static void printPaths(int row, int col, int tarRow, int tarCol, String ans){
        if(row == tarRow && col == tarCol){
            System.out.println(ans);
            return;
        }
        if(col > tarCol){
            printPaths(row, col-1, tarRow, tarCol, "R"+ans);
        }
        if(row > tarRow){
            printPaths(row-1, col, tarRow, tarCol, "D"+ans);
        }
    }

    public static ArrayList<String> paths(int row, int col, int tarRow, int tarCol, String ans){
        if(row == tarRow && col == tarCol){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(ans);
            return arr;
        }
        ArrayList<String> outer = new ArrayList<>();
        if(col > tarCol){
            ArrayList<String> list = paths(row, col-1, tarRow, tarCol, "R"+ans);
            outer.addAll(list);
        }
        if(row > tarRow){
            ArrayList<String> list = paths(row-1, col, tarRow, tarCol, "D"+ans);
            outer.addAll(list);
        }
        return outer;
    }

    public static ArrayList<String> pathsDiagonal(int row, int col, int tarRow, int tarCol, String ans){
        if(row == tarRow && col == tarCol){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(ans);
            return arr;
        }
        ArrayList<String> outer = new ArrayList<>();
        if(row > tarRow && col > tarCol){
            ArrayList<String> list = pathsDiagonal(row-1, col-1, tarRow, tarCol, "D"+ans);
            outer.addAll(list);
        }
        if(col > tarCol){
            ArrayList<String> list = pathsDiagonal(row, col-1, tarRow, tarCol, "H"+ans);
            outer.addAll(list);
        }
        if(row > tarRow){
            ArrayList<String> list = pathsDiagonal(row-1, col, tarRow, tarCol, "V"+ans);
            outer.addAll(list);
        }
        return outer;
    }

    public static void printPathsRestrictions(String path, boolean[][] maze, int row, int col){
        if(row == maze.length-1 && col == maze[0].length -1){
            System.out.println(path);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if(col < maze[0].length-1){
            printPathsRestrictions("R"+path, maze, row, col+1);
        }
        if(row < maze.length -1){
            printPathsRestrictions("D"+path, maze, row+1, col);
        }
    }

    public static void printPathAllDirections(String path, boolean[][] maze, int row, int col){
        if(row == maze.length -1 && col == maze[0].length -1){
            System.out.println(path);
            return;
        }
        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;

        if(row > 0){
            printPathAllDirections(path+"U", maze, row-1, col);
        }
        if(col < maze[0].length-1){
            printPathAllDirections(path+"R", maze, row, col+1);
        }
        if(row < maze.length-1){
            printPathAllDirections(path+"D", maze, row+1, col);
        }
        if(col > 0){
            printPathAllDirections(path+"L", maze, row, col-1);
        }
        maze[row][col] = true;
    }

    public static void printPathsAllDir(String p, boolean[][] maze, int row, int col, int[][] path, int step){
        if(row == maze.length-1 && col == maze[0].length-1){
            path[row][col] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(maze[row][col] == false){
            return;
        }
        maze[row][col] = false;
        path[row][col] = step;

        if(row > 0){
            printPathsAllDir(p+"U", maze, row-1, col, path, step+1);
        }
        if(col < maze[0].length-1){
            printPathsAllDir(p+"R", maze, row, col+1, path, step+1);
        }
        if(row < maze.length-1){
            printPathsAllDir(p+"D", maze, row+1, col, path, step+1);
        }
        if(col > 0){
            printPathsAllDir(p+"L", maze, row, col-1, path, step+1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
