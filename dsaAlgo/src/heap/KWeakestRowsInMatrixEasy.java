package heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrixEasy {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] retval = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, new EntryKValueComparator());
        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] == 1){
                    count++;
                }
                else{
                    break;
                }
            }
            q.add(Map.entry(i, count));
        }
        for(int i=0;i<k;i++){
            retval[i] = q.poll().getKey();
        }
        return retval;
    }
}

class EntryKValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
        if (e1.getValue() < e2.getValue())
            return -1;
        else if (e1.getValue() > e2.getValue()){
            return 1;
        }
        else{
            return Integer.compare(e1.getKey(), e2.getKey());
        }
    }
}
