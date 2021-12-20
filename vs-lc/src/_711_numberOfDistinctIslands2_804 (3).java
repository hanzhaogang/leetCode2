package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a non-empty 2D array grid of 0's and 1's, 
 * an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. 
An island is considered to be the same as another 
if they have the same shape, 
or have the same shape after rotation (90, 180, or 270 degrees only) 
or reflection (left/right direction or up/down direction).

The length of each dimension in the given grid does not exceed 50.
Have you met this question in a real interview?  
Example

Example 1:

Input: [[1,1,0,0,0],[1,0,0,0,0],[0,0,0,0,1],[0,0,0,1,1]]
Output: 1
Explanation:
The island is look like this:
11000
10000
00001
00011

Notice that:
11
1
and
 1
11
are considered same island shapes. 
Because if we make a 180 degrees clockwise rotation on the first island, 
then two islands will have the same shapes.

Example 2:

Input: [[1,1,1,0,0],[1,0,0,0,1],[0,1,0,0,1],[0,1,1,1,0]]
Output: 2
Explanation:
The island is look like this:
11100
10001
01001
01110

Here are the two distinct islands:
111
1
and
1
1

Notice that:
111
1
and
1
111
are considered same island shapes. 
Because if we flip the first array in the up/down direction, 
then they have the same shapes.

https://github.com/grandyang/leetcode/issues/285
 */
public class _711_numberOfDistinctIslands2_804 {
	public static void main(String[] args) {
		int[][] grid=new int[][] {{1,1,1,1},
								  {1,0,1,0},
								  {0,0,0,0},
								  {0,1,1,1},
								  {1,1,0,1}};
		_711_numberOfDistinctIslands2_804 s=new 
				_711_numberOfDistinctIslands2_804();
		System.out.println(s.numDistinctIslands2(grid));
		/* 0,0;0,1;0,2;0,3;
		 * 1,0;
		 * 
		 * 0,0;0,1;0,2;
		 * 1,-1;1,0;1,2;
		 */
	}
	int m;
	int n;
	public int numDistinctIslands2(int[][] grid) {
		m=grid.length;
		n=grid[0].length;
		boolean[][] visited=new boolean[m][n];
    	
    	Set<String> set=new HashSet<>();
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(!visited[i][j]&&grid[i][j]==1) {
    				List<int[]> island=new ArrayList<>();
    				dfs(grid,i,j,i,j,visited,island);
    				String presentation=getPresentation(island);
    				set.add(presentation);
    			}
    		}
    	}
    	
    	return set.size();
    }
    
    int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int[][] grid,int oriX,int oriY,
    				int x,int y,boolean[][] visited,
    				List<int[]> island) {
    	if(x<0||m<=x||y<0||n<=y||visited[x][y]||grid[x][y]==0) {
    		return;
    	}
    	
    	visited[x][y]=true;
    	island.add(new int[] {x-oriX,y-oriY});
    	for(int[] dir:dirs) {
    		dfs(grid,oriX,oriY,x+dir[0],y+dir[1],visited,island);
    	}
    }
    
    int[][] transs=new int[][] {{1,1},{1,-1},{-1,1},{-1,-1}};
    private String getPresentation(List<int[]> island) {
    	List<List<int[]>> islands=new ArrayList<>();
    	for(int[] trans:transs) {
    		List<int[]> i1=new ArrayList<>();
    		List<int[]> i2=new ArrayList<>();
    		for(int i=0;i<island.size();i++) {
    			int[] dot=island.get(i);
    			i1.add(new int[] {dot[0]*trans[0],dot[1]*trans[1]});
    			i2.add(new int[] {dot[1]*trans[1],dot[0]*trans[0]});
    		}
    		islands.add(i1);
    		islands.add(i2);
    	}
    	
    	List<String> newIslands=new ArrayList<>();
    	for(List<int[]> transformed:islands) {
    		Collections.sort(transformed,(i1,i2)->{
    			if(i1[0]+i1[1]==i2[0]+i2[1]) {
    				return i1[0]-i2[0];
    			}else {
    				return (i1[0]+i1[1])-(i2[0]+i2[1]);//==?
    			}
    		});
    		
    		List<int[]> newIsland=new ArrayList<>();
    		int diffX=0-transformed.get(0)[0];
    		int diffY=0-transformed.get(0)[1];
    		for(int[] dot:transformed) {
    			newIsland.add(new int[] {dot[0]+diffX,dot[1]+diffY});
    		}
    		StringBuilder sb=new StringBuilder();
    		for(int[] newDot:newIsland) {
    			sb.append(newDot[0]+","+newDot[1]+";");
    		}
    		newIslands.add(sb.toString());//int[] toString is wrong.
    	}
    	
    	Collections.sort(newIslands);
    	return newIslands.get(0);
    }
}