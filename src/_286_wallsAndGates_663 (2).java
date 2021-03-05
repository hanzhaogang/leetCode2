package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given a m x n 2D grid 
 * initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. 
    We use the value 231 - 1 = 2147483647 to represent INF 
    as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class _286_wallsAndGates_663 {
    public void wallsAndGates(int[][] rooms) {
    	Queue<int[]> q=new LinkedList<>();
    	
    	int m=rooms.length;
    	int n=rooms[0].length;
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(rooms[i][j]==0) {
    				q.offer(new int[] {i,j});
    			}
    		}
    	}
    	
    	int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    	int dist=1;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		for(int i=0;i<size;i++) {
    			int[] cur=q.poll();
    			for(int[] dir:dirs) {
    				int nxtX=cur[0]+dir[0];
    				int nxtY=cur[1]+dir[1];
    				if(0<=nxtX&&nxtX<m&&0<=nxtY&&nxtY<n&&
    							rooms[nxtX][nxtY]==Integer.MAX_VALUE) {
    					rooms[nxtX][nxtY]=dist;
    					q.offer(new int[] {nxtX,nxtY});
    				}
    			}
    		}
    		dist++;
    	}
    }
}
