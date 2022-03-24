public class 661 {
	
}


class Solution {
    public int[][] imageSmoother(int[][] img) {
	int m=img.length;
	int n=img[0].length;
	int[][] res=new int[m][n];
	int[][] dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			int sum=0;
			int c=0;
			for(int[] dir:dirs){
				int x=i+dir[0];
				int y=j+dir[1];
				if(0<=x&&x<m&&0<=y&&y<n){
					c++;
					sum+=img[x][y];
				}
			}
			res[i][j]=sum/c;
		}
	}
	return res;
    }
}