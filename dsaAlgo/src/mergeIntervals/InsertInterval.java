package mergeIntervals;

import java.util.Arrays;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
*/

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = intervals.length;
        int length = 0;
        boolean newIntervalAdded = false;
        int[][] retval = new int[l+1][2];
        for(int i=0;i<l;i++){
            if(newInterval[0]<intervals[i][0]){
                if(length>0 && newInterval[0]<=retval[length-1][1]){
                    retval[length-1][1] = Integer.max(retval[length-1][1], newInterval[1]);
                }
                else{
                    retval[length][0] = newInterval[0];
                    retval[length][1] = newInterval[1];
                    length++;
                }
                newIntervalAdded = true;
            }
            if(length>0 && intervals.length>0 && intervals[i][0]<=retval[length-1][1]){
                retval[length-1][1] = Integer.max(retval[length-1][1], intervals[i][1]);
            }
            else{
                retval[length][0] = intervals[i][0];
                retval[length][1] = intervals[i][1];
                length++;
            }
        }
        if(!newIntervalAdded){
            if(length>0 && newInterval[0]<=retval[length-1][1]){
                retval[length-1][1] = Integer.max(retval[length-1][1], newInterval[1]);
            }
            else{
                retval[length][0] = newInterval[0];
                retval[length][1] = newInterval[1];
                length++;
            }
            newIntervalAdded = true;
        }
        return Arrays.copyOfRange(retval, 0, length);
    }
}
