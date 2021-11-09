public class 335. Self Crossing {
	
}
/* You are given an array of integers distance.

You start at point (0,0) on an X-Y plane and 
you move distance[0] meters to the north, 
then distance[1] meters to the west, 
distance[2] meters to the south, 
distance[3] meters to the east, and so on. 
In other words, after each move, your direction changes counter-clockwise.

Return true if your path crosses itself, and false if it does not.

 

Example 1:


Input: distance = [2,1,1,2]
Output: true
Example 2:


Input: distance = [1,2,3,4]
Output: false
Example 3:


Input: distance = [1,1,1,1]
Output: true
 

Constraints:

1 <= distance.length <= 105
1 <= distance[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/self-crossing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
首先深挖题意，如何判断self crossing？
采用模拟法，遍历distance数组，针对每一步distance[i]，判断它是否穿过了已有的某一条边。如何判断？
采用某种数据结构存储之前走过的边，针对当前边，遍历一遍之前走过的边，看是否穿过：
穿过等价于： 当前边的点值落在走过边的区间值之间、同时走过边的点值落在当前边的区间值之间。
同时要注意，当前边与它的前驱边虽然满足等价条件，但是不能判为穿过。

复杂度：n*n。数据规模为10^5,会超时。需要比平方级更低的复杂度。

分析发现，当前边如果穿过之前的边，只可能穿过其前驱边再前面的两个与前驱边平行的边。
所以该问题线性复杂度可解。

---
漏掉了一种相交的可能情况。
*/
class Solution {
    public boolean isSelfCrossing(int[] distance) {

    }
}