package leetcode;

public class _1292_maximumsidelengthofasquarewithsumlessthanorequaltothreshold {

}
/*
基本思想是前缀和+穷举。
需要注意的细节: 
前缀和矩阵的大小可以是(mat.length+1)*(mat[0].length+1),也就是比原矩阵分别多出一行和一列。这样的好处是省去了计算preSum矩阵的时候的判断，也省去了穷举的时候判断0的操作。

还可以使用二分查找法。二分正方形的边长，然后根据边长在矩阵中穷举，如果找到符合条件的，就往边长增加的方向继续二分；不然就往边长减小的方向二分。
*/
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
    	long[][] preSums=new long[mat.length+1][mat[0].length+1];
    	for(int i=0;i<mat.length;i++) {
    		for(int j=0;j<mat[0].length;j++) {
    			preSums[i+1][j+1]=preSums[i][j+1]+preSums[i+1][j]-preSums[i][j]+mat[i][j];
    		}
    	}
    	
    	int maxSideLen=0;
    	for(int i=0;i<mat.length;i++) {
    		for(int j=0;j<mat[0].length;j++) {
    			for(int k=0;k<Math.min(mat.length-i,mat[0].length-j);k++) {//?? k+1是矩阵的边长
    				long totalSum=preSums[i+1+k][j+1+k]-
    								preSums[i+1+k][j]-
    								preSums[i][j+1+k]+preSums[i][j];
    				if(totalSum<=threshold) {
    					int curSideLen=k+1;
    					if(maxSideLen<curSideLen)
    						maxSideLen=curSideLen;
    				}
    			}
    		}
    	}
    	
    	return maxSideLen;//31
    }
}

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        /*
         * 涉及知识点 ： 1、 前缀和  2、 容斥原理
         *              容斥原理：
         *                  正方形面积 = 已求出的矩形面积运算得出

         *                  sum[i][j] = mat[i][j] + sum[i - 1][j] + 
         *                              sum[i][j - 1] - sum[i - 1][j - 1]

         *                  1  1  1      1  1     1  1  1       1  1
         *                  1  1  1    = 1  1  +  1  1  1   -   1  1  +       
         *                  1  1  1      1  1                             1

         *                  ->  9 = 6 + 6 - 4 + 1
         *              前缀和：
         *                  计算所有位置面积以方便求解过程中使用         
         */
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[][] sum = new int[m + 1][n + 1];         

        // 根据容斥原理计算前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = mat[i - 1][j - 1] + sum[i][j - 1]
                            + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        // 根据所求出前缀和求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i && k <= j; k++) {  
                    // 从边长为1开始扩展正方形大小
                    int ans = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                    if (ans > threshold) {
                        break;
                    }
                    res = Math.max(res, k);
                }
            }
        }
        return res;
    }
}
