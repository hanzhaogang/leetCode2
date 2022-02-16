public class 1020 {
	
}
/* 不能把c和b当做dfs的参数，因为java中primative类型是值传递，不是引用传递。
[
	
[0,0,0,0],
[1,0,1,0],
[0,1,1,0],
[0,0,0,0]]*/
class Solution {
	int res=0;
	boolean[][] visited;
	int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	int m,n;
	int c=0;
	boolean b=false;
	public int numEnclaves(int[][] grid) {
		m=grid.length;
		n=grid[0].length;
		visited=new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1&&!visited[i][j]){
					dfs(i,j,visited,grid);
					if(!b){
						res+=c;
					}
					b=false;
					c=0;
				}
			}
		}
		return res;
	}			
    private void dfs(int i,int j,boolean[][] visited,int[][] grid){
	
	if(!(0<=i&&i<m)||!(0<=j&&j<n)|| grid[i][j]==0 ||  visited[i][j]){
		return;
	}
	
	visited[i][j]=true;
	if(i==0||i==m-1||j==0||j==n-1){
		b=true;
	}
	c++;

	for(int[] dir:dirs){
		dfs(i+dir[0],j+dir[1],visited,grid);
	}
    }
}