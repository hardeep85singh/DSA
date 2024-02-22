package com.example.dsalgo.binarysearch;

/**
 * @author Hardeep Singh
 * @since 06-09-2023
 */
public class RotatedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,0};
        System.out.println(searchInRotatedArray(nums, 0));
    }

    public static int searchInRotatedArray(int[] nums, int target){
        int pivot = findPivot(nums, 0, nums.length-1);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }
    public boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums, 0, nums.length-1);
        int ans;
        if(pivot == -1){
            ans = binarySearch(nums, target, 0, nums.length-1);
            if(ans == -1){
                return false;
            }
        }
        if (nums[pivot] == target){
            return true;
        }
        if(target >= nums[0]){
            ans = binarySearch(nums, target, 0, pivot-1);
        } else {
            ans = binarySearch(nums, target, pivot+1, nums.length-1);
        }
        return ans != -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2; // due to integer overflow in java
            if(target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findPivot(int[] nums, int start, int end){
        while (start <= end){
            int mid = start + (end-start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(start < mid && nums[mid] < nums[mid-1]){
                return mid -1;
            }
            if(nums[start] >= nums[mid]){
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findPivotWithDuplicates(int[] nums, int start, int end){
        while (start <= end){
            int mid = start + (end - start) /2 ;
            if(start < mid && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(end > mid && nums[mid] < nums[mid-1]){
                return mid -1;
            }
            if(nums[start] == nums[mid] && nums[end] == nums[mid]){
                if(nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                if(nums[end] < nums[end-1]){
                    return end-1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchIndex(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    return binarySearchIndex(nums, start, mid-1, target);
                } else {
                    return binarySearchIndex(nums, mid+1, end, target);
                }
            } else{
                if(target <= nums[end] && target > nums[mid]){
                    return binarySearchIndex(nums, mid+1, end, target);
                } else {
                    return binarySearchIndex(nums, start, mid-1, target);
                }
            }
        }
        return -1;
    }
}
