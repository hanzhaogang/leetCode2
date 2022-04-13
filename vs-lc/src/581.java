import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 581 {
	
}
/*
Given an integer array nums, 
you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
	Deque<Integer> inxStack=new ArrayDeque<Integer>();
	for(int i=0;i<nums.length;i++){
		if(inxStack.isEmpty() || nums[inxStack.peek()]<=nums[i]){
			inxStack.push(i);
		}else{
			while(!inxStack.isEmpty() && nums[i]<nums[inxStack.peek()]){
				inxStack.pop();
			}
			inxStack.push(i);
		}
	}
	Set<Integer> set=new HashSet<>();
	while(!inxStack.isEmpty()){
		set.add(inxStack.pop());
	}
	int l=nums.length;
	for(int i=0;i<nums.length;i++){
		if(!set.contains(i)){
			l=i;
		}
	}
	set.clear();
	for(int i=nums.length-1;0<=i;i--){
		if(inxStack.isEmpty() || nums[i]<=nums[inxStack.peek()]){
			inxStack.push(i);
		}else{
			while(!inxStack.isEmpty() && nums[inxStack.peek()]<nums[i]){
				inxStack.pop();
			}
			inxStack.push(i);
		}
	}
	int h=0;
	while(!inxStack.isEmpty()){
		set.add(inxStack.pop());
	}
	for(int i=nums.length-1;0<=i;i--){
		if(!set.contains(i)){
			h=i;
		}
	}
	if(l==nums.length){
		return 0;
	}else if(l==nums.length-1){
		return nums.length;
	}else {
		return h-l+1;
	} 	
    }
}