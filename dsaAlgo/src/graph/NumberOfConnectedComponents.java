package graph;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that
there is an edge between ai and bi in the graph.
Return the number of connected components in the graph.

Example 1:
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1

Constraints:
1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

public class NumberOfConnectedComponents {
    int[] root;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = 1;
        }

        for(int i=0;i<edges.length;i++){
            union(edges[i][0], edges[i][1]);
        }

        int countComponents = 0;
        for(int i=0;i<n;i++){
            if(find(i) == i){
                countComponents++;
            }
        }
        return countComponents;
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}
