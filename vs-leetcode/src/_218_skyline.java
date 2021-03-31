package leetCode;
/*
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
Buildings Skyline Contour

The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

    The number of buildings in any input list is guaranteed to be in the range [0, 10000].
    The input list is already sorted in ascending order by the left x position Li.
    The output list must be sorted by the x position.
    There must be no consecutive horizontal lines of equal height in the output skyline. 
    For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
    the three lines of height 5 should be merged into one in the final output as such: 
    [...[2 3], [4 5], [12 7], ...]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _218_skyline {
	List<List<Integer>> getSkyline(int[][] buildings){
		PriorityQueue<int[]> pq=new PriorityQueue<>((a1,a2)->{//a1[0] is index, a1[1] is height
			if(a1[0]!=a2[0]) {
				return Integer.compare(a1[0], a2[0]);
			}else {
				return Integer.compare(a1[1], a2[1]);
			}
		});
		for(int[] building:buildings) {
			pq.offer(new int[] {building[0],0-building[2]});
			pq.offer(new int[] {building[1],building[2]});
		}//[2,-10],[3,-15],[5,-12],[7,15],[9,10],[12,12],[15,-10],[19,-8],[20,-10],[24,8]
		
		
		List<List<Integer>> res=new ArrayList<>();
		Map<Integer,Integer> height2count=new TreeMap<>((k1,k2)->{
				return Integer.compare(k2, k1);
			
		});
		while(!pq.isEmpty()) {//[2,-10],[3,-15],[5,-12],[7,15],[9,10],[12,12],[15,-10],[19,-8],[20,-10],[24,8]
			int[] curEle=pq.poll();
			if(curEle[1]<0) {//cur is left
				if(height2count.isEmpty()||height2count.keySet().iterator().next()<0-curEle[1]) {
					res.add(Arrays.asList(curEle[0],0-curEle[1]));
				}
				height2count.put(0-curEle[1],
						height2count.getOrDefault(0-curEle[1],0)+1);

			}else {//cur is right
				if(height2count.get(curEle[1])==1) {
					if(height2count.keySet().iterator().next()==curEle[1]) {
						height2count.remove(curEle[1]);
						res.add(Arrays.asList(curEle[0],
								height2count.isEmpty()?0:height2count.keySet().iterator().next()));
					}else {
						height2count.remove(curEle[1]);
					}
				}else {
					height2count.put(curEle[1], height2count.get(curEle[1])-1);
				}
			}
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<List<Integer>> getSkyline_2(int[][] buildings) {
	    PriorityQueue<int[]> pq = new PriorityQueue<>(
	    		(a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
	    for (int[] building : buildings) {
	        pq.offer(new int[] { building[0], -building[2] });
	        pq.offer(new int[] { building[1], building[2] });
	    }
	
	    List<List<Integer>> res = new ArrayList<>();
	    /*
	     * 有兩個關鍵點
		第一是line sweep：building的開始和結束是必須要依序處理的 所以需要加入到一個vector排列然後sort
		第二：
		building開始時 若它是最高的 則形成contour輪廓
		building結束時 若他的高度是比 剔除自己後最高的還高 那還是會形成contour輪廓
		其實就這樣
	     */
	    TreeMap<Integer, Integer> height2count = new TreeMap<>(
	    		(a, b) -> b - a);//max 
	    height2count.put(0, 1);
	    int left = 0, height = 0;
	    while (!pq.isEmpty()) {
	        int[] arr = pq.poll();
	        if (arr[1] < 0) {//left side of building.
	            height2count.put(-arr[1], height2count.getOrDefault(-arr[1], 0) + 1);
	        } else {//right side of building.
	            height2count.put(arr[1], height2count.get(arr[1]) - 1);
	            if (height2count.get(arr[1]) == 0) 
	            	height2count.remove(arr[1]);
	        }
	        int maxHeight = height2count.keySet().iterator().next();
	        if (maxHeight != height) {
	            left = arr[0];
	            height = maxHeight;
	            res.add(Arrays.asList(left, height));
	        }
	    }
	
	    return res;
	}
}