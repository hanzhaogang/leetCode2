/* Given an integer n, 
return true if it is a power of three. 
Otherwise, return false.

An integer n is a power of three, 
if there exists an integer x such that n == 3^x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
Example 4:

Input: n = 45
Output: false
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
这种取巧的方法，利用了题中给出的数据规模。
根据数据规模，发现3的幂序列为：3,9,27,81（4）,243,729（6），
1. 打表
找到所有的可能的3的幂，存储表中。
然后在表中查询即可。

2. 找到最大的3的幂max，看给定的n是否为max的因数。
问题是，如何找到这个max？ 感觉找到这个max的过程中，其实就是一个打表的过程了。

打表：是指通过事先计算出一些数值，作为常量写在代码中，以达到降低时间/空间复杂度、简化代码等目的一种解题方式。
常见的打表题如大数阶乘。
ACM 中遇到过题目数据范围比较小（或可能的合法输入比较少）时，
采取暴力算出所有解然后打成数组交上去的解题方式。

*/

class Solution {
    public boolean isPowerOfThree(int n) {
	if(n<=0)
		return false;
	return helper(n);
    }
    private boolean helper(int n){
	    if(n==1)
	    	return true;

	    if(n%3!=0)
	    	return false;
	    else{
		    n=n/3;
		    return helper(n);
	    }
    }

    public boolean isPowerOfThree(int n) {
	    if(n<=0)
		return false;
	    else{
		    while(1<n){
			    if(n%3!=0){
				    return false;
			    }else{
				    n/=3;
			    }
		    }
		    return true;
	    }

    }
}