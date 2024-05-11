package dp.zero1knapsack;

/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:
Input: nums = [1], target = 1
Output: 1

Constraints:
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/

public class TargetSum {
    Integer[][] count;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int num:nums){
            sum+=num;
        }
        count = new Integer[nums.length+1][2*sum+1];
        return call(nums, target, nums.length, 0);
    }

    private int call(int[] nums, int target, int index, int currSum){
        if(count[index][currSum+sum]!=null){
            return count[index][currSum+sum];
        }
        if(target == currSum && index==0){
            return 1;
        }
        else if(index<=0){
            return 0;
        }
        else{
            count[index][currSum+sum] = call(nums, target, index-1, currSum+nums[index-1]) + call(nums, target, index-1, currSum-nums[index-1]);
            return count[index][currSum+sum];
        }
    }
}
