package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsGatesIterative {
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j]==0){
                    dfs(i,j,rooms);
                }
            }
        }
    }

    public void dfs(int u, int v, int[][] rooms){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(u, v, 0));
        boolean[][] visited = new boolean[rooms.length][];
        for(int i=0;i<rooms.length;i++){
            visited[i] = new boolean[rooms[i].length];
            for(int j=0;j<rooms[i].length;j++){
                visited[i][j] = false;
            }
        }
        while(!q.isEmpty()){
            Pos top = q.poll();
            int i = top.i;
            int j = top.j;
            int dis = top.dis;
            //System.out.println("Inside matrix for :- "+ u + " " + v + " dis :- " + dis + " for i j :- " + i + " " + j);
            if(i+1<rooms.length && rooms[i+1][j] != -1 && rooms[i+1][j]!=0 && !visited[i+1][j]){
                rooms[i+1][j] = Integer.min(rooms[i+1][j], dis+1);
                if(rooms[i+1][j]==dis+1){
                    //System.out.println("Setting Inside matrix for :- "+ u + " " + v + " dis :- " + (dis+1) + " for i j :- " + (i+1) + " " + j);
                    visited[i+1][j] = true;
                    q.offer(new Pos(i+1, j, dis+1));
                }
            }
            if(i-1>=0 && rooms[i-1][j] != -1 && rooms[i-1][j]!=0 && !visited[i-1][j]){
                rooms[i-1][j] = Integer.min(rooms[i-1][j], dis+1);
                if(rooms[i-1][j]==dis+1){
                    //System.out.println("Setting Inside matrix for :- "+ u + " " + v + " dis :- " + (dis+1) + " for i j :- " + (i-1) + " " + j);
                    visited[i-1][j] = true;
                    q.offer(new Pos(i-1, j, dis+1));
                }
            }
            if(j+1<rooms[i].length && rooms[i][j+1] != -1 && rooms[i][j+1]!=0 && !visited[i][j+1]){
                rooms[i][j+1] = Integer.min(rooms[i][j+1], dis+1);
                if(rooms[i][j+1]==dis+1){
                    //System.out.println("Setting Inside matrix for :- "+ u + " " + v + " dis :- " + (dis+1) + " for i j :- " + i + " " + (j+1));
                    visited[i][j+1] = true;
                    q.offer(new Pos(i, j+1, dis+1));
                }
            }
            if(j-1>=0 && rooms[i][j-1] != -1 && rooms[i][j-1]!=0 && !visited[i][j-1]){
                rooms[i][j-1] = Integer.min(rooms[i][j-1], dis+1);
                if(rooms[i][j-1]==dis+1){
                    //System.out.println("Setting Inside matrix for :- "+ u + " " + v + " dis :- " + (dis+1) + " for i j :- " + i + " " + (j-1));
                    visited[i][j-1] = true;
                    q.offer(new Pos(i, j-1, dis+1));
                }

            }
            //dis+=1;
        }

    }
}

class Pos{
    int i;
    int j;
    int dis;
    public Pos(int i, int j, int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}

