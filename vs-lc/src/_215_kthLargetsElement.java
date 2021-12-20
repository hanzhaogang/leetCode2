package leetCode;
/*
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _215_kthLargetsElement {
	public static void main(String[] args) {
		int[] nums= {3,3,3,3,3,3,3,3,3};
		int k=1;
		_215_kthLargetsElement s=new _215_kthLargetsElement();
		System.out.println(s.findKthLargest(nums,k));
	}
	public int findKthLargest(int[] nums, int k) {
		return nums[bs(nums,0,nums.length-1,nums.length+1-k)];//[3,2,1,5,6,4] and k = 2
	
    }
	private int bs(int[] nums,int loInd,int hiInd,int k) {
		if(loInd==hiInd) {
			return loInd;
		}
		
		int index=partition(nums,loInd,hiInd);
		if(index==k-1) {
			return index;
		}else if(index<k-1) {
			return bs(nums,index+1,hiInd,k);
		}else {
			return bs(nums,loInd,index-1,k);
		}
	}
	
	private int partition(int[] nums,int loInd,int hiInd) {
		int midInd=loInd+(hiInd-loInd)/2;
		
		int temp=nums[midInd];
		nums[midInd]=nums[hiInd];
		nums[hiInd]=temp;
		
		int firstLargerInd=loInd;
		int toHandleInd=loInd;
		int midNum=nums[hiInd];
		
		while(toHandleInd<hiInd) {
			int toHandleNum=nums[toHandleInd];
			if(midNum<=toHandleNum) {
				toHandleInd++;
			}else {
				temp=nums[firstLargerInd];
				nums[firstLargerInd]=nums[toHandleInd];
				nums[toHandleInd]=temp;
				toHandleInd++;
				firstLargerInd++;
			}
		}
		
		nums[hiInd]=nums[firstLargerInd];
		nums[firstLargerInd]=midNum;
		
		return firstLargerInd;
	}
}


