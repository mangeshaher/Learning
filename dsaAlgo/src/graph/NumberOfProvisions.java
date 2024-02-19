package graph;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and
city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
*/

public class NumberOfProvisions {
    int[] root;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {
        root = new int[isConnected.length];
        rank = new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            root[i] = i;
            rank[i] = 1;
        }
        for(int i=0;i<isConnected.length-1;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    union(i, j);
                }
            }
        }
        int countProvinces = 0;
        for(int i=0;i<isConnected.length;i++){
            if(find(i) == i){
                countProvinces++;
            }
        }
        return countProvinces;
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
