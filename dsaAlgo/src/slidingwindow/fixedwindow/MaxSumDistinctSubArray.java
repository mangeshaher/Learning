package slidingwindow.fixedwindow;

import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that
meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions,
return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.

Constraints:
1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
*/

public class MaxSumDistinctSubArray {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
            sum+=nums[i];
        }
        long msum = map.keySet().size() == k ? sum : 0;
        for(int i=k;i<nums.length;i++){
            if(map.get(nums[i-k]) > 1){
                map.put(nums[i-k], map.get(nums[i-k])-1);
            }
            else{
                map.remove(nums[i-k]);
            }
            sum-=nums[i-k];
            sum+=nums[i];
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
                if(sum>msum && map.keySet().size()==k){
                    msum = sum;
                }
            }
        }
        return msum;
    }
}
