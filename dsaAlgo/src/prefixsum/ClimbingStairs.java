package prefixsum;

public class ClimbingStairs {
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

Constraints:
1 <= n <= 45
*/
    public static int climbStairs(int n) {
        int a[] = new int[n];
        a[0] = 1;
        if(n>1){
            a[1] = 2;
        }
        for(int i=2;i<n;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }
}
