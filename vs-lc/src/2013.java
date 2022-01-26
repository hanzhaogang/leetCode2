public class 2013 {
	Map<Integer,int[]> x2y;
	Map<List<Integer>,Integer> xy2c;
	    public DetectSquares() {
		x2y=new HashMap<Integer,int[]>();
		xy2c=new HashMap<List<Integer>,Integer>();
    }
    
    public void add(int[] point) {
	int x=point[0];
	int y=point[1];
	List<Integer> xy=Arrays.asList(new int[]{x,y});
	xy2c.put(xy,xy2c.containsKey(xy)?x2yc.get(xy)+1:1);

	if(x2y.containsKey(x)){
		Map<Integer,Integer> y2c=x2y.get(x);
		y2c.put(y,y2c.containsKey(y)?y2c.get(y)+1:1);
	}else{
		Map<Integer,Integer> y2c=new HashMap<>();
		y2c.put(y,1);
	}
	x2y.put(x,y2c);
    }
    
    public int count(int[] point) {
	if(xy2c.isEmpty()||xy2c.size()==1){
		return 0;
	}

	int res=0;
	Map<Integer,Integer> y2c=x2y.get(point[0]);
	for(Map.Entry<Integer,Integer> e:y2c.entrySet()){
		if(xy2c.containsKey(Arrays.asList(new int[]{point[0]-(e.getKey()-point[1]),point[1]}))&&
			xy2c.containsKey(Arrays.asList(new int[]{point[0]-(e.getKey()-point[1]),e.getKey()}))){
				cur+=e.getValue()*
					xy2c.get(Arrays.asList(new int[]{point[0]-(e.getKey()-point[1]),point[1]}))*
					xy2c.get(Arrays.asList(new int[]{point[0]-(e.getKey()-point[1]),e.getKey()}));
		}

		if(xy2c.containsKey(Arrays.asList(new int[]{point[0]+(e.getKey()-point[1]),point[1]}))&&
			xy2c.containsKey(Arrays.asList(new int[]{point[0]+(e.getKey()-points[1]),e.getKey()}))){
				cur+=e.getValue()*
					xy2c.get(Arrays.asList(new int[]{point[0]+(e.getKey()-point[1]),point[1]}))*
					xy2c.get(Arrays.asList(new int[]{point[0]+(e.getKey()-points[1]),e.getKey()}));
		}

		res+=cur;
	}
	return res;
    }	
}
