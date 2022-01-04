public class 846 {
	public boolean isNStraightHand(int[] hand,int groupSize){
		Map<Integer,Integer> num2counts=new HashMap<>();
		for(int num:hand){
			if(num2counts.containsKey(num)){
				num2counts.put(num,num2counts.get(num)+1);
			}else{
				num2counts.put(num,1);
			}
		}
		PriorityQueue<Map.Entry<Integer,Integer>> heap=new PriorityQueue<>((
			Map.Entry<Integer,Integer> e1,Map.Entry<Integer,Integer> e2)->{
				return Integer.compare(e1.getKey(),e2.getKey());
			});
		for(Map.Entry<Integer,Integer> e: num2counts.entrySet()){
			heap.offer(e);
		}
		while(!heap.isEmpty()){
			if(heap.size()<groupSize)
				return false;
			int preNum=-1;
			Set<Map.Entry<Integer,Integer>> polled=new HashSet<>();
			for(int i=0;i<groupSize;i++){
				Map.Entry<Integer,Integer> e=heap.poll();
				if((preNum!=-1)&&(preNum+1!=e.getKey()))
					return false;
				preNum=e.getKey();
				int c=e.getValue();
				if(1<c){
					e.setValue(c-1);
					polled.add(e);
				}
			}
			heap.addAll(polled);
			polled.clear();
		}
		return true;
	}	
}
