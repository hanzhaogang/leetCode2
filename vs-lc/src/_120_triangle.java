package leetCode;

import java.util.List;

/*
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
 */
public class _120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
    	for(int j=0;j<triangle.get(triangle.size()-1).size();j++) {
    		dp[triangle.size()-1][j]=triangle.get(triangle.size()-1).get(j);
    	}
    	
    	for(int i=triangle.size()-2;0<=i;i--) {
    		for(int j=0;j<triangle.get(i).size();j++) {
    			dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j], dp[i+1][j+1]);
    		}
    	}
    	return dp[0][0];
    }
}
