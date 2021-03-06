package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an N x N grid containing only values 0 and 1, 
 * where 0 represents water and 1 represents land, 
 * find a water cell such that 
 * its distance to the nearest land cell is maximized 
 * and return the distance.

The distance used in this problem is the Manhattan distance: 
the distance between two cells (x0, y0) and (x1, y1) is 
|x0 - x1| + |y0 - y1|.

If no land or water exists in the grid, return -1.

 

Example 1:

Input: [[1,0,1],
        [0,0,0],
        [1,0,1]]
Output: 2
Explanation: 
The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:

Input: [[1,0,0],
        [0,0,0],
        [0,0,0]]
Output: 4
Explanation: 
The cell (2, 2) is as far as possible from all the land with distance 4.

 

Note:

    1 <= grid.length == grid[0].length <= 100
    grid[i][j] is 0 or 1
 */
public class _1162_AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
    	boolean[][] visited=new boolean[grid.length][grid[0].length];
    	
    	Queue<int[]> q=new LinkedList<>();
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j]==1) {
    				visited[i][j]=true;
    				q.offer(new int[] {i,j});
    			}
    		}
    	}
    	
    	if(q.size()==0||q.size()==grid.length*grid[0].length) {
    		return -1;
    	}
    	int lv=-1;
    	int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    	while(!q.isEmpty()) {
    		int size=q.size();
    		for(int i=0;i<size;i++) {
    			int[] cur=q.poll();
    			for(int[] dir:dirs) {
    				int nextX=cur[0]+dir[0];
    				int nextY=cur[1]+dir[1];
    				if(0<=nextX&&nextX<grid.length&&
    						0<=nextY&&nextY<grid[0].length&&
    						!visited[nextX][nextY]) {
    					visited[nextX][nextY]=true;
    					q.offer(new int[] {nextX,nextY});
    				}
    			}
    		}
    		lv++;
    	}
    	
    	return lv;
    }
}
