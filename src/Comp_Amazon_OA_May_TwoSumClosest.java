
import java.util.*;
public class Comp_Amazon_OA_May_TwoSumClosest {
	public List<List<Integer>> PrimeMaxProfit(int maxTravelDist,
								List<List<Integer>> forwardRouteList, 
								List<List<Integer>> returnRouteList) {
		List<List<Integer>> res = new ArrayList<>();
		int forLen = forwardRouteList.size(), retLen = returnRouteList.size() ;
		if (maxTravelDist == 0 || forLen == 0 || retLen == 0) {
			return res;
		}
		Collections.sort(forwardRouteList, (a, b) -> (a.get(1) - b.get(1)));
		Collections.sort(returnRouteList, (a, b) -> (a.get(1) - b.get(1)));

		int l = 0, r = retLen - 1, diff = Integer.MAX_VALUE, sum;
		while (l < forLen && r >= 0) {
			sum = forwardRouteList.get(l).get(1) + returnRouteList.get(r).get(1);
			if (maxTravelDist - sum >= 0 && maxTravelDist - sum <= diff) {
				if (maxTravelDist - sum < diff) {
					diff = maxTravelDist - sum;
					res = new ArrayList<>();
				}
				//int i=100_000_008;
				res.add(Arrays.asList(forwardRouteList.get(l).get(0), 
				returnRouteList.get(r).get(0)));
				for(int i=l+1;i<forLen;i++) {
					if(forwardRouteList.get(l).get(1).equals(forwardRouteList.get(i).get(1))) {
						res.add(Arrays.asList(forwardRouteList.get(i).get(0), 
								returnRouteList.get(r).get(0)));	
					}
						
				}
			}
			if (sum >= maxTravelDist
					//&&forwardRouteList.get(l+1)!=forwardRouteList.get(l)
					) {
				r--;
			} else {
				l++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
	List<List<Integer>> forward = new ArrayList<>();
	List<List<Integer>> returnL = new ArrayList<>();
	forward.add(Arrays.asList(1, 5000));
	forward.add(Arrays.asList(3, 4000));
	forward.add(Arrays.asList(2, 3000));
	forward.add(Arrays.asList(4, 1000));
	forward.add(Arrays.asList(5, 4000));
	
	returnL.add(Arrays.asList(1, 2000));
	returnL.add(Arrays.asList(3, 5000));
	returnL.add(Arrays.asList(2, 5000));
	returnL.add(Arrays.asList(4, 6000));
	List<List<Integer>> res = new Comp_Amazon_OA_May_TwoSumClosest().PrimeMaxProfit(9000, forward,
	returnL);
	System.out.println(res);
	/*Output
	[[4, 1000], [2, 3000], [3, 4000], [5, 4000], [1, 5000]]
	[[1, 2000], [3, 5000], [2, 5000], [4, 6000]]
	[[2, 4], [3, 2], [3, 3]] -> wrong! should be [[2, 4], [3, 2], [3, 3],
	[5, 3], [5, 2]]
	*/
	}
}

class FindClosestNumber { 
    // Returns element closest to target in arr[] 
    public static int findClosest(int arr[], int target) { 
        int n = arr.length; 
        // Corner cases 
        if (target <= arr[0]) return arr[0]; 
        if (target >= arr[n - 1]) return arr[n - 1]; 
  
        // Doing binary search  
        int i = 0, j = n, mid = 0; 
        while (i < j) { 
            mid = (i + j) / 2; 
  
            if (arr[mid] == target) return arr[mid]; 
  
            /* If target is less than array element, then search in left */
            if (target < arr[mid]) { 
                // If target is greater than previous 
                // to mid, return closest of two 
                if (mid > 0 && target > arr[mid - 1])  
                    return getClosest(arr[mid - 1], arr[mid], target); 
                  
                /* Repeat for left half */
                j = mid;               
            } // If target is greater than mid 
            else { 
                if (mid < n-1 && target < arr[mid + 1])  
                    return getClosest(arr[mid], arr[mid + 1], target);                 
                i = mid + 1; // update i 
            } 
        } 
  
        // Only single element left after search 
        return arr[mid]; 
    } 
  
    // Method to compare which one is the more close 
    // We find the closest by taking the difference 
    //  between the target and both values. It assumes 
    // that val2 is greater than val1 and target lies 
    // between these two. 
    public static int getClosest(int val1, int val2,  int target) { 
        if (target - val1 >= val2 - target)  
            return val2;         
        else 
            return val1;         
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 }; 
        int target = 11; 
        System.out.println(findClosest(arr, target)); 
    } 
} 