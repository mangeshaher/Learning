package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since
the answer may be large, return the answer modulo 109 + 7.

Example 1:
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:
Input: arr = [11,81,94,43,3]
Output: 444

Constraints:
1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
*/

public class SumOfSubArrayMins {
    public int sumSubarrayMins(int[] arr) {
        int[] leftMin = new int[arr.length];
        int[] rightMin = new int[arr.length];
        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, arr.length);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftMin[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=arr.length - 1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightMin[i] = st.peek();
            }
            st.push(i);
        }
        int res = 0;
        int mod = (int)1e9 + 7;
        for(int i=0;i<arr.length;i++){
            res=((i-leftMin[i])*(rightMin[i]-i)*arr[i] + res)%(mod);
        }
        return res;
    }
}
