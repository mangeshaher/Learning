package backtracking;

import java.util.*;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

public class Permutations {
    List<List<Integer>> retval;
    public List<List<Integer>> permute(int[] nums) {
        retval = new ArrayList<>();
        bactrack(new ArrayList<>(), nums);
        return retval;
    }

    public void bactrack(List<Integer> curr, int[] nums){
        if(curr.size()==nums.length){
            retval.add(new ArrayList<>(curr));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(curr.contains(nums[i])){
                    continue;
                }
                curr.add(nums[i]);
                bactrack(curr, nums);
                curr.remove(curr.size()-1);
            }
        }
    }
}
