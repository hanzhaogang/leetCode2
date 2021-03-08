package leetcode;

import java.util.List;

/*
 * You are given an integer array nums 
 * and you have to return a new counts array. 
 * 
 * The counts array has the property 
 * where counts[i] is the number of smaller elements to the right of nums[i].

		 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 

Constraints:

    0 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
*/
/* 思路： 首先看一下数据规模：
10^5 一般是nlogn可以通过。n^2不能通过。

再看解法：
如果采用暴力法，则刚好是n^2： 对于每一个元素，依次遍历它右边的所有元素。
而对于logn的复杂度，本题并无二分查找、树形结构的可能性。
所以基本判定可以用O(n)解决问题。

直觉上可以使用单调栈解决问题。但是之前遇到的单调栈问题都是找到某个元素，而不是计算个数。

如果先排序呢（想办法使数据集合有序呢）？ 1 6 2 5
也就是说，从后往前依次遍历数组元素，1的对应答案是0；然后把1放进一个大顶堆。考虑6时，对堆做弹出操作，直到堆顶元素小于6，此时堆大小就是答案。找到答案后再对堆做压入操作。
考虑2时，堆顶元素应该为6（1）. 考虑5时，堆顶元素应该为6（2,1）
*/
public class _315_countOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {

    }
}
