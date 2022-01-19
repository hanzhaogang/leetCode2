public class 219 {
	    public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> val2index=new HashMap<>();//latest index
		for(int i=0;i<nums.length;i++){
			if(!val2index.containsKey(nums[i])){
				val2index.put(nums[i],i);
			}else{
				if(i-val2index.get(nums[i])<=k){
					return true;
				}else{
					val2index.put(nums[i],i);
				}
			}
		}
		return false;
    }	
}
