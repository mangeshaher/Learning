package mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        int[][] retval = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        retval[0][0] = intervals[0][0];
        retval[0][1] = intervals[0][1];
        int length = 1;
        for(int i=1;i<l;i++){
            if(intervals[i][0]<=retval[length-1][1]){
                retval[length-1][1] = Integer.max(retval[length-1][1], intervals[i][1]);
            }
            else{
                retval[length][0] = intervals[i][0];
                retval[length][1] = intervals[i][1];
                length++;
            }
        }
        return Arrays.copyOfRange(retval, 0, length);
    }
}
