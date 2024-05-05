package backtracking;

import java.util.*;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

public class SubSets {

    //Solution 1 Iterative
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retval = new ArrayList<>();
        retval.add(new ArrayList<>());
        for(int num:nums){
            List<List<Integer>> retvalCopy = new ArrayList<>(retval);
            for(List<Integer> lis:retvalCopy){
                List<Integer> copy = new ArrayList<>(lis);
                copy.add(num);
                retval.add(copy);
            }
        }
        return retval;
    }

    //Solution 2 BackTracking
    List<List<Integer>> retval;
    public List<List<Integer>> bsubsets(int[] nums) {
        retval = new ArrayList<>();
        int l = nums.length;
        for(int k=0;k<l+1;k++){
            backtrack(0, nums, 0, k, new ArrayList<>());
        }
        return retval;
    }

    public void backtrack(int start, int[] nums, int k, int l, List<Integer> curr){
        if(k==l){
            retval.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i<nums.length;i++){
            curr.add(nums[i]);

            backtrack(i+1, nums, curr.size(), l, curr);

            curr.remove(curr.size()-1);
        }
    }
}
