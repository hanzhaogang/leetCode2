/* f(n)=f(n,a)+f(n,e)+...
f(n,a)=f(n-1,e)
f(n,e)=f(n-1,a)+f(n-1,i)
f(n,i)=f(n-1,a)+f(n-1,e)+f(n-1,o)+f(n-1,u)
f(n,o)=f(n-1,i)+f(n-1,u)
f(n,u)=f(n-1,a)*/
public class 1220 {
	public int countVowelPermutation(int n) {
		int m=1000000000+7;
		long[][] dp=new long[n][5];
		for(int i=0;i<n;i++){
			for(int j=0;j<5;j++){
				if(i==0){
					dp[i][j]=1;
				}else if(j==4){
					dp[i][j]=dp[i-1][0];
				}else if(j==3){
					dp[i][j]=(dp[i-1][j+1]+dp[i-1][j-1])%m;
				}else if(j==2){
					dp[i][j]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+dp[i-1][4])%m;
				}else if(j==1){
					dp[i][j]=(dp[i-1][0]+dp[i-1][2])%m;
				}else if(j==0){
					dp[i][j]=dp[i-1][1];
				}
			}
		}
		long res=0;
		for(int j=0;j<5;j++){
			res+=dp[n-1][j];
		}
		return (int)(res%m);
    }
}
