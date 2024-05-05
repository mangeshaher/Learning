package backtracking;

import java.util.*;

/*
Given an integer array nums that may contain duplicates, return all possible
subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

public class SubsetsWithDuplicateNum {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retval = new ArrayList<>();
        retval.add(new ArrayList<>());
        Arrays.sort(nums);
        int retvalLength = 0;
        for(int i = 0; i<nums.length; i++){
            int startIndex = (i>0 && nums[i]==nums[i-1]) ? retvalLength: 0;
            retvalLength = retval.size();
            for(int j=startIndex;j<retvalLength;j++){
                List<Integer> copy = new ArrayList<>(retval.get(j));
                copy.add(nums[i]);
                retval.add(copy);
            }
        }
        return retval;
    }
}
