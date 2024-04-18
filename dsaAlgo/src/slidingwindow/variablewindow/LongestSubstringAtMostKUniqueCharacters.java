package slidingwindow.variablewindow;

import java.util.*;

/*
Given a string s and an integer k, return the length of the longest
substring of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.


Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
*/

public class LongestSubstringAtMostKUniqueCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < l){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            //at most k -- so less than k is also accepted for max condn
            if(map.size()<=k){
                maxLength = Integer.max(maxLength, right-left+1);
            }
            else{
                while(map.size()>k){
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                    map.remove(s.charAt(left), 0);
                    left++;
                }
            }
            right++;
        }
        return maxLength;
    }
}
