package fb2020;
import java.util.Random;

/*
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. 
 * You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
 */
public class _398_RandomPickIndex {
	int p;
	Random r;
	int[] nums;
    public Solution(int[] nums) {//[1,2,3,3,3]
    	p=0;
    	r=new Random();
    	this.nums=nums;
    }
    
    public int pick(int target) {
    	int p=0;
    	int count=0;
    	int res=-1;
    	while(p<nums.length) {
    		if(nums[p]==target) {
    			count++;
    			if(r.nextInt()%count==0) {
    				res=p;
    			}
    		}
   			p++;
    	}
    	
    	return res;
    }
}
