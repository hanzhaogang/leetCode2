package leetCode;

public class _200_NumberOfIslands {
	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), 
	 * count the number of islands. 
	 * 
	 * An island is surrounded by water and is formed by connecting adjacent lands 
	 * horizontally or vertically. 
	 * 
	 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
	 */
	
	int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
	int count=0;
	boolean[][] visited;
	public int numIslands(char[][] grid) {
		if(grid==null||grid.length==0)
			return 0;
		visited=new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1'&&visited[i][j]==false) {
					dfs(grid,i,j);
					count++;
				}
			}
		}
		return count;
    }
	
	private void dfs(char[][] grid,int x,int y) {
		if(x<0||grid.length<=x||y<0||grid[0].length<=y)
			return;
		
		if(grid[x][y]=='0'||visited[x][y])
			return;
		
		visited[x][y]=true;
		for(int[] dir:dirs) {
			dfs(grid,x+dir[0],y+dir[1]);
		}
	}
}
