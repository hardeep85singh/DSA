package com.example.dsalgo.patterns.slowfastpointers;

public class FindDuplicateNumber {

    /*
    * 1 ≤ n ≤ 10 ^ 3
    * nums.length=n+1
    * 1≤nums[i]≤n
    * All the integers in nums are unique, except for one integer that will appear more than once.
    */
    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5,3,6,8};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        slow = nums[0];

        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
