package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Median is the middle value in an ordered integer list. 
 * If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
Examples:

[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, 
there is a sliding window of size k 
which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. 
Each time the sliding window moves right by one position. 
Your job is to 
output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6

Therefore, return the median sliding window as [1,-1,-1,3,5,6].
1 2 3 4 5 6 7 8
     maxHeap     minHeap
        3           
        2
        1           
                    
                    4           
                    5
                    6
                    7
Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
Answers within 10^-5 of the actual value will be accepted as correct.
*/
public class _480_SlidingWIndowMedian {
	public static void main(String[] args) {
		_480_SlidingWIndowMedian s=new _480_SlidingWIndowMedian();
		int[] nums=new int[] {1,3,-1,-3,5,3,6,7};
		int k=3;
		for(double d:s.medianSlidingWindow(nums, k)) {
			System.out.println(d);
		}
	}
	public double[] medianSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->
				Integer.compare(a,b));
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->
				Integer.compare(b,a));
		
		double[] res=new double[nums.length-(k-1)];
		
		for(int i=0;i<nums.length;i++) {
			if(k-1<i) {
				if(maxHeap.contains(nums[i-(k)])) {
					maxHeap.remove(nums[i-(k)]);
				}else {
					minHeap.remove(nums[i-(k)]);
				}
			}
			if(maxHeap.isEmpty()) {//1
				maxHeap.offer(nums[i]);
			}else if(nums[i]<=maxHeap.peek()) {
				maxHeap.offer(nums[i]);//-1,1;3
				while(minHeap.size()+1<maxHeap.size()) {
					int temp=maxHeap.poll();
					minHeap.offer(temp);
				}
			}else {
				minHeap.offer(nums[i]);//1,3
				while(maxHeap.size()<minHeap.size()) {
					int temp=minHeap.poll();
					maxHeap.offer(temp);
				}
			}
			
			if(k-1<=i) {
				if(maxHeap.size()==minHeap.size())
					res[i-(k-1)]=
							((double)((long)minHeap.peek()+(long)maxHeap.peek()))/2.0;
				else
					res[i-(k-1)]=
							maxHeap.peek();
			}
		}
		
		return res;
    } 
}