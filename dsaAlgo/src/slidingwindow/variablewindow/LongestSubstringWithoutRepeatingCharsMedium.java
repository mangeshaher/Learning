package slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

public class LongestSubstringWithoutRepeatingCharsMedium {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while(right < l){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if(map.size()<right-left+1){
                while(map.size()<right-left+1){
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                    map.remove(s.charAt(left), 0);
                    left++;
                }
            }
            else if(map.size()==right-left+1){
                maxLength = Integer.max(maxLength, right-left+1);
            }
            right++;
        }
        return maxLength;
    }

    // SLiding window with position stored
    public int lengthOfLongestSubstringSlidingPosition(String s) {
        int l = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while(right<l){
            if(map.containsKey(s.charAt(right))){// move left to last occured left+1
                left = map.get(s.charAt(right)) >= left ? map.get(s.charAt(right)) + 1: left;
            }
            map.put(s.charAt(right), right);// ensure to store its position so duplicate can override pos
            if(right-left+1>maxLength){
                maxLength = right-left+1;
            }
            right++;
        }
        return maxLength;
    }
}
