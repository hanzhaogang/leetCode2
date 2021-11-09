public class 407. Trapping Rain Water II {
	
}
/* Given an m x n integer matrix heightMap 
representing the height of each unit cell in a 2D elevation map, 
return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small pounds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
遍历每一个槽位，时间复杂度O(m*n).
遍历过程中，根据当前槽位的周围4个槽位的高度，确定能否存储雨水、能存储多少雨水。
时间复杂度应该OK。
--- 思路错误。能存多少雨水，周围4个槽位高度确定不了。
回想一维的接雨水问题，
单调递减栈可以找到每个元素的左边、右边第一个比它大的元素。

把题目给的3维图，转化为2维数组，数值表示该槽位的高度。

----
放弃，看题解后，有一个疑问：
BFS复杂度M^2*N^2，不会超时吗，40000*40000=1600000000,10^9了啊！

一点体会：
套路vs题意，还是以题意为本。要从题目本身入手，在思考过程中尝试套路。而不是直接拿套路尝试去套题目。
拿本题来说，我上来就想用一维接雨水的思路来套本题，想到了槽位的上下左右4个最高槽位。最后也想到了木桶原理。
但是还是没做出来。
如果一开始从题目本身入手思考，会不会好一点呢。

另外，堆这个思路，根据数据规模也可以推测出来。
但是从堆也很难推出解题方法，还是需要从题目本身入手。
*/
class Solution {
    public int trapRainWater(int[][] heightMap) {

    }
}