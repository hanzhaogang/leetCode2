public class 668 {
	
}
/*
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

 

Example 1:


Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
Example 2:


Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.
 

Constraints:

1 <= m, n <= 3 * 104
1 <= k <= m * n
*/

class Solution {
    public int findKthNumber(int m, int n, int k) {//2,3,6
	int l=1,h=m*n;//6
	while(l<=h){//等于，不能漏
		int mid=l+(h-l)/2;//3,5
		if(k<=helper(mid,m,n)&& (mid-1==0 || helper(mid-1,m,n)<k) ){
			return mid;
		}else if(helper(mid,m,n)<k){
			l=mid+1;//4;6
		}else{
			h=mid-1;
		}
	}
	return 1;
    }
    // return numbers count of which in the table and less than or equal to input x
    private int helper(int x,int m,int n){//3,2,3;5,2,3
	int res=0;
	for(int i=1;i<=Math.min(x,n);i++){//1,2,3;
		res+=Math.min(m,x/i);//2vs 3,1,3;2 vs 5,2,1
	}
	return res;//5
    }
}