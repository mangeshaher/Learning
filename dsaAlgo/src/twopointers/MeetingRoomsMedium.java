package twopointers;

import java.util.Arrays;
/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
*/
public class MeetingRoomsMedium {

    private static int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endMeetRoom = 0;
        for(int i=0;i<intervals.length;i++){
            if(start[i] < end[endMeetRoom]){
                rooms++;//denotes start of meeting before earlier meet ends
            }
            else{
                endMeetRoom++;//denotes of the last meeting ended so that meeting room will now be used for this new
                // start of meet
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        /*
        0 30     0 25
        15 35    15 30
        20 25    26 35

        0 10
        8 14
        15 25
        24 45
        */
        int[][] arr = {{0,30},{15,35},{20,25}};
        int[][] arr1 = {{0,30},{15,18},{20,25}};
        System.out.println(minMeetingRooms(arr));
        System.out.println(minMeetingRooms(arr1));
    }
}
