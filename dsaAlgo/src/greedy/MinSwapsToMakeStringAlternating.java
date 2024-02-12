package greedy;

/*
Given a binary string s, return the minimum number of character swaps to make it alternating, or -1 if it is impossible.
The string is called alternating if no two adjacent characters are equal. For example, the strings "010" and "1010" are
alternating, while the string "0100" is not.
Any two characters may be swapped, even if they are not adjacent.

Example 1:
Input: s = "111000"
Output: 1
Explanation: Swap positions 1 and 4: "111000" -> "101010"
The string is now alternating.
Example 2:
Input: s = "010"
Output: 0
Explanation: The string is already alternating, no swaps are needed.
Example 3:
Input: s = "1110"
Output: -1

Constraints:
1 <= s.length <= 1000
s[i] is either '0' or '1'.
*/

public class MinSwapsToMakeStringAlternating {
    public int minSwaps(String s) {
        int onesAtEven = 0;
        int onesAtOdd = 0;
        int zeros = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(i%2==0){
                    onesAtEven++;
                }
                else{
                    onesAtOdd++;
                }
            }
            else{
                zeros++;
            }
        }
        int ones = onesAtOdd + onesAtEven;
        if(Math.abs(onesAtEven+onesAtOdd - zeros)>1){
            return -1;
        }

        if(zeros>ones){
            return onesAtEven;
        }
        else if(ones>zeros){
            return onesAtOdd;
        }
        else{
            return Integer.min(onesAtOdd, onesAtEven);
        }
    }
}
