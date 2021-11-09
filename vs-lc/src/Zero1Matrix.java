
public class Zero1Matrix {

}


class Solution {
    public static final int MAX=10001;
    
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                res[i][j]=MAX;
        
        for(int i=0;i<res.length;i++)
            for(int j=0;j<res[0].length;j++)
                if(res[i][j]==MAX)
                    res[i][j]=matrix[i][j]==0? 0:dfsFrom(matrix,i,j,res);
        return res;
    }
     
}