package dp;

import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
Note that:
A subsequence is an array that can be derived from another array by deleting some or no elements without changing
the order of the remaining elements.
A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

Example 1:
Input: nums = [3,6,9,12]
Output: 4
Explanation:  The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: nums = [9,4,7,2,10]
Output: 3
Explanation:  The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: nums = [20,1,15,3,10,5,8]
Output: 4
Explanation:  The longest arithmetic subsequence is [20,15,10,5].

Constraints:
2 <= nums.length <= 1000
0 <= nums[i] <= 500
*/

public class LongestArithmaticSubsequenceMedium {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int max = 2;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(nums[j]-nums[i])){
                    Map<Integer, Integer> mapp = map.get(nums[j]-nums[i]);
                    if(mapp.containsKey(i)){
                        mapp.put(j, mapp.get(i)+1);
                        if(mapp.get(i)+1 > max){
                            max = mapp.get(i)+1;
                        }
                    }
                    else{
                        mapp.put(j,2);
                    }
                }
                else{
                    Map<Integer, Integer> mapp = new HashMap<>();
                    mapp.put(j,2);
                    map.put(nums[j]-nums[i], mapp);
                }
            }
        }
        return max;
    }
}
