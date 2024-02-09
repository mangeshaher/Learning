package dfs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Pairr> q = new LinkedList<>();
        int[][] visited = new int[grid.length][];
        int maxTime = 0;
        for(int i=0;i<grid.length;i++){
            visited[i] = new int[grid[i].length];
            for(int j=0;j<grid[i].length;j++){
                visited[i][j]=0;
                if(grid[i][j]==2){
                    visited[i][j]=0;
                    q.offer(new Pairr(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pairr e = q.poll();
            int i = e.getKey();
            int j = e.getValue();
            if(i+1<grid.length && grid[i+1][j]==1 && (visited[i+1][j] > visited[i][j]+1 || visited[i+1][j] == 0)){
                q.add(new Pairr(i+1,j));
                visited[i+1][j] = visited[i][j]+1;
                maxTime = Integer.max(maxTime, visited[i+1][j]);
            }
            if(i-1>=0 && grid[i-1][j]==1 && (visited[i-1][j] > visited[i][j]+1 || visited[i-1][j] == 0)){
                q.add(new Pairr(i-1,j));
                visited[i-1][j] = visited[i][j]+1;
                maxTime = Integer.max(maxTime, visited[i-1][j]);
            }
            if(j+1<grid[i].length && grid[i][j+1]==1 && (visited[i][j+1] > visited[i][j]+1 || visited[i][j+1] == 0)){
                q.add(new Pairr(i,j+1));
                visited[i][j+1] = visited[i][j]+1;
                maxTime = Integer.max(maxTime, visited[i][j+1]);
            }
            if(j-1>=0 && grid[i][j-1]==1 && (visited[i][j-1] > visited[i][j]+1 || visited[i][j-1] == 0)){
                q.add(new Pairr(i,j-1));
                visited[i][j-1] = visited[i][j]+1;
                maxTime = Integer.max(maxTime, visited[i][j-1]);
            }
        }
        int flag=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                    maxTime = -1;
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        return maxTime;
    }
}

class Pairr{
    int key;
    int value;

    public Pairr(int k, int v){
        key = k;
        value = v;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }
}
