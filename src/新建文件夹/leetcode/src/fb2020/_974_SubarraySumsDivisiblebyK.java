package fb2020;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

 

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

 

Note:

    1 <= A.length <= 30000
    -10000 <= A[i] <= 10000
    2 <= K <= 10000
    
    
    
    build the presum array.
    build a presum hashmap.
    for each presum ps1, check if exist a presum ps2: (ps1-ps2)%K==0.
    
    tc: n*n
 */
public class _974_SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {//A = [4,5,0,-2,-3,1], K = 5
    	//[8,9,7,8,9] K=8 
    	Map<Integer,Integer> map=new HashMap<>();
    	int res=0;
    	int presum=0;
    	for(int i=0;i<A.length;i++) {
    		presum+=A[i];// 8, 17, 24, 32, 41
    		int modLeft=(presum<0)?(K+presum%K)%K:(presum%K);//-8 % 3 = -2 ;  1  % 3 = 1
    		if(modLeft==0) {
    			res++;
    		}
    		
    		if(map.containsKey(modLeft)) {
    			res+=map.get(modLeft);
    		}
    			
    		map.put(modLeft, map.getOrDefault(modLeft, 0)+1);//1,1;
    	}
    	
    	return res;
    }
}
