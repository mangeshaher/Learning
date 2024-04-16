package slidingwindow.fixedwindow;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in
any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int l = s.length();
        int pl = p.length();
        List<Integer> retval = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int start = 0;
        int end = 0;
        while(end<l){
            //System.out.println("start :- " + start + " end :- " + end + " count :- " + count);
            Character e = s.charAt(end);
            if(map.containsKey(e)){
                map.put(e, map.get(e)-1);
                if(map.get(e) == 0){
                    count--;
                }
            }
            if(end-start+1<pl){
                end++;
            }
            else if(end-start+1==pl){
                Character st = s.charAt(start);
                if(count==0){
                    retval.add(start);
                }
                if(map.containsKey(st) && map.get(st) == 0){
                    count++;
                }
                if(map.containsKey(st)){
                    map.put(st, map.get(st) + 1);
                }
                start++;
                end++;
            }
        }
        return retval;
    }
}
