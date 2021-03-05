/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 10^4
s[i] is '(', or ')'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class _32_LongestValidParentheses {
    
}
/*思路：
0. 首先要注意审题，注意是substring，不是subsequence。找到所有的subsequence需要2^n指数级时间复杂度，而找到所有的substring只需要n^2
1. BF， 找到所有的substring，针对每个substring判定其是否valid，进而找到最长的valid substring的长度。时间复杂度n^3。
   因为数据规模3*10^4,所以时间复杂度应该在nlogn级别。 
   因为字符串问题难以找到logn级别算法，所以推测应该有线性时间复杂的解法。
   括号对问题一般可以通过stack解决。考虑是否可以通过一遍出栈入栈操作得到解。（？？？）

   ()(()()()
   首先出栈入栈一次，找到
   */
class Solution {
    public int longestValidParentheses(String s) {
        
    }
}