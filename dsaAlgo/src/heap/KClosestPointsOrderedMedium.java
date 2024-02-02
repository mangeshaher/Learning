package heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsOrderedMedium {
    public int[][] kClosest(int[][] points, int k) {
        int[][] retval = new int[k][2];
        PriorityQueue<Map.Entry<Point, Integer>> q = new PriorityQueue<>(k, new EntryValueeComparator());
        for(int i=0;i<points.length;i++){
            q.offer(Map.entry(new Point(points[i][0], points[i][1]), points[i][0]*points[i][0] + points[i][1]*points[i][1]));
        }
        for(int i=0;i<k;i++){
            Point a = q.poll().getKey();
            retval[i][0] = a.x;
            retval[i][1] = a.y;
        }
        return retval;
    }
}
class EntryValueeComparator implements Comparator<Map.Entry<Point, Integer>> {
    public int compare(Map.Entry<Point, Integer> e1, Map.Entry<Point, Integer> e2) {
        if (e1.getValue() < e2.getValue())
            return -1;
        else if (e1.getValue() > e2.getValue()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
