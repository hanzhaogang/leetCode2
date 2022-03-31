public class 2028 {
	
}

/* f(sum,m)=

5,18
3,3,4,4,4*

4,9
2,2,2,3 */

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
	int sum=0;
	for(int roll:rolls){
		sum+=roll;
	}
	sum=mean*(rolls.length+n)-sum;
	if(sum<n || 6*n<sum)
		return new int[0];

	int[] res=new int[n];
	for(int i=0;i<n-sum%n;i++){
		res[i]=sum/n;
	}
	for(int i=n-sum%n;i<n;i++){
		res[i]=sum/n+1;
	}
	return res;
    }
}