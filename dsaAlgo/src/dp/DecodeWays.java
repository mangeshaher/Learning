package dp;

import java.util.HashSet;
import java.util.Set;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Set<String> set = new HashSet<>();
        for(int i=1;i<=26;i++){
            set.add(""+i+"");
        }
        dp[0] = set.contains(s.substring(0, 1))? 1 : 0;
        for(int i=1;i<s.length();i++){
            for(int j=i;j>=i-1;j--){
                if(j>0){
                    dp[i]+=(set.contains(s.substring(j, i+1))? dp[j-1]: 0);
                }
                else{
                    dp[i]+=set.contains(s.substring(j, i+1))? 1 : 0;
                }
            }
        }
        return dp[s.length()-1];
    }

    public int numDecodingsOptimized(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=s.length();i++){
            int single = Integer.parseInt(s.substring(i-1, i));
            int doubl = Integer.parseInt(s.substring(i-2, i));
            if(single>0 && single < 10){
                dp[i]+=dp[i-1];
            }
            if(doubl > 9 && doubl<27){
                dp[i]+=dp[i-2];
            }
        }
        return s.charAt(0) == '0' ? 0 : dp[s.length()];
    }
}
