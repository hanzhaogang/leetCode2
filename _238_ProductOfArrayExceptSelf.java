package leetCode;

public class _238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if(nums.length==2) {
			return new int[] {nums[1],nums[0]};
		}
		int[] leftPreSum=new int[nums.length];
		int[] rightPreSum=new int[nums.length];
		leftPreSum[0]=nums[0];
		rightPreSum[nums.length-1]=nums[nums.length-1];
		for(int i=1;i<nums.length;i++) {
			leftPreSum[i]=leftPreSum[i-1]*nums[i];
		}
		for(int i=nums.length-2;0<=i;i--) {
			rightPreSum[i]=rightPreSum[i+1]*nums[i];
		}
		
		int[] res=new int[nums.length];
		res[0]=rightPreSum[1];
		res[nums.length-1]=leftPreSum[nums.length-2];
		for(int i=1;i<res.length-1;i++) {
			res[i]=leftPreSum[i-1]*rightPreSum[i+1];
		}
		return res;
    }
}
