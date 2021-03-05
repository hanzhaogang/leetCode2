package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Implement next permutation, 
 * which rearranges numbers 
 * into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, 
it must rearrange it as the lowest possible order 
(ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. 
Inputs are in the left-hand column 
and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class _31_nextPermutation {
	//[2,3,1]
    public void nextPermutation(int[] nums) {
    	if(nums==null||nums.length==0||nums.length==1) {
    		return;
    	}
    	
    	int switchLoInd=0;
    	int switchHiInd=nums.length-1;
    	for(int i=nums.length-1;0<i;i--) {
    		int curNum=nums[i];
    		int preNum=nums[i-1];
    		
    		if(preNum<curNum) {
    			switchLoInd=i;
    			switchHiInd=nums.length-1;
    			break;
        	}
    	}//switchLoInd ~switchHiInd is in descend order
    	
    	int last2changeInd=switchLoInd-1;
    	
    	while(switchLoInd<switchHiInd) {
    		int temp=nums[switchLoInd];
    		nums[switchLoInd]=nums[switchHiInd];
    		nums[switchHiInd]=temp;
    		switchLoInd++;
    		switchHiInd--;
    	}// switchLoInd ~ switchHiInd is in ascend order
    	
    	if(last2changeInd!=-1) {
    		int changeTargetInd=-1;
    		for(int i=last2changeInd+1;i<nums.length;i++) {
    			if(nums[last2changeInd]<nums[i]) {
    				changeTargetInd=i;
    				break;
    			}
    		}
    		
    		int temp=nums[changeTargetInd];
    		nums[changeTargetInd]=nums[last2changeInd];
    		nums[last2changeInd]=temp;
    	}
    	
    	return;
    }
    
/* lintcode 51
 * 
 * Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

The list may contains duplicate integers.

Example 1:

Input:[1]
Output:[1]

Example 2:

Input:[1,3,2,3]
Output:[1,2,3,3]

Example 3:

Input:[1,2,3,4]
Output:[4,3,2,1]

duplicate.

1 2 3 4 5 6 



1 2 5 3 4 6   ->1 2 5 3 6 4
1 5 3 2 4 6 -> 1 5 3 2 6 4
1 5 2 3 4 6 -> 1 5 3 2 4 6
1 2 6 5 4 3 2 -> 1 2 2 3 4 5 6 -> 




1 2 2 6 5 4 3 -> 

1 3 2 2 4 5 6 -> 1 3 6 5 4 2 2 -> 1 2 6 5 4 3 2
1 3 2 3 4 5 6 -> 1 3 6 5 4 3 2 -> 1 2 6 5 4 3 3

先从后往前找到 index 位置 小于 index-1 位置的数,index-1为要替换的数
从 index 位置到末尾进行逆序排序,temp
从temp，0位置开始，找到第一个小于nums[ index-1]的位置index1
交换nums[index-1]和temp[index1]


*/
    public static void main(String[] args) {
    	_31_nextPermutation solution=new _31_nextPermutation();
//    	List<Integer> nums=Arrays.asList(1, 3, 2, 3, 4, 5, 6);
    	List<Integer> nums=Arrays.asList(1, 2, 2, 6, 5, 4, 3);
//    	List<Integer> nums=Arrays.asList(1, 3, 2, 2, 4, 5, 6);
    	
    	System.out.println(solution.previousPermuation(nums));
    }
    
    public List<Integer> previousPermuation(List<Integer> nums) {//[1,1]
    	if(nums==null)
    		return null;
    	if(nums.size()==1)
			return nums;
			
    	int[] lastReversePairIndexs=new int[2];
    	for(int second=nums.size()-1;1<=second;second--) {
    		int first=second-1;
    		if(nums.get(second)<nums.get(first)) {
    			lastReversePairIndexs[0]=first;
    			lastReversePairIndexs[1]=second;
    			break;
    		}
    	}
    	
    	List<Integer> tempList=new ArrayList<>();
    	for(int i=lastReversePairIndexs[1];i<nums.size();i++) {
    		tempList.add(0,nums.get(i));
    	} //6 5 4 2 2 
    	
    	List<Integer> res=new ArrayList<>();
    	if(lastReversePairIndexs[1]!=0) {
    		for(int i=0;i<tempList.size();i++) {
    			if(nums.get(lastReversePairIndexs[0])<=tempList.get(i)) {
    				continue;
    			}else {
    				int temp=tempList.get(i);//2
    				tempList.set(i, nums.get(lastReversePairIndexs[0]));// 6 5 4 3 2
    				res.add(temp);//
    				res.addAll(tempList);
    				break;
    			}
    		}
    		for(int i=lastReversePairIndexs[0]-1;0<=i;i--) {
        		res.add(0,nums.get(i));
        	}
    		return res;
    	}else {
    		return tempList;
    	}
    }
}


	
