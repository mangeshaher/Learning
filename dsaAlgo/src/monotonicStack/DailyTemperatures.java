package monotonicStack;

import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] retval = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0],0});
        for(int i=1;i<temperatures.length;i++){
            if(temperatures[i]<=stack.peek()[0]){
                stack.push(new int[]{temperatures[i], i});
            }
            else{
                while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                    if(retval[stack.peek()[1]]==0){
                        retval[stack.peek()[1]] = i-stack.peek()[1];
                    }
                    stack.pop();
                }
                stack.push(new int[]{temperatures[i], i});
            }
        }
        return retval;
    }
}
