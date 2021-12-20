import java.util.Map;
import java.util.PriorityQueue;

public class 347. Top K Frequent Elements {
	
}

/* Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: 
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
优于O（nlgn）的算法，那就是O（n）或者O（lgn）的。

首先想到统计各个元素的频率，用HashMap，key是元素，value是出现次数，建map的时间复杂度是O（n）。
然后。。
感觉不论是HashMap还是TreeMap，都避免不了最坏的O（nlgn）的时间复杂度。

问题在于返回的topK可以是无序的。所以还是使用quick sort。


----update--
思路有问题，优于O（nlgn），不一定是O（n）、O（lgn），还可以是O（nlgk），
满足这一要求的排序算法是堆排序，建立一个大小为k的最小堆即可。*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
	Map<Integer,Integer> num2count=new HashMap<>();
	for(int num:nums){
		if(num2count.containsKey(num)){
			num2count.put(num,num2count.get(num)+1);
		}else{
			num2count.put(num,1);
		}
	}

	int[] res=new int[k];
	PriorityQueue<Map.Entry<Integer,Integer>> heap=new PriorityQueue<>((e1,e2)->{
		return Integer.compare(e1.getValue(), e2.getValue());
	});//小顶堆
	for(Map.Entry<Integer,Integer> e:num2count.entrySet()){
		if(k==heap.size()){
			heap.offer(e);
			heap.poll();
		}else if(heap.size()<k){
			heap.offer(e);
		}
	}
	int i=0;
	while(!heap.isEmpty()){
		res[i++]=heap.poll().getKey();
	}
	return res;
    }
}
