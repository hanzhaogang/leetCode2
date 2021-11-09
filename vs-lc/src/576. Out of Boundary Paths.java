import java.util.HashMap;
import java.util.Map;

public class 576. Out of Boundary Paths {
	
}

class Solution {
	int m;
	int n;
	Map<String,Long> map;
	int[][] dirs;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
	this.m=m;
	this.n=n;
	map=new HashMap<String,Long>();
	dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	return (int)(helper(maxMove,startRow,startColumn)%((long)((long)Math.pow(10.0,9.0)+7L)));
    }

    private long helper(int leftMove,int x,int y){
	if(leftMove==0&&0<=x&&x<m&&0<=y&&y<n){
		return 0L;
	}else if(!(0<=x&&x<m&&0<=y&&y<n)){
		return 1L;
	}

	long res=0;
	for(int[] dir:dirs){
		String key=leftMove-1+","+x+dir[0]+","+y+dir[1];
		if(!map.containsKey(key)){
			long value=helper(leftMove-1,x+dir[0],y+dir[1]);
			map.put(key,value);
		}
			
		res+=map.get(key);
	}
	return res%(long)((long)Math.pow(10.0,9.0)+7L);
    }
}

/*There is an m x n grid with a ball. 
The ball is initially at the position [startRow, startColumn]. 
You are allowed to move the ball to one of the four adjacent cells in the grid 
(possibly out of the grid crossing the grid boundary). 
You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, 
return the number of paths to move the ball out of the grid boundary. 
Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/out-of-boundary-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
首先想到递归。
f(maxMove，x,y)=f(maxMove-1,x+1,y)+f(maxMove-1,x,y+1)+f(maxMove-1,x,y-1)+f(maxMove-1,x-1,y)

感觉有重叠的子问题。但是是3维的，如何填表呢？
*/