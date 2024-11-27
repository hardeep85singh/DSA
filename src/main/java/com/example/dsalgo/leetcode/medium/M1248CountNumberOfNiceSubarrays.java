package com.example.dsalgo.leetcode.medium;

public class M1248CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysAtMost(nums, k) - numberOfSubarraysAtMost(nums, k - 1);
    }
    private static int numberOfSubarraysAtMost(int[] nums, int k) {
        int ans = 0;
        for (int l = 0, r = 0; r <= nums.length;) {
            if (k >= 0) {
                ans += r - l;
                if (r == nums.length) {
                    break;
                }
                if (nums[r] % 2 == 1) {
                    k--;
                }
                r++;
            } else {
                if (nums[l] % 2 == 1) {
                    k++;
                }
                l++;
            }
        }
        return ans;
    }
}
