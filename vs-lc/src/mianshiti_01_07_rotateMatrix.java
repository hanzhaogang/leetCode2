public class mianshiti_01_07_rotateMatrix {
    
}
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return;

        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                int j_=matrix[0].length-1-j;
                int temp=matrix[i][j];

                matrix[i][j]=matrix[i][j_];
                matrix[i][j_]=temp;
            }
        }
    }
}
/*Given an image represented by an N x N matrix, 
where each pixel in the image is 4 bytes, 
write a method to rotate the image by 90 degrees. 
Can you do this in place?

 
[[1,2,3,4]
 [5,6,7,8]]
->
1 5
2 6
3 7
4 8
->

->
5 1
6 2
7 3
8 4

Example 1:

Given matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
->
1 4 7
2 5 8
3 6 9
->


Rotate the matrix in place. It becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

Rotate the matrix in place. It becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/