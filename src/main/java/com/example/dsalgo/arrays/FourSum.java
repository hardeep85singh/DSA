package com.example.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (nums == null || nums.size() < 4) {
            return result;
        }

        Collections.sort(nums);

        for (int i = 0; i < nums.size() - 3; i++) {
            if (i > 0 && nums.get(i) == nums.get(i-1)) {
                continue; // Skip duplicate elements
            }

            for (int j = i + 1; j < nums.size() - 2; j++) {
                if (j > i + 1 && nums.get(j) == nums.get(j-1)) {
                    continue; // Skip duplicate elements
                }

                int left = j + 1;
                int right = nums.size() - 1;

                while (left < right) {
                    int sum = nums.get(i) + nums.get(j) + nums.get(left) + nums.get(right);

                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums.get(i)); list.add(nums.get(j));list.add(nums.get(left)); list.add(nums.get(right));
                        result.add(list);

                        // Skip duplicate elements
                        while (left < right && nums.get(left) == nums.get(left + 1)) {
                            left++;
                        }

                        while (left < right && nums.get(right) == nums.get(right - 1)) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8461, 5349, 9266, 3061, 1694, 9945, 6989, 2982, 4738, 709, 8244, 4211, 4165, 4547, 9788, 9630, 1241, 8658, 8822, 5224, 6694, 1223, 5141, 9519, 6713, 1643, 2819, 3767, 8440, 7992, 6584, 8619, 4694, 8632, 292, 9414, 3927, 1173, 561, 2132, 2346, 3866, 488, 5294, 3968, 6143, 5394, 6629, 46, 919, 6229, 8130, 1463, 1327, 3697, 4833, 3844, 3473, 4694, 8240, 5535, 7962, 9948, 9183, 2507, 525, 2728, 7671, 1945, 101, 6439, 3806, 5825, 3361, 7501, 4786, 3870, 9105, 6535, 6658, 9788, 9230, 9922, 2020, 2132, 5980, 6380, 6665, 5143, 439, 8008, 1810, 7130, 9780, 7623, 6469, 1857, 4052, 4620, 1356, 133, 273, 246, 939, 4838, 6071, 5151, 1179, 7192, 9138, 1707, 8181, 6759, 9967, 1873, 4957, 3806, 3359, 4032, 7481, 8250, 4343, 6661, 688, 1017, 8674, 1046, 8539, 1186, 7191, 4918, 3478, 1968, 854, 9024, 1122, -7, 7823, 4154, 4359, 7857, 337, 3587, 4458, 8108, 3417, 8001};
        int target = 12731;

        ArrayList<ArrayList<Integer>> result = fourSum(arrayToArrayList(nums), target);

        // Display the result
        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
    }


    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}

