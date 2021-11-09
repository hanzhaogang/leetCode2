/*Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n^2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 

Constraints:

0 <= nums.length <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-of-range-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：

理解题目： 因为range 的选择有n^2种，所以暴力解法的复杂度为n^2(需要使用preSum).

根据数据规模，需要至少nlogn的解法。

range sum的题目可以考虑利用preSum数组。
preSum=[-2,3,2], 但是这不能减少range的选择呀！ 

因为求的是数量，而不是每一个range。所以感觉并不一定选择所有的range。






设前缀和数组为preSum，则问题等价于求所有的下标对 (i,j)，满足

\textit{preSum}[j] - \textit{preSum}[i] \in [\textit{lower}, \textit{upper}]
preSum[j]−preSum[i]∈[lower,upper]

我们先考虑如下的问题：给定两个升序排列的数组 n_1, n_2n 
1
​	
 ,n 
2
​	
 ，试找出所有的下标对 (i,j)(i,j)，满足

n_2[j] - n_1[i] \in [\textit{lower}, \textit{upper}]
n 
2
​	
 [j]−n 
1
​	
 [i]∈[lower,upper]

在已知两个数组均为升序的情况下，这一问题是相对简单的：我们在 n_2n 
2
​	
  中维护两个指针 l,rl,r。起初，它们都指向 n_2n 
2
​	
  的起始位置。

随后，我们考察 n_1n 
1
​	
  的第一个元素。首先，不断地将指针 ll 向右移动，直到 n_2[l] \ge n_1[0] + \textit{lower}n 
2
​	
 [l]≥n 
1
​	
 [0]+lower 为止，此时， ll 及其右边的元素均大于或等于 n_1[0] + \textit{lower}n 
1
​	
 [0]+lower；随后，再不断地将指针 rr 向右移动，直到 n_2[r] > n_1[0] + \textit{upper}n 
2
​	
 [r]>n 
1
​	
 [0]+upper 为止，则 rr 左边的元素均小于或等于 n_1[0] + \textit{upper}n 
1
​	
 [0]+upper。故区间 [l,r)[l,r) 中的所有下标 jj，都满足

n_2[j] - n_1[0] \in [\textit{lower}, \textit{upper}]
n 
2
​	
 [j]−n 
1
​	
 [0]∈[lower,upper]

接下来，我们考察 n_1n 
1
​	
  的第二个元素。由于 n_1n 
1
​	
  是递增的，不难发现 l,rl,r 只可能向右移动。因此，我们不断地进行上述过程，并对于 n_1n 
1
​	
  中的每一个下标，都记录相应的区间 [l,r)[l,r) 的大小。最终，我们就统计得到了满足条件的下标对 (i,j)(i,j) 的数量。

在解决这一问题后，原问题就迎刃而解了：我们采用归并排序的方式，能够得到左右两个数组排序后的形式，以及对应的下标对数量。对于原数组而言，若要找出全部的下标对数量，只需要再额外找出左端点在左侧数组，同时右端点在右侧数组的下标对数量，而这正是我们此前讨论的问题。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

    }
}

/*依然考虑前缀和数组 \textit{preSum}preSum。

对于每个下标 jj，以 jj 为右端点的下标对的数量，就等于数组 \textit{preSum}[0..j-1]preSum[0..j−1] 中的所有整数，出现在区间 [\textit{preSum}[j]-\textit{upper}, \textit{preSum}[j]-\textit{lower}][preSum[j]−upper,preSum[j]−lower] 的次数。故很容易想到基于线段树的解法。

我们从左到右扫描前缀和数组。每遇到一个数 \textit{preSum}[j]preSum[j]，我们就在线段树中查询区间 [\textit{preSum}[j]-\textit{upper}, \textit{preSum}[j]-\textit{lower}][preSum[j]−upper,preSum[j]−lower] 内的整数数量，随后，将 \textit{preSum}[j]preSum[j] 插入到线段树当中。

注意到整数的范围可能很大，故需要利用哈希表将所有可能出现的整数，映射到连续的整数区间内

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/