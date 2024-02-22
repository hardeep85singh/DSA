package com.example.dsalgo.leetcode.medium;

import java.util.HashSet;

/**
 * @author Hardeep Singh
 */
public class M36ValidSudoku {
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.print(isValidSudokuHashset(board));

    }

    public static boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < board.length; i++){
            char ch = board[i][0];
            for(int j = 1; j < board[0].length; j++){
                if(ch == board[i][j] && ch != '.'){
                    return false;
                }
            }
        }
        for(int i = 0; i < board[0].length; i++){
            char ch = board[0][i];
            for(int j = 1; j < board.length; j++){
                if(ch == board[j][i] && ch != '.'){
                    return false;
                }
            }
        }
        for(int a = 0; a < board.length; a = a+3){
            for(int b = 0; b < board[0].length; b= b+3){
                for(int i = a; i < 3; i++){
                    char ch = board[i][0];
                    for(int j = a+1; j < 3; j++){
                        if(ch == board[i][j] && ch != '.'){
                            return false;
                        }
                    }
                }
                for(int i = b; i < 3; i++){
                    char ch = board[0][i];
                    for(int j = b+1; j < 3; j++){
                        if(ch == board[j][i] && ch != '.'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuHashset(char[][] board){
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int i = 0; i< N; i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }
                if(rows[i].contains(val)){
                    return false;
                }
                rows[i].add(val);
                if(columns[j].contains(val)){
                    return false;
                }
                columns[j].add(val);

                int idx = (i/3) * 3 + j /3;
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
