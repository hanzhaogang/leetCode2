package fb2020;
import java.util.LinkedList;
import java.util.Queue;

/*On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. 
At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square 
if and only if the elevation of both squares individually are at most t. 
You can swim infinite distance in zero time. 
Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). 
What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [
[0,2],
[1,3]]

Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else 
because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

Note:

    2 <= N <= 50.
    grid[i][j] is a permutation of [0, ..., N*N - 1].
    */
public class _778_swimInRisingWater {
	public static void main(String[] args) {
//		int[][] grid={{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		int[][] grid= {
		 {10,12,4,6},
		 {9,11,3,5},
		 {1,7,13,8},
		 {2,0,15,14}};		

		_778_swimInRisingWater s=new _778_swimInRisingWater();
		System.out.println(s.swimInWater(grid));
	}
    public int swimInWater(int[][] grid) {
    	int N=grid.length;//5
    	int lo=0;//13
    	int hi=N*N-1;//24
    	
    	while(lo<hi) {
    		int mid=lo+(hi-lo)/2;//12,18
    		if(mid==0&&canSwim(mid,grid,N)||!canSwim(mid-1,grid,N)&&canSwim(mid,grid,N)) {
    			return mid;
    		}else if(!canSwim(mid,grid,N)) {
    			lo=mid+1;//13
    		}else {
    			hi=mid-1;
    		}
    	}
    	
    	return lo;
    }
    
    private boolean canSwim(int t,int[][] grid,int N) {
    	int[][] tempGrid=new int[N][N];
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(grid[i][j]<t) {
    				tempGrid[i][j]=t;
    			}else {
    				tempGrid[i][j]=grid[i][j];
    			}
    		}
    	}
    	
    	if(t<tempGrid[0][0]) {
    		return false;
    	}
    	
    	Queue<int[]> q=new LinkedList<>();
    	tempGrid[0][0]=0-tempGrid[0][0];
    	q.offer(new int[] {0,0});
    	int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    	
    	while(!q.isEmpty()) {
    		int[] polled=q.poll();
    		if((polled[0]==N-1)&&(polled[1]==N-1)) {
    			return true;
    		}
    		
    		for(int[] dir:dirs) {
    			int nxt_x=polled[0]+dir[0];
    			int nxt_y=polled[1]+dir[1];
    			if(0<=nxt_x&&nxt_x<N&&0<=nxt_y&&nxt_y<N&&0<=tempGrid[nxt_x][nxt_y]&&tempGrid[nxt_x][nxt_y]<=t) {
    				tempGrid[nxt_x][nxt_y]=0-tempGrid[nxt_x][nxt_y];//visit
    				q.offer(new int[] {nxt_x,nxt_y});
    			}
    		}
    	}
    	
    	return false;
    }
}
