package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M713SubarrayProductLessThanK {
    public static void main(String[] args){
        int[] nums = {10,5,2,90};
        System.out.println(numSubarrayProductLessThanKSlidingWindow(nums, 100));
    }

    public static int numSubarrayProductLessThanKSlidingWindow(int[] nums, int k){
        if(k <= 1){
            return 0;
        }
        int product = 1;
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length){
            product = product * nums[right];
            while (product >= k){
                product = product / nums[left];
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int i = 0; int j=0;
        int count = 0;
        int product = 1;
        while (j < nums.length){
            product = product * nums[j];
            if(product < k){
                j++;
                count++;
                if(j == nums.length && i < j){
                    i++;
                    j = i;
                    product = 1;
                }
            } else if(product >= k){
                i++;
                j = i;
                product = 1;
            }
        }

        return count;
    }

    public static int numSubarrayProductLessThanKLog(int[] nums, int k){
        if(k == 0){
            return 0;
        }
        double kLog = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for(int i = 0; i< nums.length; i++){
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }
        int ans = 0;
        for(int i = 0; i< prefix.length; i++){
            int low = i+1;
            int high = prefix.length;
            while (low < high){
                int mid = low + ( high - low)/2;
                if(prefix[mid] < prefix[i] + kLog -1e-9){
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
            ans = ans + (low - i - 1);
        }
        return ans;
    }
}
