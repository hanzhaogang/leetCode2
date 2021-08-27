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
/* the median is the middle value in an ordered integer list. 
If the size of the list is even, 
there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. 
Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 10^4 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], 
how would you optimize your solution?

If 99% of all integer numbers from the stream are in the range [0, 100], 
how would you optimize your solution?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-median-from-data-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
数据规模,50000次调用。
从数据规模看，时间复杂度是O(nlgn).

follow up 1:
如果是数据都在【0,100】，维护一个number的totalCount、一个作为桶的数组，
每次add，直接在数组上面count++，同时totalCount++；
每次findMedian，遍历一遍数组，直接找到第totalCount/2个数就是中位数。

时间复杂度： 每次add是常量复杂度，每次find也是。

follow up 2:
如果数据99%都在[0,100],维护一个number的 totalCount、一个作为桶的数组、
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
