package dp.zero1knapsack;

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    Boolean[][] bool;

    public boolean canPartitionTopDown(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        bool = new Boolean[nums.length+1][sum/2+1];
        return check(nums, sum/2, nums.length);
    }

    private Boolean check(int[] nums, int sum, int index){
        if(sum<0 || index<=0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(bool[index][sum]!=null){
            return bool[index][sum];
        }
        boolean val = check(nums, sum-nums[index-1], index-1) ||
                check(nums, sum, index-1);
        bool[index][sum] = val;
        return bool[index][sum];
    }

    public boolean canPartitionBottomUp(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        bool = new Boolean[nums.length+1][sum/2+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum/2;j++){
                if(i==0){
                    bool[i][j] = false;
                }
                else if(j==0){
                    bool[i][j] = true;
                }
                else{
                    if(j-nums[i-1]>=0){
                        bool[i][j] = bool[i-1][j] || bool[i-1][j-nums[i-1]];
                    }
                    else{
                        bool[i][j] = bool[i-1][j];
                    }
                }
            }
        }
        return bool[nums.length][sum/2];//check(nums, sum/2, nums.length);
    }
}
