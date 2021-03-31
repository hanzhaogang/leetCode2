package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _694_NumberOfDistinctIslands {
	/*
	 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011

Given the above grid map, return 1.

 

Example 2:

11011
10000
00001
11011

Given the above grid map, return 3.

Notice that:

11
1

and

 1
11

are considered different island shapes, because we do not consider reflection / rotation.

 

Note: The length of each dimension in the given grid does not exceed 50.
	 */
	
	public int numberofDistinctIslands(int[][] grid) {
        // write your code here
		Set<String> set=new HashSet<>();
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1&&!visited[i][j]) {
					StringBuilder sb=new StringBuilder();
					dfs(sb,grid,i,j,visited);
					set.add(sb.toString());
				}
			}
		}
		
		return set.size();
    }
	
	int[][] dirs=new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
	private void dfs(StringBuilder sb,int[][] grid,int x,int y,boolean[][] visited) {
		if(x<0||grid.length<=x||y<0||grid[0].length<=y||grid[x][y]==0||visited[x][y]) {
			sb.append(",");
			return;
		}
		
		visited[x][y]=true;
		for(int[] dir:dirs) {
			dfs(sb,grid,x+dir[0],y+dir[1],visited);
			sb.append(dir.toString());
		}
	}
}
