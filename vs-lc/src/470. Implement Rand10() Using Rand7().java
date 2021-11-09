public class 470. Implement Rand10() Using Rand7() {
	
}

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int gen=0;
	while(true){
		int prefix=(rand7()-1)*7+rand7();//1-49
		if(prefix<=40)
			return prefix%10+1;
		else{//41-49
			int prefix_2=(prefix-40-1)+rand7();//0-8;1-7
			if(prefix_2<=10){
				return prefix_2;
			}else{//11-15
				int prefix_3=prefix_2-10-1+rand7();//0-4;1-7
				if(prefix_3<=10){
					return prefix_3;
				}
			}
		}
	}
	
    }
}
/* Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.

Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
 

Example 1:

Input: n = 1
Output: [2]
Example 2:

Input: n = 2
Output: [2,8]
Example 3:

Input: n = 3
Output: [3,8,10]
 

Constraints:

1 <= n <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：

这是一道数学题，不能用常规套路求解。
看数据规模也看不出端倪。

对付数学题，我一般的招数就是找规律。
最终没能解决。

看了题解后，发现本题一个重要预备知识是拒绝采样。
就是说，假如你可以均匀概率地生成任意一个大于10的数的均匀概率随机生成器，
那么通过拒绝采样就可以生成针对10的随机生成器。

而最小的、满足有要求的数字，就是7进制的2位数。

*/
