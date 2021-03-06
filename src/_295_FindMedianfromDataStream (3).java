package leetCode;

import java.util.PriorityQueue;

/*
 * 1,-1,9,7,2,5,6,3
 * 
 * 1 2 3 5 6 7 9
 * 
 * max-heap       min-heap
 *  
 *    
 *    2
 *    
 *    1             
 *   -1         5
 *              7
 *              9                      
 *                        
 * 
 * 
 */

public class _295_FindMedianfromDataStream {
    /** initialize your data structure here. */
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	public _295_FindMedianfromDataStream() {
		maxHeap=new PriorityQueue<>((a,b)->(Integer.compare(b,a)));
		minHeap=new PriorityQueue<>();
	}
    
    public void addNum(int num) {
    	if(maxHeap.isEmpty()) {
    		maxHeap.offer(num);
    	}else if(num<=maxHeap.peek()) {
    		maxHeap.offer(num);
    		if(minHeap.size()+1<maxHeap.size()) {
    			int temp=maxHeap.poll();
    			minHeap.offer(temp);
    		}
    	}else {
    		minHeap.offer(num);
    		if(maxHeap.size()+1<minHeap.size()) {
    			int temp=minHeap.poll();
    			maxHeap.offer(temp);
    		}
    	}
    }
    
    public double findMedian() {
    	if(maxHeap.size()==minHeap.size()) {
    		return ((double)(maxHeap.peek()+minHeap.peek()))/2.0;
    	}else if(maxHeap.size()+1==minHeap.size()) {
    		return minHeap.peek();
    	}else {
    		return maxHeap.peek();
    	}
    }
}
