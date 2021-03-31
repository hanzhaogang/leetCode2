import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Comp_Amazon_OAMay_buildRoad {

	public int getMinCostToConstruct(int numTotalAvailableCities,
	 int numTotalAvailableRoads,
	 List<List<Integer>> roadsAvailable,//[[1,2]]
	 int numNewRoadsConstruct,
	 List<List<Integer>> costNewRoadsConstruct//[[1,3,10]]
	 ){
		if(numTotalAvailableCities<2||numTotalAvailableRoads>=
				numTotalAvailableCities-1)
			return 0;
		
		UnionFind uf=new UnionFind(numTotalAvailableCities);
		int existingRoadCount=0;
		for(List<Integer> pair:roadsAvailable) {
			int ct1=pair.get(0);
			int ct2=pair.get(1);
			if(!uf.find(ct1, ct2)) {
				uf.union(ct1,ct2);
				existingRoadCount++;
			}
		}
		
		PriorityQueue<Connection> pq=new PriorityQueue<>(
				numNewRoadsConstruct,(a,b)->Integer.compare(a.cost,b.cost));
		for(List<Integer> newRoad:costNewRoadsConstruct) {
			Connection cn=new Connection(newRoad.get(0),newRoad.get(1),
					newRoad.get(2));
			pq.offer(cn);
		}
		
		List<Connection> mst=new ArrayList<>();
		
		while(0<pq.size()&&mst.size()+existingRoadCount<
				numTotalAvailableCities-1) {
			Connection tmpCn=pq.poll();
			int ct1=tmpCn.ct1;
			int ct2=tmpCn.ct2;
			int cost=tmpCn.cost;
			//int sum=0;
			//???
			uf.union(ct1, ct2);
			mst.add(new Connection(ct1,ct2,cost));
		}
		
		int sum=0;
		for(Connection cn:mst) {
			sum+=cn.cost;
		}
		return sum;
	}
}


class Connection{
	int ct1;
	int ct2;
	int cost;
	public Connection(int ct1,int ct2,int cost) {
		this.ct1=ct1;
		this.ct2=ct2;
		this.cost=cost;
	}
}
class UnionFind{
	private int[] ids;
	public UnionFind(int size) {
		this.ids=new int[size+1];
		for(int i=0;i<size+1;i++) {
			this.ids[i]=i;
		}
	}
	
	public int root(int i) {
		while(ids[i]!=i) {
			ids[i]=ids[ids[i]];//this line to do path compression
			i=ids[i];
		}
		return i;
	}
	
	public boolean find(int i,int j) {
		return root(i)==root(j);
	}
	
	public void union(int i,int j) {
		int rooti=root(i);
		int rootj=root(j);
		ids[rooti]=rootj;
		//can also use sz[] to 
		/*if(sz[i]<sz[j]) {
			ids[i]=j;
			sz[j]+=sz[i];
		}{
			id[j]=i;
			sz[i]+=sz[j];
		}*/
	}
}
