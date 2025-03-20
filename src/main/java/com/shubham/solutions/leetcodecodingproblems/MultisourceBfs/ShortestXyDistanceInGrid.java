import java.util.*;
import java.io.*;

/**
<a href="https://www.geeksforgeeks.org/problems/shortest-xy-distance-in-grid--170647/1"> Link </a>
**/
static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int n,
                              int m) {
        int i,j;
        
        int [][]vis = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid.get(i).get(j)=='X'){
                     queue.add(new int[]{i,j,0});
                     vis[i][j]=1;
                   
                }
            }
        }
        
        
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int []top = queue.poll();
            int x= top[0];
            int y = top[1];
            int dist = top[2];
            
            for(int []dir: directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(isValid(newX,newY,n, m)) {
                    int newDist = dist + Math.abs(x-newX)+Math.abs(y-newY);
                    if(grid.get(newX).get(newY)=='Y'){
                        ans= Math.min(ans, newDist);
                    }else if(grid.get(newX).get(newY)=='O'){
                        if(vis[newX][newY]==0){
                            vis[newX][newY]=1;
                            queue.add(new int[]{newX, newY, newDist});
                        }
                    } else {
                        if(vis[newX][newY]==0){
                            vis[newX][newY]=1;
                            queue.add(new int[]{newX, newY, 0});
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    static int [][]directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    
    private static boolean isValid(int x,int y, int row, int col){
        return x>=0 && x<row && y>=0 && y<col;
    }
