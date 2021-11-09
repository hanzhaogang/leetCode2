package fb2020;
import java.util.Arrays;

public class _611_validTriangleNumber {
    public int triangleNumber(int[] nums) {
    	if(nums==null||nums.length<=2)
    		return 0;
    	// 2,2,3,4
        Arrays.sort(nums);
    	int res=0;
    	int n=nums.length;//4
    	for(int i=0;i<n-2;i++) {//0,1
            if(nums[i]==0)
    			continue;
    		
    		int j=i+1;//1,2
    		int k=i+2;//2,3
    		while(j<n-1) {
    			while(k<n&&nums[k]<nums[i]+nums[j]) {
    				k++;
    			}
    			res+=k-(j+1);
    			j++;
    		}
    	}
    	
    	return res;
    }
}