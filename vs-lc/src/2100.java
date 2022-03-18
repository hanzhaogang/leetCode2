import java.util.ArrayList;
import java.util.List;

public class 2100 {
	
}

/* */
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
	int n=security.length;
	int[] l2r=new int[n];
	for(int i=n-1;0<=i;i--){
		if(i==n-1 || !(security[i]<=security[i+1]) ){
			l2r[i]=0;
		}else{
			l2r[i]=l2r[i+1]+1;
		}
	}

	int[] r2l=new int[n];
	for(int i=0;i<n;i++){
		if(i==0 || !(security[i]<=security[i-1]) ){
			r2l[i]=0;
		}else{
			r2l[i]=r2l[i-1]+1;
		}
	}

	List<Integer> res=new ArrayList<>();
	for(int i=time;i<n-time;i++){
		if(time<=l2r[i] && time<=r2l[i]){
			res.add(i);
		}
	}
	return res;
    }
}