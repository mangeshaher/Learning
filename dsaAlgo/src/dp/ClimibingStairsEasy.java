package dp;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
public class ClimibingStairsEasy {
    public int climbStairs(int n) {
        int a[] = new int[n];
        a[0] = 1;
        if(n>1){
            a[1] = 2;
        }
        for(int i=2;i<n;i++){
            a[i] = a[i-1] + a[i-2];//ith step can be reached from i-1 and i-2 step
            //(i-1)th + 1 --> one way and (i-2)th +2 --> second way
        }
        return a[n-1];
    }
}
