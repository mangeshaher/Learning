package graph;

import java.util.PriorityQueue;

/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
where |val| denotes the absolute value of val.
Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:
We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

Constraints:
1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
*/

public class MinCostToBuildMSTKruskal {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        UnionFind uf = new UnionFind(points.length);
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int dis = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.add(new Edge(i, j, dis));
            }
        }
        int edgeCount = points.length - 1;
        while(!pq.isEmpty() && edgeCount>0){
            Edge top = pq.poll();
            if(!uf.connected(top.point1, top.point2)){
                cost+=top.cost;
                uf.union(top.point1, top.point2);
                edgeCount--;
            }
        }
        return cost;
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    class UnionFind {
        int root[];
        int rank[];

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
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

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
