package dp;

/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

public class MaximumSubarrayProductKadaneAlgo {
    public int maxProduct(int[] nums) {
        int tempMax = nums[0];
        int tempMin = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int oldTempMax = tempMax;
            tempMax = Math.max(nums[i], Math.max(tempMin*nums[i], tempMax*nums[i]));
            tempMin = Math.min(nums[i], Math.min(tempMin*nums[i], oldTempMax*nums[i]));
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
