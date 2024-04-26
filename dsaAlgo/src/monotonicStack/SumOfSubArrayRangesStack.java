package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/*
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest
element in the subarray. Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:
Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:
Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

Constraints:
1 <= nums.length <= 1000
-109 <= nums[i] <= 109
Follow-up: Could you find a solution with O(n) time complexity?
*/

public class SumOfSubArrayRangesStack {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        int[] prevMin = new int[nums.length];
        Arrays.fill(prevMin, -1);
        int[] prevMax = new int[nums.length];
        Arrays.fill(prevMax, -1);
        int[] postMin = new int[nums.length];
        Arrays.fill(postMin, nums.length);
        int[] postMax = new int[nums.length];
        Arrays.fill(postMax, nums.length);

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevMin[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                postMin[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevMax[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                postMax[i] = st.peek();
            }
            st.push(i);
        }


        for(int i=0;i<nums.length;i++){
            long leftMin = i-prevMin[i];
            long rightMin = postMin[i]-i;
            long leftMax = i-prevMax[i];
            long rightMax = postMax[i]-i;
            sum+=(leftMax*rightMax - leftMin*rightMin)*nums[i];
        }
        return sum;
    }
}
