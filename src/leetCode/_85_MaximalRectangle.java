package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	
    	if(matrix==null||matrix.length==0||matrix[0].length==0) {
    		return 0;
    	}
    	int maxRect=0;
    	for(int i=0;i<matrix.length;i++) {
    		int[] heights=new int[matrix[0].length];
    		for(int j=0;j<matrix[0].length;j++) {
    			if(matrix[i][j]=='0') {
    				heights[j]=0;
    			}else {
    				int height=0;
    				int k=i;
    				while(0<=k&&matrix[k][j]=='1') {
    					height++;
    					k--;
    				}
    				heights[j]=height;
    			}
    		}
    		int lvMax=largestRectangleArea(heights);
    		maxRect=maxRect<lvMax?lvMax:maxRect;
    	}
    	
    	return maxRect;
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
