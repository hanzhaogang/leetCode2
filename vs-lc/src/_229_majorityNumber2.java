package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]

Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

 */
public class _229_majorityNumber2 {
	public static void main(String[] args) {
		_229_majorityNumber2 s=new _229_majorityNumber2();
//		int[] nums=new int[] {0,-1,2,-1};
//		int[] nums=new int[] {8,8,7,7,7};
//		int[] nums=new int[] {1,1,1,3,3,2,2,2};
		int[] nums=new int[] {1,2,2,3,2,1,1,3};

		System.out.println(s.majorityElement(nums));
	}
	public List<Integer> majorityElement(int[] nums) {
        /**
        3 4 1 1 1 2 2 2 
        [0,-1,2,-1]
        **/

        long[][] c=new long[][]{{(long)Integer.MAX_VALUE+1L,0},{(long)Integer.MAX_VALUE+1L,0}};
        for(int num:nums){
            if(c[0][0]==(long)Integer.MAX_VALUE+1L){//Integer.MAX_VALUE+1 will be wrong.
                c[0][0]=num;
                c[0][1]=1;
            }else if(c[1][0]==(long)Integer.MAX_VALUE+1L){
                if(num!=c[0][0]){
                    c[1][0]=num;
                    c[1][1]=1;//typo c[0][1]
                }else{
                    c[0][1]++;
                }
                
            }else{
            	if(c[0][0]==num){
                    c[0][1]++;
                }else if(c[1][0]==num){//judge number equals before any counts equals 0
                    c[1][1]++;
                }else if(c[0][1]==0){
                    c[0][0]=num;
                    c[0][1]++;
                }else if(c[1][1]==0){
                    c[1][0]=num;
                    c[1][1]++;
                }else{
                    c[0][1]--;
                    c[1][1]--;
                    
                }
                
            }
        }
        

        /*1 1 1 2 2 3 
         * -1 1;-1 0
        */
        int[] counts=new int[2];
        for(int num:nums){
            if(num==c[0][0]){
                counts[0]++;
            }else if(num==c[1][0]){
                counts[1]++;
            }
        }

        List<Integer> res=new ArrayList<>();
        if((nums.length/3)<counts[0]){
            res.add((int)c[0][0]);
        }
        if((nums.length/3)<counts[1]){
            res.add((int)c[1][0]);
        }

        return res;
    }
}
