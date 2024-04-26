package monotonicStack;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return
the area of the largest rectangle in the histogram.

Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/

public class MaxAreaOfRectangle {
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        Stack<int[]> st = new Stack<>();
        int[] nextSmaller = new int[l];
        int[] prevSmaller = new int[l];
        for(int i=0;i<l;i++){
            while(!st.isEmpty() && st.peek()[0]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()[0]<heights[i]){
                prevSmaller[i] = st.peek()[1];
            }
            else{
                prevSmaller[i] = -1;
            }
            st.push(new int[]{heights[i], i});
        }
        st = new Stack<>();
        for(int i=l-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()[0]<heights[i]){
                nextSmaller[i] = st.peek()[1];
            }
            else{
                nextSmaller[i] = l;
            }
            st.push(new int[]{heights[i], i});
        }
        int maxRect = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            maxRect = Integer.max((nextSmaller[i]-prevSmaller[i]-1)*heights[i], maxRect);
        }
        return maxRect;
    }
}
