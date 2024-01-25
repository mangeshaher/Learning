package sorting;

import java.util.Arrays;

public class MeetingRoomsEasy {
    private static boolean canAttendMeetings(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endMeetRoom = 0;
        for(int i=1;i<intervals.length;i++){
            if(start[i] < end[endMeetRoom]){
                return false;
            }
            else{
                endMeetRoom++;
            }
        }
        return true;
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
        System.out.println(canAttendMeetings(arr));
        System.out.println(canAttendMeetings(arr1));
    }
}
