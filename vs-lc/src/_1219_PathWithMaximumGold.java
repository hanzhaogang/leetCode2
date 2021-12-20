package leetCode;
/*
 * In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

    Every time you are located in a cell you will collect all the gold in that cell.
    From your position you can walk one step to the left, right, up or down.
    You can't visit the same cell more than once.
    Never visit a cell with 0 gold.
    You can start and stop collecting gold from any position in the grid that has some gold.

 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.

Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.

 

Constraints:

    1 <= grid.length, grid[i].length <= 15
    0 <= grid[i][j] <= 100
    There are at most 25 cells containing gold.
 */
public class _1219_PathWithMaximumGold {
	public static void main(String[] args) {
//		int[][] grid=new int[][] { {1,0,7},
//		                           {2,0,6},
//		                           {3,4,5},
//		                           {0,3,0},
//		                           {9,0,20}};
		int[][] grid=new int[][] {
			{1,0,7,0,0,0},
			{2,0,6,0,1,0},
			{3,5,6,7,4,2},
			{4,3,1,0,2,0},
			{3,0,5,0,20,0}

		};
		_1219_PathWithMaximumGold s=new _1219_PathWithMaximumGold();
		s.getMaximumGold(grid);
		System.out.print(s.res);
	}
	int m;
	int n;
//	int count;
	int res;
	public int getMaximumGold(int[][] grid) {
//		count=0;
		res=0;
		m=grid.length;
		n=grid[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]!=0) {
//					count=0;
					bt(0,grid,i,j,new boolean[m][n]);
				}
			}
		}
		
		return res;
    }
	
	int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	private void bt(int count,int[][] grid,int x,int y,boolean[][] visited) {
		if(x<0||m<=x||y<0||n<=y||visited[x][y]||grid[x][y]==0) {
			if(res<count)
				res=count;
			return;
		}
		
//		count+=grid[x][y];
		visited[x][y]=true;
		
		for(int[] dir:dirs) {
			bt(count+grid[x][y],grid,x+dir[0],y+dir[1],visited);
		}
		visited[x][y]=false;
		return;
	}
}
