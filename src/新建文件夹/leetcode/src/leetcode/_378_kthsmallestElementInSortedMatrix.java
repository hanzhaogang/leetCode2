/*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= -109
All the rows and columns of matrix are guaranteed to be sorted in non-degreasing order.
1 <= k <= n2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class _378_kthsmallestElementInSortedMatrix {
    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

// 作者：jacksu1024
// 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
class Solution {//此解法没有利用矩阵的有序性。
    public int kthSmallest(int[][] matrix, int k) {
        IntComparator intComp=new IntComparator();
        Queue<Integer> q=new PriorityQueue(10,intComp);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.offer(matrix[i][j]);
            }
        }
        int result=0;
        for(int i=0;i<k;i++){
            result=q.remove();
        }
        return result;
    }
}

class IntComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer i1,Integer i2){
        return i1-i2;
    }
}