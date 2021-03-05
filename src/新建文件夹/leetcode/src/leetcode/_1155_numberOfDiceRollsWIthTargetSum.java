package leetcode;
/*
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.



Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.

Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.

Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.

Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
*/
public class _1155_numberOfDiceRollsWIthTargetSum {
	long[][] memo;
	long mod=(1000000000L+7L);
	public int numRollsToTarget(int d, int f, int target) {
		memo=new long[d+1][target+1];
		for(int i=0;i<d+1;i++) {
			for(int j=0;j<target+1;j++) {
				memo[i][j]=-1L;
			}
		}
		long count=num(d,f,target);
		return (int)(count%mod);
	}
	
	private long num(int d,int f,int target) {
		if(d==1) {
			if(f<target)
				return 0;
			else
				return 1;
		}
//		if(d<target/f)
//			return 0;
		
		if(memo[d][target]!=-1L)
			return memo[d][target];
		
		long res=0;
		for(int i=1;i<=f&&i<target;i++) {//i!=target
			res+=num(d-1,f,target-i);
		}
		memo[d][target]=res%(mod);
		return memo[d][target];
	}
	/* 1. tareget vs t, don't rename it
	* 2. % will give a long var and we have to (int) it
	* 3. array bound, check it. 
	*/
}





