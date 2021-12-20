package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given n balloons, indexed from 0 to n-1. 
 * Each balloon is painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. 
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. 
 * After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

    You may imagine nums[-1] = nums[n] = 1. 
    They are not real therefore you can not burst them.
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class _312_burstBalloons {
	public static void main(String[] args) {
//		int[] nums=new int[]{3,1,5,8};
		int[] nums=new int[]{1,5,8};
		_312_burstBalloons s=new _312_burstBalloons();
		System.out.println(s.maxCoins(nums));
		
		System.out.println(s.maxCoins_dp(nums));
	}
	
	
	public int maxCoins_dp(int[] nums) {
		int[] nums_added=new int[nums.length+2];
		for(int i=0;i<nums_added.length;i++) {
			if(i==0||i==nums_added.length-1) {
				nums_added[i]=1;
			}else {
				nums_added[i]=nums[i-1];
			}
			
		}
		
		int[][] dp=new int[nums_added.length][nums_added.length];
		for(int i=0;i<dp.length;i++) {
			dp[i][i]=0;
		}
		
		for(int j=1;j<dp.length;j++) {
			for(int i=j-1;0<=i;i--) {
				dp[i][j]=0;
				for(int k=i+1;k<j;k++) {
					int curCoins=dp[i][k]+nums_added[i]*nums_added[k]*nums_added[j]+dp[k][j];
					if(dp[i][j]<curCoins) {
						dp[i][j]=curCoins;
					}
				}
			}
		}
		
		return dp[0][nums_added.length-1];
	}
	
	
	
	
	Map<String,Integer> map;
    int max=0; 
    public int maxCoins(int[] nums) {
    	boolean[] bursted=new boolean[nums.length];
    	map=new HashMap<String,Integer>();
    	helper(nums,bursted,0,0);
    	return max;
    }
    
    private void helper(int[] nums,boolean[] bursted,
    					int burstedCount,int curCoins) {
//    	String str=Arrays.asList(bursted).toString();
//    	if(map.containsKey(str)) {
//    		return map.get(str);
//    	}
    	
    	if(burstedCount==nums.length) {
    		if(max<curCoins) {
    			max=curCoins;
    		}
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++) {
    		if(!bursted[i]) {
    			int rightNb=nums.length;
    			for(int j=i+1;j<nums.length;j++) {
    				if(!bursted[j]) {
    					rightNb=j;
    					break;
    				}
    			}
    			int leftNb=-1;
    			for(int j=i-1;0<=j;j--) {
    				if(!bursted[j]) {
    					leftNb=j;
    					break;
    				}
    			}
    			
    			bursted[i]=true;
    			
    			int curRes=nums[i]*(leftNb==-1?1:nums[leftNb])*
    					(rightNb==nums.length?1:nums[rightNb]);
    			helper(nums,bursted,burstedCount+1,curCoins+curRes);
    			bursted[i]=false;
    		}
    	}
//    	map.put(str, max);
//    	return max;
    }
}

///**
// *   @Author Nyr
// *   @Date 2019/11/30 22:24
// *   @Param nums:气球数组，
//            y：递归层级，即currentLevel,
//            length：数组长度，防止每层都计算一次， 
//            beforeCoins：之前所有层获得的金币和，即currentCoin
// *   @Return 
// *   @Exception 
// *   @Description  回溯解法 
// */
// public static void maxCoins2(int[] nums, int y, int length, int beforeCoins) {
//     //回归条件
//     if (y == length) {
//         if (beforeCoins > maxCoin) {
//             maxCoin = beforeCoins;
//         }
//         return;
//     }
//     for (int i = 0; i < length; i++) {
//         //略过已经戳破的气球
//         if (nums[i] == -1) {
//             continue;
//         }
//         //标记已经戳破的气球
//         int temp = nums[i];
//         nums[i] = -1;
//         //获取上一个气球的数字
//         int before = i - 1;
//         int beforeNum = 0;
//         while (before > -1 && nums[before] == -1) {
//             before--;
//         }
//         if (before < 0) {
//             beforeNum = 1;
//         } else {
//             beforeNum = nums[before];
//         }
//         //获取下一个气球的数字
//         int next = i + 1;
//         int nextNum = 0;
//         while (next < length && nums[next] == -1) {
//             next++;
//         }
//         if (next > length - 1) {
//             nextNum = 1;
//         } else {
//             nextNum = nums[next];
//         }
//         //计算戳破当前气球的coin
//         int tempCoin = temp * nextNum * beforeNum;
//         //递归进行下一戳
//         maxCoins2(nums, y + 1, length, beforeCoins + 
//         tempCoin);
//         //回溯尝试其它戳法
//         nums[i] = temp;
//     }
// }




