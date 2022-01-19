public class 334 {
	/*
	1. bruck force n^3
	2. 
	[1,5,0,4,1,3]
	[1,2,1,3]
	*/
	    public boolean increasingTriplet(int[] nums) {
		    int min1=Integer.MAX_VALUE;
		    int min2=Integer.MAX_VALUE;
		    for(int i=0;i<nums.length;i++){
			    if(min2<nums[i])
			    	return true;
			    else if(min1<nums[i]&&nums[i]<min2){
				    min2=nums[i];
			    }else if(nums[i]<min1){
				    min1=nums[i];
			    }
		    }
		    return false;
    }	
}
