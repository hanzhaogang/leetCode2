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
14 1110 8+6
2^x<=n n<2^(x+1), 求2^x
x=(int)Math.floor(Math.log(n))

i=(int)Math.power(2,(int)Math.floor(Math.log(n)))
f(n)=f(i)+(n-i)+f(n-i)

0   0
1   1
2   10
3   11
4   100
5   101
6   110
7   111
8   1000


---- 1 digit!
审题出了问题。
先入为主地认为题目是什么意思，其实不是。

f(999)=f(900)+99*0+f(99)
=f(899)+f(90)+f(9)
=f(800)+f(99)+f(90)+f(9)
=f(799)+...
=f(900)+f(90)+f(9)

f(199)=f(100)++99*1+f(99)
f(183)=f(100)+83*1+f(83)
f(83)=f(80)+f(3)
f(80)=80包含1的位数+f(79)

f(211)=f(200)+f(11)
f(11)=f(10)+f(1)

*/
class Solution {
    public int countDigitOne(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0)
                dp[i]=0;
            else if(i==1)
                dp[i]=1;
            
            else{
                int k=(int)Math.pow(2.0,(double)Math.floor(Math.log(i)));//i=2;k=2
                if(i==k){
                    dp[i]=1+dp[i-1];
                }else{
                    dp[i]=dp[k]+i-k+dp[i-k];
                }
                
            }
        }
        return dp[n];
    }
}