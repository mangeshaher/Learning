package dp;

/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
*/

public class LongestIncreasingSubsequenceMedium {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l+1];
        for(int j=1;j<=l;j++){
            dp[j] = 1;
        }
        int max = 1;
        for(int i=2;i<=l;i++){
            for(int j=1;j<i;j++){
                if(nums[i-1] > nums[j-1] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    if(dp[i] > max){
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }
}
