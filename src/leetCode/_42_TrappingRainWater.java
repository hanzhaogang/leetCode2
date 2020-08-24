package leetCode;
/*
 * 
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 * 0 1 0 2 1 0 1 3 2 1 2 1
 */
public class _42_TrappingRainWater {
	public static void main(String[] args) {
//		int[] height=new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] height=new int[] {2,0,2};
		_42_TrappingRainWater s=new _42_TrappingRainWater();
		System.out.println(s.trap3(height));
	}
	public int trap3(int[] height) {
    	if(height.length==0||height.length==1)
    		return 0;
        //get left max and right max for each elements
   	    int[][] maxs=new int[height.length][2];
   	    for(int i=0;i<maxs.length;i++) {
   	   	 	for(int j=0;j<2;j++) {
   	   	 		maxs[i][j]=-1;
   	   	 	}
   	    }

   	    int rHeightest=height[1];
   	    for(int i=2;i<height.length;i++) {
   	    	if(rHeightest<height[i])
   	   		    rHeightest=i;
   	    }
   	    int lHeightest=height[0];
   	    for(int i=1;i<height.length-1;i++) {
   	    	if(lHeightest<height[i])
   	   		    lHeightest=i;
   	    }
   	    maxs[0]=new int[] {0,rHeightest};
   	    maxs[height.length-1]=new int[] {lHeightest,0};

   	    for(int i=1;i<height.length-1;i++) {
   	    	maxs[i][0]=Math.max(maxs[i-1][0], height[i-1]);
   	    }
   	    for(int i=height.length-2;0<i;i--) {
   	    	maxs[i][1]=Math.max(maxs[i+1][1], height[i+1]); 
   	    }
        //calculate the result
        int res=0;
   	    for(int i=0;i<height.length;i++) {
          	 int cur=Math.min(maxs[i][0],maxs[i][1])-height[i];
          	 res+=0<cur?cur:0;
           }
   	    return res;
    }
    public int trap(int[] height) {
        int lo=0;
        int hi=height.length-1;
        int leftMax=0;
        int rightMax=0;
        int res=0;
        while(lo<=hi){
            leftMax=Math.max(leftMax,height[lo]);
            rightMax=Math.max(rightMax,height[hi]);
            if(leftMax<=rightMax){
                res+=leftMax-height[lo];
                lo++;
            }else{
                res+=rightMax-height[hi];
                hi--;
            }
        }
        return res;
    }
    
    public int trap2(int[] height) {
        int res=0;
   	 	for(int i=0;i<height.length;i++) {
   	 		int leftMaxIndex=0;
   	 		for(int left=0;left<i;left++) {
   	 			if(height[leftMaxIndex]<height[left]) {
   	 				leftMaxIndex=left;
   	 			}
   	 		}
       	 
       	 int rightMaxIndex=height.length-1;
       	 for(int right=i+1;right<height.length;right++) {
       		 if(height[rightMaxIndex]<height[right]) {
       			 rightMaxIndex=right;
       		 }
       	 }
       	 int cur=Math.min(height[leftMaxIndex],height[rightMaxIndex])-height[i];
       	 res+=0<cur?cur:0;
        }
   	 
   	 return res;
    }
    
    
    
}
