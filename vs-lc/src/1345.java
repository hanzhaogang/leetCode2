/*5*10^4 nlgn or n */
public class 1345 {
	    public int minJumps(int[] arr) {
		Map<Integer,List<Integer>> num2index=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			List<Integer> indexs=num2index.getOrDefault(arr[i],new ArrayList<>());
			indexs.add(i);
			num2index.put(arr[i],indexs);
		}
		Queue<Integer> q=new ArrayDeque<>();
		q.offer(arr.length-1);
		boolean[] visited=new boolean[arr.length];
		visited[arr.length-1]=true;
		int lv=0;
		while(!q.isEmpty()){
			int n=q.size();
			for(int i=0;i<n;i++){
				int polled=q.poll();
				if(polled==0){
					return lv;
				}
				
				
				if(num2index.containsKey(arr[polled])){
					List<Integer> l=num2index.get(arr[polled]);
					while(!l.isEmpty()){
						int removed=l.remove(0);
						if(!visited[removed]){
							q.offer(removed);
							visited[removed]=true;
						}
					}
					num2index.remove(arr[polled]);
				}
				if((0<=polled-1)&&(polled-1<arr.length)&&!visited[polled-1]){
					q.offer(polled-1);
					visited[polled-1]=true;
				}
				if((0<=polled+1)&&(polled+1<arr.length)&&!visited[polled+1]){
					q.offer(polled+1);
					visited[polled+1]=true;
				}
			}
			lv++;
		}
		return -1;
    }	
}
