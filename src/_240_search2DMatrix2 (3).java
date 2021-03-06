package leetCode;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
 */
public class _240_search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0)
    		return false;
    	return search(matrix,0,matrix[0].length-1,target);
    }
    
    private boolean search(int[][] matrix,int top,int right,int target){
    	if(top<0||matrix.length<=top||right<0||matrix[0].length<=right) {
    		return false;
    	}
    	
    	int trVal=matrix[top][right];
    	if(trVal==target) {
    		return true;
    	}else if(trVal<target) {
    		return search(matrix,top+1,right,target);
    	}else {
    		return search(matrix,top,right-1,target);
    	}
    	
    	
    }
}