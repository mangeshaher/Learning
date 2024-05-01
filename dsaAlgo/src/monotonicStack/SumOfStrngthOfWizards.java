package monotonicStack;

import java.util.Stack;

/*
As the ruler of a kingdom, you have an army of wizards at your command.

You are given a 0-indexed integer array strength, where strength[i] denotes the strength of the ith wizard. For a
contiguous group of wizards (i.e. the wizards' strengths form a subarray of strength), the total strength is defined
as the product of the following two values:

The strength of the weakest wizard in the group.
The total of all the individual strengths of the wizards in the group.
Return the sum of the total strengths of all contiguous groups of wizards. Since the answer may be very large, return
it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: strength = [1,3,1,2]
Output: 44
Explanation: The following are all the contiguous groups of wizards:
- [1] from [1,3,1,2] has a total strength of min([1]) * sum([1]) = 1 * 1 = 1
- [3] from [1,3,1,2] has a total strength of min([3]) * sum([3]) = 3 * 3 = 9
- [1] from [1,3,1,2] has a total strength of min([1]) * sum([1]) = 1 * 1 = 1
- [2] from [1,3,1,2] has a total strength of min([2]) * sum([2]) = 2 * 2 = 4
- [1,3] from [1,3,1,2] has a total strength of min([1,3]) * sum([1,3]) = 1 * 4 = 4
- [3,1] from [1,3,1,2] has a total strength of min([3,1]) * sum([3,1]) = 1 * 4 = 4
- [1,2] from [1,3,1,2] has a total strength of min([1,2]) * sum([1,2]) = 1 * 3 = 3
- [1,3,1] from [1,3,1,2] has a total strength of min([1,3,1]) * sum([1,3,1]) = 1 * 5 = 5
- [3,1,2] from [1,3,1,2] has a total strength of min([3,1,2]) * sum([3,1,2]) = 1 * 6 = 6
- [1,3,1,2] from [1,3,1,2] has a total strength of min([1,3,1,2]) * sum([1,3,1,2]) = 1 * 7 = 7
The sum of all the total strengths is 1 + 9 + 1 + 4 + 4 + 4 + 3 + 5 + 6 + 7 = 44.
Example 2:
Input: strength = [5,4,6]
Output: 213
Explanation: The following are all the contiguous groups of wizards:
- [5] from [5,4,6] has a total strength of min([5]) * sum([5]) = 5 * 5 = 25
- [4] from [5,4,6] has a total strength of min([4]) * sum([4]) = 4 * 4 = 16
- [6] from [5,4,6] has a total strength of min([6]) * sum([6]) = 6 * 6 = 36
- [5,4] from [5,4,6] has a total strength of min([5,4]) * sum([5,4]) = 4 * 9 = 36
- [4,6] from [5,4,6] has a total strength of min([4,6]) * sum([4,6]) = 4 * 10 = 40
- [5,4,6] from [5,4,6] has a total strength of min([5,4,6]) * sum([5,4,6]) = 4 * 15 = 60
The sum of all the total strengths is 25 + 16 + 36 + 36 + 40 + 60 = 213.

Constraints:
1 <= strength.length <= 105
1 <= strength[i] <= 109
*/

public class SumOfStrngthOfWizards {
    public int totalStrength(int[] strength) {
        int MOD = 1000000007;
        int l = strength.length;
        long[] preSum = new long[l+1];
        long[] prepreSum = new long[l+2];
        for(int i=0;i<l;i++){
            preSum[i+1] = (preSum[i] + strength[i]) % MOD;
        }
        for(int i=0;i<l;i++){
            prepreSum[i+2] = (prepreSum[i+1] + preSum[i+1]) % MOD;
        }
        Stack<Integer> st = new Stack<>();
        int[] nextSmall = new int[l];
        int[] prevSmall = new int[l];
        for(int i=0;i<l;i++){
            while(!st.isEmpty() && strength[st.peek()]>=strength[i]){
                st.pop();
            }
            if(!st.isEmpty() && strength[st.peek()]<strength[i]){
                prevSmall[i] = st.peek();
            }
            else{
                prevSmall[i] = -1;
            }
            st.push(i);
        }
        st.clear();
        for(int i=l-1;i>=0;i--){
            while(!st.isEmpty() && strength[st.peek()]>strength[i]){
                st.pop();
            }
            if(!st.isEmpty() && strength[st.peek()]<=strength[i]){
                nextSmall[i] = st.peek();
            }
            else{
                nextSmall[i] = l;
            }
            st.push(i);
        }
        long retval = 0;
        for(int i=0;i<l;i++){
            int leftDis = i-prevSmall[i];
            int rightDis = nextSmall[i]-i;
            long posVal = (prepreSum[i+rightDis+1] - prepreSum[i+1])%MOD;
            long negVal = (prepreSum[i+1]-prepreSum[i-leftDis+1])%MOD;
            retval=((retval + (((leftDis*posVal-rightDis*negVal)%MOD)*strength[i] % MOD)) %MOD);
        }
        return (int)(retval+MOD)%MOD;
    }
}
