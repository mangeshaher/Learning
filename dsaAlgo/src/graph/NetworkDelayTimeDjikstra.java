package graph;

import java.util.*;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed
edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a
signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

Constraints:
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/

public class NetworkDelayTimeDjikstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i, new HashMap<>());
        }
        for(int[] time:times){
            adj.get(time[0]).put(time[1], time[2]);
        }
        adj.get(k).put(k, 0);
        int[] minDis = new int[n+1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int top = q.poll();
            for(int neighbour:adj.get(top).keySet()){
                if(minDis[neighbour]>minDis[top]+adj.get(top).get(neighbour)){
                    minDis[neighbour]=minDis[top]+adj.get(top).get(neighbour);
                    q.add(neighbour);
                }
            }
        }
        int minNetworkTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            minNetworkTime = Math.max(minNetworkTime, minDis[i]);
        }
        return minNetworkTime == Integer.MAX_VALUE ? -1 : minNetworkTime;
    }
}
