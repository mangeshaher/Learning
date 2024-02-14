package binarysearch;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 105
*/

public class SingleNonDuplicateElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int val = bSearch(nums, 0, nums.length - 1);
        if(val==-1){
            if(nums.length>1 && nums[0]!=nums[1]){
                return nums[0];
            }
            else{
                return nums[nums.length-1];
            }
        }
        else{
            return nums[val];
        }
    }

    public int bSearch(int[] nums, int l, int r){
        if(r>=l){
            int mid = (l+r)/2;
            if((mid<nums.length-1 && nums[mid]!=nums[mid+1] && mid > 0 && nums[mid]!=nums[mid-1])){
                return mid;
            }
            //if no of elements before mid is even if it is even and odd if odd then go right
            else if((mid>0 && mid<nums.length-1)&&((mid%2!=0 && nums[mid]==nums[mid-1])||(mid%2==0 && nums[mid]!=nums[mid-1]))){
                return bSearch(nums, mid+1, r);
            }
            else{
                return bSearch(nums, l, mid-1);
            }
        }
        return -1;
    }
}
