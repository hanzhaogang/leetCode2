package leetCode;
/*
 * Given a m x n matrix mat and an integer threshold. 
 * Return the maximum side-length of a square with a sum less than or equal to threshold 
 * or return 0 if there is no such square.

 

Example 1:

Input: mat = 
[
[1,1,3,2,4,3,2],
[1,1,3,2,4,3,2],
[1,1,3,2,4,3,2]],

 threshold = 4
 
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.

Example 2:

Input: mat = [
[2,2,2,2,2],
[2,2,2,2,2],
[2,2,2,2,2],
[2,2,2,2,2],
[2,2,2,2,2]], 

threshold = 1

Output: 0





Input: mat = [
[9,8,2,2,2],
[8,7,2,2,2],
[7,2,2,2,2],
[6,2,2,2,2],
[2,2,2,2,2]], 
threshold=18





Example 3:

Input: mat = [
[1,1,1,1],
[1,0,0,0],
[1,0,0,0],
[1,0,0,0]], 

threshold = 6
Output: 3

Example 4:

Input: mat = [
[18,70],
[61,1],
[25,85],
[14,40],
[11,96],
[97,96],
[63,45]], threshold = 40184
Output: 2

 

Constraints:

    1 <= m, n <= 300
    m == mat.length
    n == mat[i].length
    0 <= mat[i][j] <= 10000
    0 <= threshold <= 10^5
 */
public class _1292_MaximumSideLengthofaSquarewithSumLessthanorEqual2Threshold {
    public int maxSideLength(int[][] mat, int threshold) {
    	long[][] preSums=new long[mat.length][mat[0].length];
    	preSums[0][0]=mat[0][0];
    	for(int i=1;i<mat.length;i++) {
    		preSums[i][0]=preSums[i-1][0]+mat[i][0];
    	}
    	for(int j=1;j<mat[0].length;j++) {
    		preSums[0][j]=preSums[0][j-1]+mat[0][j];
    	}
    	for(int i=1;i<mat.length;i++) {
    		for(int j=1;j<mat[0].length;j++) {
    			preSums[i][j]=preSums[i-1][j]+preSums[i][j-1]-preSums[i-1][j-1]+mat[i][j];
    		}
    	}
    	
    	int maxSideLen=0;
    	for(int i=0;i<mat.length;i++) {
    		for(int j=0;j<mat[0].length;j++) {
    			for(int k=0;k<Math.min(mat.length, mat[0].length)-Math.max(i, j);k++) {
    				long totalSum=preSums[i+k][j+k]-
    								(j==0?0:preSums[i+k][j-1])-
    								(i==0?0:preSums[i-1][j+k])+
    										(i==0||j==0?0:preSums[i-1][j-1]);
    				if(totalSum<=threshold) {
    					int curSideLen=k+1;
    					if(maxSideLen<curSideLen)
    						maxSideLen=curSideLen;
    				}
    			}
    		}
    	}
    	
    	return maxSideLen;
    }
}
