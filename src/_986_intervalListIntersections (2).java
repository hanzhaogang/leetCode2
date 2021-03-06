package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

 

Note:

    0 <= A.length < 1000
    0 <= B.length < 1000
    0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class _986_intervalListIntersections {
	public static void main(String[] args) {
		_986_intervalListIntersections s=new _986_intervalListIntersections();
		int[][] A=new int[][] {{3,10}};		
		int[][] B=new int[][] {{5,10}};
		System.out.println(s.intervalIntersection(A, B));
	}
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int pa=0;
        int pb=0;

        List<int[]> pointers=new ArrayList<>();
        while(pa<A.length*2&&pb<B.length*2){
            int curA=A[pa/2][pa%2];
            int curB=B[pb/2][pb%2];
/*  */
            if(curA==curB){
            	if(pa%2==0) {
            		pointers.add(new int[]{curA,pa%2==0?1:-1});
                    pointers.add(new int[] {curB,pb%2==0?1:-1});
                    
            	}else {
            		pointers.add(new int[]{curB,pb%2==0?1:-1});
                    pointers.add(new int[] {curA,pa%2==0?1:-1});
                    
            	}
                pa++;
                pb++;
            }else if(curA<curB){
                pointers.add(new int[]{curA,(pa%2==0)?1:-1});//[0,1] [2,-1]
                pa++;
            }else{
                pointers.add(new int[] {curB,(pb%2==0)?1:-1});//[1,1] [8,1]
                pb++;
            }
        }

        while(pb<B.length*2){
            pointers.add(new int[] {B[pb/2][pb%2],(pb%2==0)?1:-1});
            pb++;
        }
        while(pa<A.length*2){
            pointers.add(new int[] {A[pa/2][pa%2],(pa%2==0)?1:-1});
            pa++;
        }
        
        List<int[]> resList=new ArrayList<>();
        int startingCount=0;
        int startingVal=0;
        for(int[] curPointer:pointers){
            
            if(curPointer[1]==1){
                startingCount++;
                if(startingCount==2){
                    startingVal=curPointer[0];
                }
            }else{
                if(startingCount==2){
                    resList.add(new int[]{startingVal,curPointer[0]});
                }
                startingCount--;
            }
        }
        
        return resList.toArray(new int[resList.size()][2]);
    }
    
    
    public int[][] intervalIntersection_2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
          // Let's check if A[i] intersects B[j].
          // lo - the startpoint of the intersection
          // hi - the endpoint of the intersection
          int lo = Math.max(A[i][0], B[j][0]);
          int hi = Math.min(A[i][1], B[j][1]);
          if (lo <= hi)
            ans.add(new int[]{lo, hi});

          // Remove the interval with the smallest endpoint
          if (A[i][1] < B[j][1])
            i++;
          else
            j++;
        }

        return ans.toArray(new int[ans.size()][]);
      }

}
