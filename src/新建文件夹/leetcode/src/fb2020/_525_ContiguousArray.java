package fb2020;
import java.util.HashMap;
import java.util.Map;

/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 
 
 * bf: find all contiguous array: O(n^2)
 *     determine if the array is the wanted one: O(n)
 *     overall O(n^3)
 *     
 *     longest subarray ending at index i:
 *     
 *     import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>(len);
        // 下标 0 之前的位置是 -1
        map.put(0, -1);

        int res = 0;
        int preSum = 0;

        // 把数组中的 0 都看成 -1
        for (int i = 0; i < len; i++) {
            // 把 0 视为 -1，pre 是先加了，所以后面计算的时候是 i - map.get(preSum)，注意下标 + 1 和不加 1 的差别
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum += -1;
            }

            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                // 只记录这个数字第 1 次出现的下标
                map.put(preSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1};
        int res = solution.findMaxLength(nums);
        System.out.println(res);
    }
}


 */
public class _525_ContiguousArray {//0,1,0
    public int findMaxLength(int[] nums) {
    	Map<Integer,Integer> sum2FirstIndexs=new HashMap<>();
    	int res=0;
    	int sum=0;
    	sum2FirstIndexs.put(0, -1);
    	for(int i=0;i<nums.length;i++) {
    		sum+=nums[i]==0?-1:1;//-1;0;-1
    		
    		if(sum2FirstIndexs.containsKey(sum)) {//-1;0;-1
    			res=Math.max(res, i-sum2FirstIndexs.get(sum));//2
    		}
    		
    		if(!sum2FirstIndexs.containsKey(sum)) {//-1
    			sum2FirstIndexs.put(sum, i);//-1->0
    		}
    	}
    	return res;
    }
}
