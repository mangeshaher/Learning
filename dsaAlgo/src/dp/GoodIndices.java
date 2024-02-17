package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a 0-indexed integer array nums of size n and a positive integer k.
We call an index i in the range k <= i < n - k good if the following conditions are satisfied:
The k elements that are just before the index i are in non-increasing order.
The k elements that are just after the index i are in non-decreasing order.
Return an array of all good indices sorted in increasing order.

Example 1:
Input: nums = [2,1,1,1,3,4,1], k = 2
Output: [2,3]
Explanation: There are two good indices in the array:
- Index 2. The subarray [2,1] is in non-increasing order, and the subarray [1,3] is in non-decreasing order.
- Index 3. The subarray [1,1] is in non-increasing order, and the subarray [3,4] is in non-decreasing order.
Note that the index 4 is not good because [4,1] is not non-decreasing.
Example 2:
Input: nums = [2,1,1,2], k = 2
Output: []
Explanation: There are no good indices in this array.

Constraints:
n == nums.length
3 <= n <= 105
1 <= nums[i] <= 106
1 <= k <= n / 2
*/

public class GoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> retval = new ArrayList<>();
        //no of non increasing nums in left including at index i
        int[] dpleft = new int[nums.length];
        //no of non decreasing nums in right including at index i
        int[] dpright = new int[nums.length];
        Arrays.fill(dpleft, 1);
        Arrays.fill(dpright, 1);

        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                dpleft[i]=dpleft[i-1]+1;
            }
        }

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                dpright[i]=dpright[i+1]+1;
            }
        }

        for(int i=k;i<nums.length-k;i++){
            if(dpleft[i-1]>=k && dpright[i+1]>=k){
                retval.add(i);
            }
        }
        return retval;
    }
}
