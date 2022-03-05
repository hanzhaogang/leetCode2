import java.util.ArrayList;
import java.util.List;

public class 1601 {
	
}
/* requests个数是16,可以选取的requests列表的可能数目是2^16。 然后判断给列表是否满足要求，复杂度O(16+20）。
总复杂度O(2^16*20)=65535*20=1300,000，10^7 

3
[
	[0,2]
	[1,1][1,2],[1,2],,[1,2]]
	[2,2], ,[2,1],
	
	
	
	3
[[1,2],[1,2],[2,2],[0,2],[2,1],[1,1],[1,2]]*/

class Solution {
	int res=0;
    public int maximumRequests(int n, int[][] requests) {
	bt(new ArrayList<Integer>(),requests.length,0,requests,new int[20]);
	return res;
    }

    private void bt(List<Integer> reqList,int total,int cur,int[][] requests,int[] counter){
	if(cur==total){
		boolean b=true;
		for(int i=0;i<counter.length;i++){
			if(counter[i]!=0){
				b=false;
				break;
			}
		}
		if(b){
			if(res<reqList.size()){
				res=reqList.size();
			}
		}
		return;
	}

	reqList.add(cur);
	counter[requests[cur][0]]++;
	counter[requests[cur][1]]--;
	bt(reqList,total,cur+1,requests,counter);
	reqList.remove(reqList.size()-1);
	counter[requests[cur][0]]--;
	counter[requests[cur][1]]++;
	bt(reqList,total,cur+1,requests,counter);
    }
}