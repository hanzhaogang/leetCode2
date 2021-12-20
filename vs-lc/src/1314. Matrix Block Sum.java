public class 1314. Matrix Block Sum {
	
}
/* Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.
 

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]
Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]
 

[1]
k=2;

preSum=
0 0 0 0
0 1 1 1
0 1 1 1
0 1 1 1

[]
Constraints:

m == mat.length
n == mat[i].length
1 <= m, n, k <= 100
1 <= mat[i][j] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matrix-block-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
	int[][] preSum=new int[mat.length+1+k][mat[0].length+1+k];
	for(int i=1;i<preSum.length;i++){
		for(int j=1;j<preSum[0].length;j++){
			preSum[i][j]=preSum[i][j-1]+preSum[i-1][j]+mat[i][j]-preSum[i-1][j-1];
		}
	}

	int[][] res=new int[mat.length][mat[0].length];
	for(int i=0;i<mat.length;i++){
		for(int j=0;j<mat[0].length;j++){
			res[i][j]=preSum[i+1+k][j+1+k]-preSum[i+1+k][j-k-1]-preSum[i-k-1][j+k]+preSum[i-k-1][j-k-1];
		}
	}

	return res;
    }
}