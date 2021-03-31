package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,3,-1,-3,5,3,6,7};
		int k=3;
		int[] res=new _239_SlidingWindowMaximum().maximum(nums,k);
		for(int i:res) {
			System.out.println(i);
		}
	}
	
	public int[] maximum(int[] nums,int k) {
		/*
		 * 1,3,-1,-3,5,3,6,7 k=3
		 * 1,3,
		 * 
		 * [7,2,4]
           2

		 */
		
		int[] res=new int[nums.length-k+1];//len=6
		
		Deque<Integer> dq=new LinkedList<>();
		
		for(int i=0;i<k;i++) {
			if(dq.isEmpty()||nums[i]<dq.peekLast()) {
				dq.addLast(i);
			}else {
				while(!dq.isEmpty()&&dq.peekLast()<nums[i]) {
					dq.removeLast();
				}
				dq.addLast(i);
			}
		}
		res[0]=nums[dq.peekFirst()];//3,-1
		
//		  1,3,-1,-3,5,3,6,7 k=3
		//7 2 4 
//		[1,-1] 1
//		[1,3,1,2,0,5] 3


		for(int i=k;i<nums.length;i++) {
			int lo=dq.peekFirst();
			int hi=dq.peekLast();
			if(hi-lo+1==k) {
				dq.removeFirst();
			}
			int curNum=nums[i];
			if(dq.isEmpty()||curNum<nums[dq.peekLast()]) {
				dq.addLast(i);
				res[i-k+1]=nums[dq.peekFirst()];
			}else {
				while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]) {
					dq.removeLast();
				}
				dq.addLast(i);
				res[i-k+1]=nums[dq.peekFirst()];
			}
		}
		
		return res;
	}
}
