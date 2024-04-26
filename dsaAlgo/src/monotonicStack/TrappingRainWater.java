package monotonicStack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = height.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        leftMax[0] = height[0];
        for(int i=1;i<l;i++){
            leftMax[i] = Integer.max(height[i], leftMax[i-1]);
        }
        rightMax[l-1] = height[l-1];
        for(int i=l-2;i>=0;i--){
            rightMax[i] = Integer.max(height[i], rightMax[i+1]);
        }
        int sum = 0;
        for(int i=0;i<l;i++){
            sum+=Integer.min(leftMax[i], rightMax[i])-height[i];
        }
        return sum;
    }
}
