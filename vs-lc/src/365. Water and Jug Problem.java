public class 365. Water and Jug Problem {
	
}
/* You are given two jugs水壶 with capacities jug1Capacity and jug2Capacity liters升. 
There is an infinite amount of water supply available. 
Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, 
you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.

Pour water from one jug into another till the other jug is completely full, 
or the first jug itself is empty.
 

Example 1:

Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 
Example 2:

Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 

Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/water-and-jug-problem
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：

递归：
假如可以测量，那么最后可以测量的状态为：
j1包含w1（0,1，。。。c1），j2包含t-w1（）；

canMeasure（c1，c2，t，0,0）=canMearsure(c1,c2,)
-----
状态&操作
用j1和j2中的水量来表示当前状态（w1，w2）。初始状态是（0,0）。
从初始状态出发，可以进行下面的操作：
1. 把其中一个jug灌满；
2. 把其中一个jug清空；
3. 

问题抽象为： 
是否可以从初始状态出发，通过合法的操作，走到这样的一个状态：（w1，w2），使得w1+w2=targetCapacity。





这种应用类型的题目，首先需要抽象，把它抽象成一个数学问题，或者我们称之为建模。




本题可以使用深度优先搜索来解决。
搜索中的每一步以 remain_x, remain_y 作为状态，即表示 X 壶和 Y 壶中的水量。
在每一步搜索时，我们会依次尝试所有的操作，递归地搜索下去。
这可能会导致我们陷入无止境的递归，
因此我们还需要使用一个哈希结合（HashSet）存储所有已经搜索过的 remain_x, remain_y 状态，
保证每个状态至多只被搜索一次。


这一类游戏相关的问题，用人脑去想，是很难穷尽所有的可能的情况的。
因此很多时候需要用到「搜索算法」。

「搜索算法」一般情况下是在「树」或者「图」结构上的「深度优先遍历」或者「广度优先遍历」。
因此，在脑子里，更建议动手在纸上画出问题抽象出来的「树」或者「图」的样子。

在「树」上的「深度优先遍历」就是「回溯算法」，
在「图」上的「深度优先遍历」是「flood fill」 算法，深搜比较节约空间。
这道题由于就是要找到一个符合题意的状态，我们用广搜就好了。
这是因为广搜有个性质，一层一层像水波纹一样扩散，路径最短。

所谓「状态」，就是指当前的任务进行到哪个阶段了，可以用变量来表示，怎么定义状态有的时候需要一定技巧，
这道题不难。
这里分别定义两个水壶为 A 和 B，定义有序整数对 (a, b) 表示当前 A 和 B 两个水壶的水量，它就是一个状态。



两种方法： 
1. 
2. 数学法
*/

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

    }
}