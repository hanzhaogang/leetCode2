/*
求 1+2+...+n ，要求不能使用
乘除法、
for、while、
if、else、switch、case等关键字及条件判断语句（A?B:C）。

 

示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45
 

限制：

1 <= n <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/qiu-12n-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class jianzhiOffer_64 {
    
}
/*
思路：
for循环求解
或者利用公式n*(n+1)/2
（思考的时候，漏了一个递归求解！ f(n)=f(n-1)+n 
除了 if 和 switch 等判断语句外，是否有其他方法可用来终止递归？

1. 逻辑运算符的短路效应
需要实现 “当 n = 1 时终止递归” 的需求，可通过短路效应实现。


n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归

作者：jyd
链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

2. try catch 数组越界？

）

(n^2+n)/2
使用Math.power()库函数，应该也不行。
使用位操作代替乘2操作，n*n，


---参考别人思路
需要使用排除法一步步导向答案。
计算方法主要有三种：平均计算、迭代、递归。
*/
class Solution {
    int sum;
    public int sumNums(int n) {
        helper(n);
        return sum;
    }

    private boolean helper(int n){
        boolean b=(1<n)&&helper(n-1);
        sum+=n;
        return b;
    }
}