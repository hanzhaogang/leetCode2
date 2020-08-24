package leetCode;

public class _smartNews_1 {
	private int row;
	private int col;
    public int solution(int[][] A) {//[[1]]
    	row=A.length;
    	col=A[0].length;
    	boolean[][] visited=new boolean[row][col];
    	int countryCount=0;
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(!visited[i][j]) {
    				dfs(A,i,j,A[i][j],visited);
    				countryCount++;
    			}
    		}
    	}
    	
    	return countryCount;
    }
    
    int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int[][] A,int x,int y,int color,boolean[][] visited) {
    	if(x<0||row<=x||y<0||col<=y||visited[x][y]||A[x][y]!=color) {
    		return;
    	}
    	
    	visited[x][y]=true;
    	
    	for(int[] dir:dirs) {
    		int nextX=x+dir[0];
    		int nextY=y+dir[1];
    		dfs(A,nextX,nextY,color,visited);
    	}
    }
}