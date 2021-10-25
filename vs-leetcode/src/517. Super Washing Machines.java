public class 517. Super Washing Machines {
	
}
/* You have n super washing machines on a line. 
Initially, each washing machine has some dresses or is empty.

For each move, you could choose any m (1 <= m <= n) washing machines, 
and pass one dress of each washing machine to one of its adjacent washing machines at the same time.

Given an integer array machines representing 
the number of dresses in each washing machine from left to right on the line, 
return the minimum number of moves to make all the washing machines 
have the same number of dresses. 
If it is not possible to do it, return -1.

 

Example 1:

Input: machines = [1,0,5]
Output: 3
Explanation:
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2
Example 2:

Input: machines = [0,3,0]
Output: 2
Explanation:
1st move:    0 <-- 3     0    =>    1     2     0
2nd move:    1     2 --> 0    =>    1     1     1
Example 3:

Input: machines = [0,2,0]
Output: -1
Explanation:
It's impossible to make all three washing machines have the same number of dresses.
 

Constraints:

n == machines.length
1 <= n <= 104
0 <= machines[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/super-washing-machines
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
如果总衣服数不能被洗衣机数整除，就不能平均分配，返回-1.
反之，则总能通过移动，使衣服变得均匀。

根据时间复杂度，可知平方级的算法会超时。
如果想排除lng，那么要排除堆和二分。
二分也可以解决极值问题，


-----
确定了使用贪心算法之后，
*/
class Solution {
    public int findMinMoves(int[] machines) {

    }
}