package com.example.dsalgo.arrays;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrixI {
    public static void main(String[] args) {
        List<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1); a1.add(2); a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(4); a2.add(5); a2.add(6);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(7); a3.add(8); a3.add(9);
        A.add(a1); A.add(a2); A.add(a3);

        for (int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.get(i).size(); j++){
                System.out.print(A.get(i).get(j) + " ");
            }
        }
        ArrayList<Integer> ans = spiralOrder(A);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> spiralOrder(List<ArrayList<Integer>> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        if(A.size()==0){
            return B;
        }
        int rowMax = A.size();
        int colMax = A.get(0).size();
        int initR=0;
        int initC=0;
        for(;initR<rowMax && initC<colMax;initR++,initC++,colMax--,rowMax--){
            // If only single row is left
            if(colMax-initC==1){
                for(int i=initR;i<rowMax;i++)
                {
                    B.add(A.get(i).get(initC));
                }
            }
            // If only single column is left
            else if(rowMax-initR==1){
                for(int i=initC;i<colMax;i++)
                {
                    B.add(A.get(initR).get(i));
                }
            }
            // for closed rectangle or square shape
            else{
                for(int j = initC;j<colMax;j++){
                    B.add(A.get(initC).get(j));
                }
                for(int i = initR+1;i<rowMax;i++){
                    B.add(A.get(i).get(colMax-1));
                }

                for(int j = colMax-2;j>initC;j--){
                    B.add(A.get(rowMax-1).get(j));
                }
                for(int i = rowMax-1;i>initC;i--){
                    B.add(A.get(i).get(initC));
                }
            }
        }
        return B;
    }
}
