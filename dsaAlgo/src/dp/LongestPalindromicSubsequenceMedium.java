package dp;

/*
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting
some or no elements without changing the order of the remaining elements.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
*/

public class LongestPalindromicSubsequenceMedium {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        //String ss = new StringBuilder().append(s).reverse().toString();
        int[][] dp = new int[l+1][l+1];
        int max=0;
        for(int i=1;i<=l;i++){
            for(int j=1;j<=l;j++){
                if(s.charAt(i-1) == s.charAt(l-j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }
                else{
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
