package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Given a matrix consists of 0 and 1, 
 * find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 Note:

    The number of elements of the given matrix will not exceed 10,000.
    There are at least one 0 in the given matrix.
    The cells are adjacent in only four directions: up, down, left and right.
    
    bfs on every node O(n^2)
    
    
 */
public class _542_01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
    	Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[0].length;j++) {
        		if(matrix[i][j]==0) {
        			q.offer(new int[] {i,j});
        			visited[i][j]=true;
        		}
        	}
        }
        
        int[][] res=new int[matrix.length][matrix[0].length];
        int lv=1;
        int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
        	int size=q.size();
        	for(int i=0;i<size;i++) {
        		int[] cur=q.poll();
            	for(int[] dir:dirs) {
            		int[] next=new int[] {cur[0]+dir[0],cur[1]+dir[1]};
            		if(0<=next[0]&&next[0]<matrix.length&&
            				0<=next[1]&&next[1]<matrix[0].length&&
            				!visited[next[0]][next[1]]) {
            			visited[next[0]][next[1]]=true;
            			res[next[0]][next[1]]=lv;
            			q.offer(next);
            		}
            	}
        	}
        	lv++;
        }
        
        return res;
    }
}
