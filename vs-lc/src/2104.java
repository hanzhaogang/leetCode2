public class 2104 {
	
}
/* 1000 O（n) */
class Solution {
    public long subArrayRanges(int[] nums) {
	long res=0;
	for(int i=0;i<nums.length;i++){
		long min=nums[i];
		long max=nums[i];
		for(int j=i;j<nums.length;j++){
			if(nums[j]<min){
				min=nums[j];
			}
			if(max<nums[j]){
				max=nums[j];
			}
			res+=max-min;
		}
	}
	return res;
    }
}