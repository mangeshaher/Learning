package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/*
There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the
buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without
obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

Example 1:
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
Example 2:
Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
Example 3:
Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.

Constraints:
1 <= heights.length <= 105
1 <= heights[i] <= 109
*/

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        int l = heights.length;
        int length = 0;
        int[] retval = new int[l];
        int max = Integer.MIN_VALUE;
        for(int i = l-1;i>=0;i--){
            if(heights[i]>max){
                max = heights[i];
                retval[l-1-length] = i;
                length++;
            }
        }
        return Arrays.copyOfRange(retval, l-length, l);
    }

    public int[] findBuildingsStack(int[] heights) {
        int l = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[l];
        for(int i = l-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]<heights[i]){
                st.pop();
            }
            if(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                nextGreater[i] = st.peek();
            }
            else{
                nextGreater[i] = l;
            }
            st.push(i);
        }
        int length = 0;
        int[] retval = new int[l];
        for(int i=0;i<l;i++){
            if(nextGreater[i]==l){
                retval[length] = i;
                length++;
            }
        }
        return Arrays.copyOf(retval, length);
    }
}
