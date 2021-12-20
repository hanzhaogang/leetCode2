public class 474. Ones and Zeroes {
	
}

/*
ou are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ones-and-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路:

首先考虑dp的类型，是不是区间DP？

最大subset个数f(strs，待排列的集合的lo，待排列的集合的hi,m,n)=
max(1+f(strs,选择index=0的str,m`,n`),f()+, .....1+)

每次从数组strs中选择一个str，可以选择以下index：0,1，。。。。n-1，
当做出一个选择后，区间可以划分成被选择点划分成的两个区间。
但是这个时候是没有办法决定m，n的取值的。所以区间DP不适合。

strs就是物品的集合，有n个物品，每个物品的价值是相同的，现在的问题是如何选择物品，使得得到的价值最大。

原来的背包问题，是有一个容量，然后每个物品占用一定的体积。
而这个问题，则是有两种容量，每个物品各占用一定的容量。
*/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

    }
}