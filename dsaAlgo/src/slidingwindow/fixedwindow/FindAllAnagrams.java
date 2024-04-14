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
        List<Integer> retval = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<p.length();i++){
            if(!map.containsKey(p.charAt(i))){
                count++;
                map.put(p.charAt(i), 1);
            }
            else{
                map.put(p.charAt(i), map.get(p.charAt(i))+1);
            }
        }
        int start = 0;
        int end = 0;
        while(end<l){
            if(map.keySet().contains(s.charAt(end))){
                map.computeIfPresent(s.charAt(end), (key,val) -> val-1);
                //System.out.println(count + " " + start);
                if(map.get(s.charAt(end)) == 0){
                    count--;
                }
                if(count==0){
                    retval.add(start);
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    count++;
                    start++;
                }
            }
            else{
                while(start!=end+1){
                    if(map.containsKey(s.charAt(start))){
                        if(map.get(s.charAt(start)) == 0){
                            count++;
                        }
                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    }
                    start++;
                }
            }
            end++;
            if(end-start+1 > p.length()){
                if(map.containsKey(s.charAt(start))){
                    if(map.get(s.charAt(start)) == 0){
                        count++;
                    }
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                }
                start++;
            }
        }
        return retval;
    }
}
