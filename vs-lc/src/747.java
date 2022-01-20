public class 747 {
	 public int dominantIndex(int[] nums) {
		int m=0;
		for(int i=0;i<nums.length;i++){
			if(nums[m]<nums[i])
				m=i;
		}

		for(int i=0;i<nums.length;i++){
			if((i!=m)&&!(2*nums[i]<=nums[m]))
				return -1;
		}
		return m;
    }		
}
