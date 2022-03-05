public class 1706 {
	
}
/* 
corner case m==n==1

[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
*/
class Solution {
    public int[] findBall(int[][] grid) {
	int m=grid.length,n=grid[0].length;
	int[] res=new int[n];
	for(int i=0;i<n;i++){
		int x=0, y=i;
		for(int j=0;j<m;j++){
			if((grid[x][y]==1)&&(y==n-1) ||
				(grid[x][y]==-1)&&(y==0) ||
				grid[x][y]==1&&(y<n-1)&&grid[x][y+1]==-1 ||
				grid[x][y]==-1&&(0<y)&&grid[x][y-1]==1){
				
					res[i]=-1;
					break;
			}

			if(grid[x][y]==1){
				y++;
			}else{
				y--;
			}
			x++;
		}
		res[i]=1;//会把-1重置为1；题目要求输出列数，而不是1，所以需要res[i]=y
	}
	return res;
    }
}