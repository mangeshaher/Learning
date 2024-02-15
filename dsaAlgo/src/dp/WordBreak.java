package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        wordDict.forEach(i -> set.add(i));
        boolean[] dp = new boolean[s.length()];
        dp[0] = set.contains(s.substring(0, 1));
        for(int i=1;i<s.length();i++){
            int count = 0;
            while(i-count>=0){
                if(i-count==0){
                    dp[i] = dp[i] || set.contains(s.substring(i-count, i+1));
                }
                else{
                    dp[i] = dp[i] || (set.contains(s.substring(i-count, i+1))&&dp[i-count-1]);
                }
                if(dp[i]){
                    break;
                }
                else{
                    count++;
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            for(String w:wordDict){
                int index = i-w.length()+1;
                if(index>=0){
                    if(index == 0){
                        dp[i] = dp[i] || w.equals(s.substring(index, i+1));
                    }
                    else{
                        dp[i] = dp[i] || (w.equals(s.substring(index, i+1))&&dp[index-1]);
                    }
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
