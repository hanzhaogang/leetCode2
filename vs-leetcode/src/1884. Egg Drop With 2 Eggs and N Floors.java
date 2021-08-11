public class 1884. Egg Drop With 2 Eggs and N Floors {
	
}
/* You are given two identical eggs 
and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n 
such that any egg dropped at a floor higher than f will break, 
and any egg dropped at or below floor f will not break.

In each move, you may take an unbroken egg and drop it from any floor x 
(where 1 <= x <= n). 
If the egg breaks, you can no longer use it. 
However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves 
that you need to determine with certainty what the value of f is.

 

Example 1:

Input: n = 2
Output: 2
Explanation: We can drop the first egg from floor 1 and the second egg from floor 2.
If the first egg breaks, we know that f = 0.
If the second egg breaks but the first egg didn't, we know that f = 1.
Otherwise, if both eggs survive, we know that f = 2.

Example 2:

Input: n = 100
Output: 14
Explanation: One optimal strategy is:
- Drop the 1st egg at floor 9. 
If it breaks, we know f is between 0 and 8. Drop the 2nd egg starting
  from floor 1 and going up one at a time to find f within 7 more drops. 
  Total drops is 1 + 7 = 8.
- If the 1st egg does not break, 
drop the 1st egg again at floor 22. If it breaks, we know f is between 9
  and 21. 
  Drop the 2nd egg starting from floor 10 and going up one at a time to find f within 12 more
  drops. 
  Total drops is 2 + 12 = 14.
- If the 1st egg does not break again, 
follow a similar process dropping the 1st egg from floors 34, 45,
  55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
Regardless of the outcome, it takes at most 14 drops to determine f.
 

Constraints:

1 <= n <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路： 
模拟法。

最优化问题，假设最少move次数为f(n)。
n层楼，第一个鸡蛋可以在1,2，。。。n层楼中的任意一层楼往下扔。
f(n)=1+


第2枚鸡蛋视为细粒度逐层验证

第1枚鸡蛋破碎后由第2枚鸡蛋检验 [bottom, i - 1] 区间
只能按 bottom, bottom + 1 ... i - 1 顺序逐层验证才能确保获得 f 确切的值
有了上面的鸡蛋操作规范，我们可以反向推导，假设对于 n 层楼计算并返回要确定 f 确切的值的最小操作次数为 M ， 我们可以有以下结论：

第一次操作必然选择在 x ≤ M 层，这里使用反证法：当 x > M ，
如果第一次操作后鸡蛋破碎，则转入第2枚鸡蛋任务，需要 x - 1 次操作逐层验证，总操作次数为 1 + (x - 1) = x > M ，
违背总操作次数为 M 的假设


第 k 次操作第1枚鸡蛋的覆盖层数必须小于等于 M - k + 1 ，原因同 1
综合(1, 2)的限制，可以得出 M 次操作可以覆盖的最大楼层数量为 Sum = M + (M - 1) + (M - 2) + ... + 1 = (M + 1) * M / 2
得到关系：(M + 1) * M / 2 ≥ n，则满足条件的 M 最小值即为最小操作次数，用数学方法求解即可：

作者：tang-bo-hu-dian-feng-xiang
链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/solution/dong-tai-gui-hua-shu-xue-tui-dao-by-tang-1zz1/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



class Solution {
    public int twoEggDrop(int n) {

    }
}