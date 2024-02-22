package com.example.dsalgo.graphs;

import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class KuruskalAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-584, -714, -895, -512, -718, -545, 734, -886, 701, 316, -329, 786, -737, -687, -645, 185, -947, -88, -192, 832, -55, -687, 756, -679, 558, 646, 982, -519, -856, 196, -778, 129, -839, 535, -550, 173, -534, -956, 659, -708, -561, 253, -976, -846, 510, -255, -351, 186, -687, -526, -978, -832, -982, -213, 905, 958, 391, -798, 625, -523, -586, 314, 824, 334, 874, -628, -841, 833, -930, 487, -703, 518, -823, 773, -730, 763, -332, 192, 985, 102, -520, 213, 627, -198, -901, -473, -375, 543, 924, 23, 972, 61, -819, 3, 432, 505, 593, -275, 31, -508, -858, 222, 286, 64, 900, 187, -640, -587, -26, -730, 170, -765, -167, 711, 760, -104, -333 };
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){
            A.add(arr[i]);
        }
//        ArrayList<Integer> A = new ArrayList<>();
//        A.add(5);
//        A.add(-2);
//        A.add(3);
//        A.add(1);
//        A.add(2);
        System.out.println(solve(A, 32));
//        for (int i = 0; i < A.size(); i++) {
//            System.out.print(A.get(i) + " ");
//        }
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int maxSum = Integer.MIN_VALUE;
        int j = 0;
//        B = B % A.size();
        while (j < B){
            int sum = 0;
            for(int i = 0; i < B; i++){
                sum = sum + A.get(i);
            }
            maxSum = Math.max(maxSum, sum);
            rotateArrayByOne(A);
            j++;
        }
        return maxSum;
    }
    public static ArrayList<Integer> rotateArrayByOne(ArrayList<Integer> A){
        int temp = A.get(A.size()-1);
        for (int i = 0; i < A.size() - 1; i++){
            A.set(A.size()-1-i, A.get(A.size()-2-i));
        }
        A.set(0, temp);
        return A;
    }
    public static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }


}
