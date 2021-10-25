public class 476. Number Complement {
	
}
/* The complement of an integer is the integer you get 
when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), 
and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), 
and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 231
 

Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-complement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
按位取反的话，5（101）会变成111.。。010，与想要的结果 000.。。010不符合。
需要先得到111.。。101，然后取反，才会变成想要的结果。
想得到的111.。。101，可以把5和111.。。000（操作数）按位或。
想得到操作数，可以把5右移。
*/

class Solution {
    public int bitwiseComplement(int n) {
        
    }
}