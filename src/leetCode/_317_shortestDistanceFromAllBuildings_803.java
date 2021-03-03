package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
You want to build a house on an empty land 
which reaches all buildings in the shortest amount of distance. 
You can only move up, down, left and right. 
You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.


Example 1

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation:
In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, 
as the total travel distance of 3+3+1=7 is minimal. So return 7.

Example 2

Input: [[1,0],[0,0]]
Output: 1
In this example, there is one buildings at (0,0).
1 - 0
|   |
0 - 0
The point (1,0) or (0,1) is an ideal empty land to build a house, 
as the total travel distance of 1 is minimal. So return 1.
 */
public class _317_shortestDistanceFromAllBuildings_803 {
	public static void main(String[] args) {
		_317_shortestDistanceFromAllBuildings_803 s=new _317_shortestDistanceFromAllBuildings_803();
//		int[][] grid= { {1,1,1,1,1,0},
//						{0,0,0,0,0,1},
//						{0, 1, 1,  0, 0,1},
//						{1,0,0,1,0,1},
//						{1,0,1,0,0,1},
//						{1,0,0,0,0,1},
//						{0,1,1,1,1,0}};
		int[][] grid= { {1,0,2,0,1},
						{0,0,0,0,0},
						{0,0,1,0,0}};
//		int[][] grid= {{1,0},{0,0}};
		System.out.println(s.shortestDistance(grid));
	}
    public int shortestDistance(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
    	boolean[][] visited=new boolean[m][n];
    	int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    	int buildingCount=0;
    	int[][] reachCount=new int[m][n];
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(grid[i][j]==1) {//building.
    				buildingCount++;
    				for(int x=0;x<m;x++) {
    					for(int y=0;y<n;y++) {
    						visited[x][y]=false;
    					}
    				}
    				
    				Queue<int[]> q=new LinkedList<>();
    				q.offer(new int[] {i,j});
    				int lv=1;
    				visited[i][j]=true;
    				while(!q.isEmpty()) {
    					int size=q.size();
    					for(int k=0;k<size;k++) {
    						int[] cur=q.poll();
    						for(int[] dir:dirs) {
    							int nextX=cur[0]+dir[0];
    							int nextY=cur[1]+dir[1];
    							if(0<=nextX&&nextX<grid.length&&0<=nextY&&
    										nextY<grid[0].length&&grid[nextX][nextY]<=0&&
    										!visited[nextX][nextY]) {
    								grid[nextX][nextY]-=lv;
    								reachCount[nextX][nextY]++;
    								q.offer(new int[] {nextX,nextY});
    								visited[nextX][nextY]=true;
    							}
    						}
    					}
   						lv++;
    				}
    				
    			}
    		}
    	}
    	
    	int res=Integer.MAX_VALUE;
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(grid[i][j]<0&&reachCount[i][j]==buildingCount) {
    				int curDist=0-grid[i][j];
    				if(curDist<res)
    					res=curDist;
    			}
    		}
    	}
    	return res;
    }
}