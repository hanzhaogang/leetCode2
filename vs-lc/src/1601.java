import java.util.ArrayList;
import java.util.List;

public class 1601 {
	
}
/* requests个数是16,可以选取的requests列表的可能数目是2^16。 然后判断给列表是否满足要求，复杂度O(16+20）。
总复杂度O(2^16*20)=65535*20=1300,000，10^7 */

class Solution {
	int res=0;
    public int maximumRequests(int n, int[][] requests) {
	bt(new ArrayList<Integer>(),n,0,requests,new int[20]);
	return res;
    }

    private void bt(List<Integer> reqList,int n,int cur,int[][] requests,int[] counter){
	if(cur==n){
		boolean b=true;
		for(int i=0;i<counter.length;i++){
			if(counter[i]!=0){
				b=false;
				break;
			}
		}
		if(b){
			res++;
		}
	}

	reqList.add(cur);
	counter[requests[cur][0]]++;
	counter[requests[cur][1]]--;
	bt(reqList,n,cur+1,requests,counter);
	reqList.remove(reqList.size()-1);
	counter[requests[cur][0]]--;
	counter[requests[cur][1]]++;
	bt(reqList,n,cur+1,requests,counter);
    }
}