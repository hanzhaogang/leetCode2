package leetcode;

import java.util.Arrays;

/*
 * Given a matrix of M x N elements 
 * (M rows, N columns), 
 * return all elements of the matrix in diagonal order 
 * as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.

 */
public class _498_diagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {//[]
		if(matrix==null||matrix.length==0||matrix[0].length==0)
			return new int[0];
		
		int m=matrix.length;
		int n=matrix[0].length;
		int[] res=new int[m*n];
		
		
		int[][] indexs=new int[m*n][2];
		int globalIndex=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				indexs[globalIndex++]=new int[] {i,j};
			}
		}
		Arrays.sort(indexs,(i1,i2)->{
			int sum1=i1[0]+i1[1];
			int sum2=i2[0]+i2[1];
			if(sum1!=sum2) {
				return Integer.compare(sum1, sum2);
			}else {
				if(sum1%2==0) {
					return Integer.compare(i2[0], i1[0]);
				}else {
					return Integer.compare(i1[0], i2[0]);
				}
			}
			
		});
		
		globalIndex=0;
		for(int[] index:indexs) {
			res[globalIndex++]=matrix[index[0]][index[1]];
		}
		return res;
	}
}
