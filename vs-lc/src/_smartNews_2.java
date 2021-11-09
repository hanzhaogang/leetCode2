package leetcode;

public class _smartNews_2 {

	public int solution(int[] A) {//[1] N==1
		int N=A.length;
		int[] dp=new int[N];// dp[i] longest ending at i
		//1 3 1 3 2 
		dp[0]=1;
		if(1<N) {
			dp[1]=2;
		}
		
		for(int i=2;i<N;i++) {
			if(A[i]==A[i-2]) {
				dp[i]=dp[i-1]+1;
			}else {
				dp[i]=2;
			}
		}
		
		int maxLen=1;
		for(int i=0;i<N;i++) {
			if(maxLen<dp[i])
				maxLen=dp[i];
		}
		return maxLen;
	}
}
