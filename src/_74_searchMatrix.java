package leetCode;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than 
    the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class _74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0||matrix[0].length==0)
    		return false;
    	int m=matrix.length;//3
    	int n=matrix[0].length;//4
    	return bs(matrix,target,0,0,m-1,n-1);//2,3
    }
    
    private boolean bs(int[][] matrix,int target,
    					int lo_row,int lo_col,int hi_row,int hi_col) {//0023
    	if( (hi_row<lo_row) ||
    			(hi_row==lo_row) && (hi_col<lo_col) )
    		return false;
    	
    	int loIndex=lo_row*matrix[0].length+lo_col;//0
    	int hiIndex=hi_row*matrix[0].length+hi_col;//11
    	int midIndex=loIndex+(hiIndex-loIndex)/2;//5
    	int mid_row=midIndex/matrix[0].length;//1
    	int mid_col=midIndex%matrix[0].length;//1
    	int mid_val=matrix[mid_row][mid_col];//11
    	if(mid_val==target)
    		return true;
    	else if(target<mid_val) {
    		int preIndex=midIndex-1;
    		int pre_row=preIndex/matrix[0].length;
    		int pre_col=preIndex%matrix[0].length;
    		return bs(matrix,target,lo_row,lo_col,pre_row,pre_col);
    	} else {
    		int sucIndex=midIndex+1;//
    		int suc_row=sucIndex/matrix[0].length;
    		int suc_col=sucIndex%matrix[0].length;
    		return bs(matrix,target,suc_row,suc_col,hi_row,hi_col);
    	}
    }
}
