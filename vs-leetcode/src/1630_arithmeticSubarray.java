import java.util.ArrayList;
import java.util.List;

public class 1630_subarray {
	
}
//[4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
	List<Boolean> res=new ArrayList<>();
	
	for(int i=0;i<l.length;i++){//0 1 2
	    int lo=l[i];
	    int hi=r[i];
	    int[] subArray=new int[hi-lo+1];//3
	    for(int j=0;j<subArray.length;j++){//0 1 2
		    subArray[j]=nums[lo+j];//4 6 5
	    }
	    boolean isAr=true;
	    Arrays.sort(subArray);
	    int diff=subArray[1]-subArray[0];
	    for(int k=2;k<subArray.length;k++){
		if(subArray[k]-subArray[k-1]!=diff){
	            isAr=false;
		    break;
		}
		    
	    }
	    res.add(isAr);
	}
	return res;
    }
}

/* 示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
100
001
100
110

111
*/