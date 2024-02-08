package dfs;

/*
You are given an m x n grid rooms initialized with these three possible values.
-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is
impossible to reach a gate, it should be filled with INF.

Example 1:

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]

Constraints:
m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.
*/

public class WallsGatesRecursive {
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j]==0){
                    dfs(i,j,rooms,0);
                }
            }
        }
    }

    public void dfs(int i, int j, int[][] rooms, int d){
        if(i-1>=0 && rooms[i-1][j]>d+1){
            rooms[i-1][j]=d+1;
            dfs(i-1,j,rooms,d+1);
        }
        if(i+1<rooms.length && rooms[i+1][j]>d+1){
            rooms[i+1][j]=d+1;
            dfs(i+1,j,rooms,d+1);
        }
        if(j-1>=0 && rooms[i][j-1]>d+1){
            rooms[i][j-1]=d+1;
            dfs(i,j-1,rooms,d+1);
        }
        if(j+1<rooms[i].length && rooms[i][j+1]>d+1){
            rooms[i][j+1]=d+1;
            dfs(i,j+1,rooms,d+1);
        }
    }
}
