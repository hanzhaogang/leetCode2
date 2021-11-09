/*698. Partition to K Equal Sum Subsets
Medium

743

48

Favorite

Share
Given an array of integers nums and a positive integer k, 
find whether it's possible to divide this array into k non-empty subsets 
whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: 
It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) 
with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
*/







public class LC0698_CanPartitionKSubsets{
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        if(sum%k!=0)
            return false;
        
        int subSum=sum/k;
        System.out.println(subSum);
        
        int oddSum=0;
        for(int i=0;i<nums.length;i++){
            if(subSum<nums[i])
                return false;
            
            if(nums[i]%2==1)
                oddSum++;
            
        }
        if(subSum%2!=0&&oddSum<k)
            return false;
        //if(subSum%2==0)
        return true;
    }
}
