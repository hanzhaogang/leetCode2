package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10

 */
public class _84_largestRectangleInHistogram {
	public static void main(String[] args) {
		_84_largestRectangleInHistogram s=new _84_largestRectangleInHistogram();
		int[] heights=new int[] {2,1,5,6,2,3};
		heights=new int[] {1};
		System.out.println(s.largestRectangleArea(heights));
	}
    public int largestRectangleArea(int[] heights) {
    	int largestArea=0;
    	int[] nextSmallerIndexs=findNextSmallerIndex(heights);
    	int[] preSmallerIndexs=findPreSmallerIndex(heights);
    	for(int i=0;i<heights.length;i++) {
    		int curHeight=heights[i];
    		int nextSmallerIndex=nextSmallerIndexs[i];
    		int preSmallerIndex=preSmallerIndexs[i];
    		int curArea=curHeight*(nextSmallerIndex-preSmallerIndex-1);
    		if(largestArea<curArea) {
    			largestArea=curArea;
    		}
    	}
    	
    	return largestArea;
    }
    
    private int[] findNextSmallerIndex(int[] heights) {
    	Deque<Integer> indSt=new ArrayDeque<>();
    	int[] nextSmallerIndexs=new int[heights.length];
    	for(int i=0;i<heights.length;i++) {
    		if(indSt.isEmpty()) {
    			indSt.push(i);
    		}else {
    			int peekInd=indSt.peek();
    			if(heights[peekInd]<=heights[i]) {
    				indSt.push(i);
    			}else {
    				while(!indSt.isEmpty()&&heights[i]<heights[indSt.peek()]) {
    					int popedInd=indSt.pop();
    					nextSmallerIndexs[popedInd]=i;
    				}
    				indSt.push(i);
    			}
    		}
    	}
    	
    	while(!indSt.isEmpty()) {
    		int index=indSt.pop();
    		nextSmallerIndexs[index]=heights.length;
    	}
    	return nextSmallerIndexs;
    }
    
    private int[] findPreSmallerIndex(int[] heights) {
    	Deque<Integer> indSt=new ArrayDeque<>();
    	int[] preSmallerIndexs=new int[heights.length];
    	for(int i=heights.length-1;0<=i;i--) {
    		if(indSt.isEmpty()) {
    			indSt.push(i);
    		}else {
    			int peekInd=indSt.peek();
    			if(heights[peekInd]<=heights[i]) {
    				indSt.push(i);
    			}else {
    				while(!indSt.isEmpty()&&heights[i]<heights[indSt.peek()]) {
    					int popedInd=indSt.pop();
    					preSmallerIndexs[popedInd]=i;
    				}
    				indSt.push(i);
    			}
    		}
    	}
    	
    	while(!indSt.isEmpty()) {
    		int i=indSt.pop();
    		preSmallerIndexs[i]=-1;
    	}
    	return preSmallerIndexs;
    }
}
