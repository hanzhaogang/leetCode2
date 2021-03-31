package leetcode;
/*
We partition a row of numbers A into ***at most*** K adjacent (non-empty) groups, 
  then our score is the sum of the average of each group. 
  What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input: 
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation: 
The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
* 
*/
public class _813_largestAvgSum {
	public static void main(String[] args) {
		_813_largestAvgSum s=new _813_largestAvgSum();
		int[] A=new int[] {4,1,7,5,6,2,3};
		int K=4;

		System.out.println(s.largestSumOfAverages(A, K));
	}
	
	double[][] memo;
	public double largestSumOfAverages(int[] A, int K) {
		memo=new double[A.length][K+1];//K+1
		for(int i=0;i<memo.length;i++) {
			for(int j=0;j<memo[0].length;j++) {
				memo[i][j]=-1;
			}
		}
		return helper(A,0,K);
	}
	
	private double helper(int[] A,int lo,int K) {//9 1 2 3 9 8 7 K=3
//		if(K<=0)
//			return 0;
		if(K==1) {//note the ending condition
			double sum=0;
			for(int i=lo;i<A.length;i++) {
				sum+=A[i];
			}
			return sum/(A.length-lo);//A.length-lo+1 is wrong, hi-lo+1 is right
		}
		
		if(memo[lo][K]!=-1) {
			return memo[lo][K];
		}
		double res=0;
		double preSum=0;
		for(int hi=lo;hi<=A.length-1-(K-1);hi++) {//hi not i; not ending condition.
			preSum+=A[hi];
			double cur=preSum/(double)(hi-lo+1)+helper(A,hi+1,K-1);//note boundary.
			if(res<cur)
				res=cur;
		}
		
		memo[lo][K]=res;
		return res;
	}
}



  
