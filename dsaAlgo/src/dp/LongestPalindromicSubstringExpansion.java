package dp;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class LongestPalindromicSubstringExpansion {
    public String longestPalindrome(String s) {
        int lMax = 0;
        int rMax = 0;
        int maxL = 1;
        int l,r;
        for(int i=0;i<s.length();i++){
            l=i;
            r=i+1;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l+1>maxL){
                        maxL = r-l+1;
                        lMax = l;
                        rMax = r;
                    }
                    l--;
                    r++;
                }
                else{
                    break;
                }
            }
        }
        for(int i=0;i<s.length();i++){
            l=i;
            r=i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l+1>maxL){
                        maxL = r-l+1;
                        lMax = l;
                        rMax = r;
                    }
                    l--;
                    r++;
                }
                else{
                    break;
                }
            }
        }
        return s.substring(lMax, rMax+1);
    }
}
