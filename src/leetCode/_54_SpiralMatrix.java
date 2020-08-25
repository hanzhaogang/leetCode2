package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _54_SpiralMatrix {
	
	public static void main(String[] args) {
		_54_SpiralMatrix s=new _54_SpiralMatrix();
		int[][] matrix=new int[][]{
		                            {1, 2, 3, 4},
		                            {5, 6, 7, 8},
		                            {9,10,11,12}
		                          };
		System.out.println(s.spiralOrder(matrix));
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res=new ArrayList<>();
		if(matrix.length==0)
			return res;			
		
		int[][] dirs=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		
		int row=matrix.length;
		int col=matrix[0].length;
		int rLo=0;
		int rHi=row-1;
		int cLo=0;
		int cHi=col-1;
		int rCur=0;
		int cCur=0;
		
		int dir=0;

		
		while(rLo<=rCur&&rCur<=rHi&&cLo<=cCur&&cCur<=cHi) {
			
			while(rLo<=rCur&&rCur<=rHi&&cLo<=cCur&&cCur<=cHi) {
				res.add(matrix[rCur][cCur]);
				rCur+=dirs[dir][0];
				cCur+=dirs[dir][1];
			}
			rCur-=dirs[dir][0];
			cCur-=dirs[dir][1];
		
			if(dir==0) {
				rLo++;
			}else if(dir==1) {
				cHi--;
			}else if(dir==2) {
				rHi--;
			}else
				cLo++;
			dir=(dir+1)%4;
			rCur+=dirs[dir][0];
			cCur+=dirs[dir][1];
		}
		return res;
    }
}
