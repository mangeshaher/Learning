package mergeIntervals;

import java.util.Arrays;

/*
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and
secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed
interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

Constraints:
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1
*/

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0;
        int s = 0;
        int fl = firstList.length;
        int sl = secondList.length;
        int[][] retval = new int[fl+sl][2];
        int length = 0;
        while(f<fl && s<sl){
            if(secondList[s][0]<=firstList[f][1] && secondList[s][1]>=firstList[f][0]){
                retval[length][0] = Integer.max(firstList[f][0], secondList[s][0]);
                retval[length][1] = Integer.min(firstList[f][1], secondList[s][1]);
                if(firstList[f][1] < secondList[s][1]){
                    f++;
                }
                else{
                    s++;
                }
                length++;
            }
            else{
                if(firstList[f][1]<secondList[s][0]){
                    f++;
                }
                else{
                    s++;
                }
            }
        }
        return Arrays.copyOf(retval, length);
    }
}
