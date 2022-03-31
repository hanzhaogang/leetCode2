public class 440 {
	
}
/* 

Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

 

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
Example 2:

Input: n = 1, k = 1
Output: 1
 

Constraints:

1 <= k <= n <= 109
*/

















































/* n最大1000000000
对于1开头的数：
1位：1个
2位：10个
3位：100个
4位：1000个
。。。

2开头、3开头。。。同理。

对于任意一个n，首先确定总位数d和首个数字k。它前面至少有：
首个数字为1、2、...k-1的、总位数为1、2、d-1的所有数字。

7836-》1836
*/
class Solution {
    public int findKthNumber(int n, int k) {
	int dc=0;
	int fd=0;
	int t=n;
	while(t!=0){
		t/=10;
		dc++;
		fd=t;
	}
	int[] cs=new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000};
	int c=0;
	int t1=0;
	int t2=0;
	for(int i=1;i<=fd;i++){
		for(int j=1;j<=dc;j++){
			c+=cs[j-1];
			if(k<c){
				t1=i;
				t2=j-1;
			}
		}
	}
    }
}