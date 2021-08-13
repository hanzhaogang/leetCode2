public class 233. Number of Digit One {
	
}/* Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 

Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-digit-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
根据数据规模判断，复杂度小于线性级别。
分析后感觉应该是一个找规律计算的数学问题。
但是在计算时，感觉太复杂，想到能不能使用递归呢？
现在的问题是，大概知道规律，但是不知道怎么具体去计算。

f(n)=小于等于n的数中包含的1的个数
if(n%2!=0) f(n)=f(n-1)+n中包含的1的个数
所以问题可以归结为n%2==0的n，即n为偶数。

f(n)=小于等于n的数中包含的1的个数。n%2==0
因为n为偶数，f(n/2)=
-----
f(n)=f(n/2)+(n/2)+f(n/2)+n%2==0?0:1q


---再一次用一个错误的case，得出了错误的结论！
应该多试几个不同的case。
*/
class Solution {
    public int countDigitOne(int n) {

    }
}