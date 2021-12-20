import java.util.List;

/*Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero. 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. 
 * (ie, a ¡Ü b ¡Ü c) The solution set must not contain duplicate triplets.
 */

/*
 * 1. brute force
 * TC:O(n^3)
 * 
 * 2. 
 */
public class LC0015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
	
	}
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort
        Arrays.sort(nums);
        /*for nums[i], find two sum -nums[i] using two pointers, 
        jumping duplicate ones
        O(n^2)*/
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(0<i&&nums[i]==nums[i-1]){
                continue;
            }
                
            int lo=i+1,hi=nums.length-1;
            while(lo<hi){
                if(nums[lo]+nums[hi]==0-nums[i]){
                    List<Integer> curTriplets=Arrays.asList(new Integer[]{nums[lo],nums[hi],nums[i]});
                    /*curTriplets.add(nums[p1]);
                    curTriplets.add(nums[p2]);
                    curTriplets.add(nums[i]);*/
                    res.add(curTriplets);
                    do{
                        lo++;
                    }while(lo<nums.length&&curTriplets.get(0)==nums[lo]);
                    do{
                        hi--;    
                    }while(0<=hi&&curTriplets.get(1)==nums[hi]);
                    
                }else if(nums[lo]+nums[hi]<0-nums[i])
                    lo++;
                else
                    hi--;
            }
        }
        
        return res;
    }
}

/*
-4 -1 -1 0 1 2  
-1 -1 0 1
-5 -5 -4 -4 -4 -2 -2 -2 0 0 0 1 1 3 4 4*/
