package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _994_RottingOranges {
/*
 * In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) 
to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse 
until no cell has a fresh orange.  

If this is impossible, return -1 instead.

 

Example 1:

Input: 
[[2,1,1],
[1,1,0],
[0,1,1]]
Output: 4

Example 2:

Input: 
[[2,1,1],
[0,1,1],
[1,0,1]]
Output: -1
Explanation:  
The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

 

Note:

    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] is only 0, 1, or 2.
 */
	
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        boolean noRotted=true;
        boolean noGood=true;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]==2) {
        			q.offer(new int[]{i,j});
        			noRotted=false;
        		}
        		if(grid[i][j]==1)
        			noGood=false;
        	}
        }
        
        if(noRotted&&!noGood)
        	return -1;
        else if(noRotted&&noGood)
        	return 0;
        
        int[][] dirs= {{-1,0},{1,0},{0,1},{0,-1}};
        int res=0;
        while(q.size()!=0) {
        	int cnt=q.size();
        	for(int i=0;i<cnt;i++) {
        		int[] cur=q.poll();
        		for(int[] dir:dirs) {
        			int x=cur[0]+dir[0];
        			int y=cur[1]+dir[1];
        			if(x<0||grid.length<=x||y<0||grid[0].length<=y||
        					grid[x][y]==2||grid[x][y]==0) {
        				continue;
        			}
        			grid[x][y]=2;
        			q.offer(new int[]{x,y});
        		}
        	}
        	res++;
        }
        
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]==1)
        			return -1;
        	}
        }
        return res-1;
    }
}
