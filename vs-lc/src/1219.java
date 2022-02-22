public class 1219 {
	
}
/* [[0,6,0],
    [5,8,7],
    [0,9,0]]*/
class Solution {
	int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int getMaximumGold(int[][] grid) {
	    int res=0;
	for(int i=0;i<grid.length;i++){
		for(int j=0;j<grid[0].length;j++){
			if(grid[i][j]!=0){
				int max=bt(i,j,grid,new boolean[grid.length][grid[0].length]);
				if(res<max){
					res=max;
				}
			}
		}
	}
	return res;
    }

    private int bt(int i,int j,int[][] grid,boolean[][] visited){
	    if(!(0<=i&&i<grid.length) || !(0<=j&&j<grid[0].length) || grid[i][j]==0 || visited[i][j]){
		return 0;
	    }
	    visited[i][j]=true;
	    int max=0;
	    for(int[] d:dir){
		int cur=bt(i+d[0],j+d[1],grid,visited);
		if(max<cur)
			max=cur;
	    }
	    visited[i][j]=false;
	    return grid[i][j]+max;
    }
}