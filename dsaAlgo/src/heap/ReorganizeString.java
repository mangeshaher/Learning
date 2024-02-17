package heap;

import java.util.PriorityQueue;

/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

Example 1:
Input: s = "aab"
Output: "aba"
Example 2:
Input: s = "aaab"
Output: ""

Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.
*/

public class ReorganizeString {
    public String reorganizeString(String s) {
        boolean possible = true;
        int[] charCounts = new int[26];
        for(char c : s.toCharArray()){
            charCounts[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i=0;i<26;i++){
            if(charCounts[i]>0){
                pq.offer(new int[]{i+'a', charCounts[i]});
            }
        }
        char[] newString = new char[s.length()];
        for(int i=0;i<s.length();i++){
            int[] top = pq.poll();
            if(i==0 || (newString[i-1]!=(char)top[0])){
                newString[i] = (char)top[0];
                if(top[1]-1>0){
                    pq.offer(new int[]{top[0], top[1]-1});
                }
            }
            else{
                if(pq.isEmpty()){
                    possible = false;
                    break;
                }
                else{
                    int[] stop = pq.poll();
                    newString[i] = (char)stop[0];
                    if(stop[1]-1>0){
                        pq.offer(new int[]{stop[0], stop[1]-1});
                    }
                    pq.offer(top);
                }
            }
        }
        return possible ? String.valueOf(newString) : "";
    }
}
