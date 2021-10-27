public class 240. Search a 2D Matrix II {
	
}
/* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路:
从右上角的元素【0，n-1】开始查找。

int x=0,y=n-1;
主循环：
while matrix[x,y]<t
x++;
while t<matrix[x,y]
y--;
退出主循环的条件是走到矩阵外面（没找到）；或者找到==t的值、提前退出


test case可以设置3种:
只有一个元素（==t & ！=t）
题目中的两个case


---
在主循环中嵌套while循环的做法是错误的。*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
	int m=matrix.length,n=matrix[0].length;
	int x=0,y=n-1;
	while(0<=x&&x<m&&0<=y&&y<n){
		if(matrix[x][y]==target){
			return true;
		}
		while(0<=x&&x<m&&0<=y&&y<n&&matrix[x][y]<target){
			x++;
		} 
		while(0<=x&&x<m&&0<=y&&y<n&&target<matrix[x][y]){
			y--;
		}
	}
	return false;
    }
}
