package binarysearch;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target
value.nIf target is not found in the array, return [-1, -1]. You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

public class FirstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int startindex = binarySearchStartIndex(nums, 0, nums.length-1, target);
        int endIndex = binarySearchEndIndex(nums, 0, nums.length-1, target);
        return new int[]{startindex, endIndex};
    }

    public int binarySearchStartIndex(int[] nums, int l, int r, int target){
        if(r>=l){
            int mid = (l+r)/2;
            if(nums[mid]==target && ((mid>0 && nums[mid-1]!=nums[mid])|| mid==0)){
                return mid;
            }
            if(nums[mid]<target){
                return binarySearchStartIndex(nums, mid+1, r, target);
            }
            else if(nums[mid]==target && mid>0 && nums[mid-1]==nums[mid]){
                return binarySearchStartIndex(nums, l, mid-1, target);
            }
            else{
                return binarySearchStartIndex(nums, l, mid-1, target);
            }
        }
        return -1;
    }

    public int binarySearchEndIndex(int[] nums, int l, int r, int target){
        if(r>=l){
            int mid = (l+r)/2;
            if(nums[mid]==target && ((mid<nums.length-1 && nums[mid+1]!=nums[mid])|| mid==nums.length-1)){
                return mid;
            }
            if(nums[mid]<target){
                return binarySearchEndIndex(nums, mid+1, r, target);
            }
            else if(nums[mid]==target && mid<nums.length-1 && nums[mid+1]==nums[mid]){
                return binarySearchEndIndex(nums, mid+1, r, target);
            }
            else{
                return binarySearchEndIndex(nums, l, mid-1, target);
            }
        }
        return -1;
    }
}
