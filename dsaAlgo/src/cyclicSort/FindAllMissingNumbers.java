package cyclicSort;

import java.util.*;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count
as extra space.
*/

public class FindAllMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int l = nums.length;
        while(i<l){
            int index = nums[i]-1;
            if(nums[i]!=nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            else{
                i++;
            }
        }
        List<Integer> retval = new ArrayList<>();
        for(i=0;i<l;i++){
            if(i!=nums[i]-1){
                retval.add(i+1);
            }
        }
        return retval;
    }
}
