package fb2020;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * In a given 2D binary array A, there are two islands.  
 * (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  
(It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: A = [
[0,1],
[1,0]]
Output: 1

Example 2:

Input: A = [
[0,1,0],
[0,0,0],
[0,0,1]]
Output: 2

Example 3:

Input: A = [
[1,1,1,1,1],
[1,0,0,0,1],
[1,0,1,0,1],
[1,0,0,0,1],
[1,1,1,1,1]]
Output: 1

 [
 [0,1,0,0,0,0],
 [0,1,1,1,0,0],
 [0,0,0,0,0,0],
 [0,0,0,0,0,0],
 [0,0,0,0,0,0],
 [1,1,0,0,0,0]]

Constraints:

    2 <= A.length == A[0].length <= 100
    A[i][j] == 0 or A[i][j] == 1
 */
public class _934_ShortestBridge {
	
	public static void main(String[] args) {
		_934_ShortestBridge s=new _934_ShortestBridge();
		int[][] A= {
//{0,1,0},
//{0,0,0},
//{0,0,1}};
		    {0,1,0,0,0,0},
		    {0,1,1,1,0,0},
		    {0,0,0,0,0,0},
		    {0,0,0,0,0,0},
		    {0,0,0,0,0,0},
		    {1,1,0,0,0,0}};
		System.out.println(s.shortestBridge(A));
	}

   	int[][] dirs=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};//下上左右
   	boolean[][] dfsVisited;
    public int shortestBridge(int[][] A) {

    	int m=A.length;
    	int n=A[0].length;
    	int source_x=0;
    	int source_y=0;
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(A[i][j]==1) {
    				source_x=i;
    				source_y=j;
    			}
    		}
    	}
    	
    	//dfs to find every edge node.
    	dfsVisited=new boolean[m][n];
    	Set<String> island2=new HashSet<>();
    	dfs(A,source_x,source_y,island2);
    	
    	boolean[][] visited=new boolean[m][n];
    	Queue<String> q=new LinkedList<>();
    	for(String node2:island2) {
    		q.offer(node2);
    		visited[Integer.parseInt(node2.split(",")[0])][Integer.parseInt(node2.split(",")[1])]=true;
    	}
    	
    	int res=-1;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		for(int i=0;i<size;i++) {
    			String polledStr=q.poll();
        		int[] polled=new int[] {Integer.parseInt(polledStr.split(",")[0]),
        				Integer.parseInt(polledStr.split(",")[1])};
        		
        		if(A[polled[0]][polled[1]]==1) {
        			return res;
        		}
        		for(int[] dir:dirs) {
        			int nxt_x=polled[0]+dir[0];
        			int nxt_y=polled[1]+dir[1];
        			if(0<=nxt_x&&nxt_x<m&&0<=nxt_y&&nxt_y<n&&!visited[nxt_x][nxt_y]) {
        				visited[nxt_x][nxt_y]=true;
        				q.offer(nxt_x+","+nxt_y);
        			}
        		}
        	}
    		res++;
    	}
    		
    	
    	return res;
    }

    private void dfs(int[][] A,int x,int y,Set<String> node2) {
    	if(x<0||A.length<=x||y<0||A[0].length<=y||dfsVisited[x][y]) {
    		return;
    	}
    	if(A[x][y]==0)
    		return;
    	
    	dfsVisited[x][y]=true;
    	A[x][y]=2;
    	node2.add(x+","+y);
    	
    	for(int[] dir:dirs) {
    		dfs(A,x+dir[0],y+dir[1],node2);
    	}
    }
}