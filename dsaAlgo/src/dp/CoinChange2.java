package dp;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:
Input: amount = 10, coins = [10]
Output: 1

Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
*/

public class CoinChange2 {
    public int change2dDP(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int i=0;i<coins.length;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=amount;i++){
            dp[i][0]=(i%coins[0]==0) ? 1 : 0;
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<coins.length;j++){
                if(i-coins[j]>=0){
                    dp[i][j] = dp[i][j-1] + dp[i-coins[j]][j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[amount][coins.length-1];
    }

    public int change1dDP(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j-coins[i]>=0){
                    dp[j]+= dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
