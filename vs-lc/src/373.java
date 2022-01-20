public class 373 {
   public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	PriorityQueue<int[]> heap=new PriorityQueue<>( (a1,a2)->{
		return Integer.compare( nums1[a1[0]]+nums2[a1[1]],nums1[a2[0]]+nums2[a2[1]] );
	} );
	heap.offer(new int[]{0,0});
	List<List<Integer>> res=new ArrayList<>();
	while(!heap.isEmpty()){
		int[] polled=heap.poll();
		List<Integer> list=new ArrayList<>();
		list.add(nums1[polled[0]]);
		list.add(nums2[polled[1]]);	
		res.add(list);
		if(res.size()==k){
			break;
		}
		if(polled[0]<nums1.length-1){
			heap.offer(new int[]{polled[0]+1,polled[1]});
		}
		if(polled[1]<nums2.length-1){
			heap.offer(new int[]{polled[0],polled[1]+1});
		}
	}
	return res;
    }	
}
/* [1,1,2]
   [1,2,3] 10 */