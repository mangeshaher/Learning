package slidingwindow.variablewindow;

import java.util.*;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring
of s such that every character in t (including duplicates) is included in the window. If there is no such substring,
return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
*/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = s.length();
        int tl = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<tl;i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            }
            else{
                map.put(t.charAt(i), 1);
            }
        }
        int count = map.size();
        int min = Integer.MAX_VALUE;
        String mString = "";
        int left = 0;
        int right = 0;
        while(right < l){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) == 0){
                    count--;
                }
                right++;
            }
            else{
                right++;
            }
            while(count==0){
                if(right-left+1<min){
                    min = right-left+1;
                    mString = s.substring(left, right);
                }
                if(map.containsKey(s.charAt(left))){
                    if(map.get(s.charAt(left))==0){
                        count++;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                }
                left++;
            }
        }
        return mString;
    }
}
