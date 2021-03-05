package leetcode;

public class MS_200726_1 {
	public int solution(int[] A) {
		int n=A.length;
		
		int[] A1=new int[n];
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				A1[i]=0;
			}else {
				A1[i]=1;
			}
		}
		
		int[] A2=new int[n];
		for(int i=0;i<n;i++) {
			if(i%2==0){
				A2[i]=1;
			}else {
				A2[i]=0;
			}
		}
		
		int res1=0;
		for(int i=0;i<n;i++) {
			if(A[i]!=A1[i]) {
				res1++;
			}
		}
		int res2=0;
		for(int i=0;i<n;i++) {
			if(A[i]!=A2[i]) {
				res2++;
			}
		}
		
		return Math.min(res1, res2);
	}
}
