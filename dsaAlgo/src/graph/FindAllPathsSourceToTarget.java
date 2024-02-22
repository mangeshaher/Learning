package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node
n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed
edge from node i to node graph[i][j]).

Example 1:
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

Constraints:
n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
*/

public class FindAllPathsSourceToTarget {
    public List<List<Integer>> allPathsSourceTargetIterative(int[][] graph) {
        List<List<Integer>> retval = new ArrayList<>();
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        boolean[] visited = new boolean[n];
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        visited[0] = true;
        st.push(lis);
        while(!st.isEmpty()){
            List<Integer> topList = st.pop();
            int endElement = topList.get(topList.size()-1);
            if(endElement == n-1){
                retval.add(topList);
            }
            for(int i=0;i<adj.get(endElement).size();i++){
                List<Integer> newList = new ArrayList<>(topList);
                if(!visited[adj.get(endElement).get(i)]){
                    newList.add(adj.get(endElement).get(i));
                    visited[adj.get(endElement).get(i)] = true;
                    st.push(newList);
                }
            }
            Arrays.fill(visited, false);
            visited[0] = true;
        }
        return retval;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> retval = new ArrayList<>();
        if(graph == null || graph.length == 0){
            return retval;
        }
        dfs(0, graph, new ArrayList<>(), retval);
        return retval;
    }

    public void dfs(int node, int[][] graph, List<Integer> currPath, List<List<Integer>> retval){
        currPath.add(node);
        if(node == graph.length - 1){
            retval.add(new ArrayList<>(currPath));
            return;
        }
        for(int neighbour:graph[node]){
            dfs(neighbour, graph, currPath, retval);
            currPath.remove(currPath.size()-1);
        }
    }
}
