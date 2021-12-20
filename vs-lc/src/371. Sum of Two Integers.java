public class 371. Sum of Two Integers {
	
}
/* Given two integers a and b, 
return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
一开始考虑转换为2进制，但是每一位最终还是需要相加的。
++是不是也不符合要求呢？
同时可以思考为什么限制数据规模在-1000到1000呢？
---
考虑以下公式：
2^a*2^b=2^（a+b） =》 a+b=lg（2^a*2^b）。
这是利用了一些数学知识，也就是高级运算本质上是可以与低级运算等价的。
或者说，+ -是基本运算，* /是+ -的高级运算，幂、对数是* /运算的高级运算，这些运算本质上是可以相互转换的。

需要问清楚，是否允许使用java Math中的库函数？
*/
class Solution {
    public int getSum(int a, int b) {

    }
}