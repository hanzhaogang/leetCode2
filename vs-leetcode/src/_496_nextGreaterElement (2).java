package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _496_nextGreaterElement {
	/*
	 * 
	 * You are given two arrays (without duplicates) nums1 and nums2 
	 * where nums1’s elements are subset of nums2. 
	 * Find all the next greater numbers for nums1's elements 
	 * in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 
is the first greater number to its right in nums2.
 If it does not exist, output -1 for this number.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it 
    in the second array, so output -1.
    For number 1 in the first array, 
    the next greater number for it in the second array is 3.
    For number 2 in the first array, 
    there is no next greater number for it in the second array, so output -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, 
    the next greater number for it in the second array is 3.
    For number 4 in the first array, 
    there is no next greater number for it in the second array, so output -1.

Note:

    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.
	 */
	
	public static void main(String[] args) {
		_496_nextGreaterElement s=new _496_nextGreaterElement();
		int[] nums1= {137,59,92,122,52,131,79,236,94,171,141,86,169,199,248,120,196,168,77,71,5,198,215,230,176,87,189,206,115,76,13,216,197,26,183,54,250,27,109,140,147,25,96,105,30,207,241,8,217,40,0,35,221,191,83,132,9,144,12,91,175,65,170,149,174,82,102,167,62,70,44,143,10,153,160,142,188,81,146,212,15,162,103,163,123,48,245,116,192,14,211,126,63,180,88,155,224,148,134,158,119,165,130,112,166,93,125,1,11,208,150,100,106,194,124,2,184,75,113,104,18,210,202,111,84,223,173,238,41,33,154,47,244,232,249,60,164,227,253,56,157,99,179,6,203,110,127,152,252,55,185,73,67,219,22,156,118,234,37,193,90,187,181,23,220,72,255,58,204,7,107,239,42,139,159,95,45,242,145,172,209,121,24,21,218,246,49,46,243,178,64,161,117,20,214,17,114,69,182,85,229,32,129,29,226,136,39,36,233,43,240,254,57,251,78,51,195,98,205,108,61,66,16,213,19,68,237,190,3,200,133,80,177,97,74,138,38,235,135,186,89,201,4,101,151,31,228,231,34,225,28,222,128,53,50,247};
		int[] nums2= {137,59,92,122,52,131,79,236,94,171,141,86,169,199,248,120,
				196,168,77,71,5,198,215,230,176,87,189,206,115,76,13,216,197,26,183,
				54,250,27,109,140,147,25,96,105,30,207,241,8,217,40,0,35,221,191,83,
				132,9,144,12,91,175,65,170,149,174,82,102,167,62,70,44,143,10,153,
				160,142,188,81,146,212,15,162,103,163,123,48,245,116,192,14,211,126,
				63,180,88,155,224,148,134,158,119,165,130,112,166,93,125,1,11,208,
				150,100,106,194,124,2,184,75,113,104,18,210,202,111,84,223,173,238,
				41,33,154,47,244,232,249,60,164,227,253,56,157,99,179,6,203,110,127,
				152,252,55,185,73,67,219,22,156,118,234,37,193,90,187,181,23,220,72,255,58,204,7,107,239,42,139,159,95,45,242,145,172,209,121,24,21,218,246,49,46,243,178,64,161,117,20,214,17,114,69,182,85,229,32,129,29,226,136,39,36,233,43,240,254,57,251,78,51,195,98,205,108,61,66,16,213,19,68,237,190,3,200,133,80,177,97,74,138,38,235,135,186,89,201,4,101,151,31,228,231,34,225,28,222,128,53,50,247};
		s.nextGreaterElement(nums1, nums2);
	}
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Deque<Integer> s=new LinkedList<>();
    	Map<Integer,Integer> map=new HashMap<>();

    	for(int i=0;i<nums2.length;i++) {
    		int curNums2=nums2[i];
    		if(s.isEmpty()||curNums2<s.peekFirst()){
    			s.addFirst(nums2[i]);
    		}else {
    			while(!s.isEmpty()&&s.peekFirst()<nums2[i]) {
    				int cur=s.removeFirst();
    				map.put(cur, nums2[i]);
    			}
    			s.offer(nums2[i]);
    		}
    	}
    	
    	int[] res=new int[nums1.length];
    	for(int i=0;i<nums1.length;i++) {
    		if(map.containsKey(nums1[i])) {
    			res[i]=map.get(nums1[i]);
    		}else
    			res[i]=-1;
    	}
    	
    	return res;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        int[] result=new int[nums1.length];
        for(int i=nums2.length-1;0<=i;i--){
            if(!map.containsKey(nums2[i])){
                continue;
            }
            
            boolean found=false;
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[i]<nums2[j]){
                    int index=map.get(nums2[i]);
                    result[index]=nums2[j];
                    found=true;
                    break;
                }
            }
            if(!found){
                int index=map.get(nums2[i]);
                result[index]=-1;
            }
        }
        
        return result;
    }
}
