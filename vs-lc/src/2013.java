public class 2013 {
}
/*
这道题值得记录一下。
不难看出这是一道HashMap的题目。
我做的时候，一开始，使用了2个Map，
一个Map<Integer,int[]>记录x和与x对应的y（以及y的数量）
一个Map<List<Integer,Integer>,Integer>,记录点point（以及point的数量）
这其实是一种数据的冗余，不必要，而且增加编程难度。（List<Integer,Integer>的操作、int[]的转换）。

后来看了题解，发现其实只要一个嵌套的Map就好了Map<Integer,Map<Integer,Integer>>.

还有一个要注意的点是，Map<Integer,Integer> y2c=x2y2c.get(point[0]);在这一句后面，使用y2c的时候一定要加个null的判断。
因为map中不包含key的时候get方法会返回null。

最后需要注意，在count（point）时，如果point本身不止一个（有重复），需要把len==0的square去掉。
*/
class DetectSquares {

	Map<Integer,Map<Integer,Integer>> x2y2c;
	    public DetectSquares() {
		x2y2c=new HashMap<Integer,Map<Integer,Integer>>();
    }
    
    public void add(int[] point) {
	int x=point[0];
	int y=point[1];

	if(x2y2c.containsKey(x)){
		Map<Integer,Integer> y2c=x2y2c.get(x);
		y2c.put(y,y2c.containsKey(y)?y2c.get(y)+1:1);
        x2y2c.put(x,y2c);
	}else{
		Map<Integer,Integer> y2c=new HashMap<>();
		y2c.put(y,1);
        x2y2c.put(x,y2c);
	}
	
    }
    
    public int count(int[] point) {
        //System.out.println(x2y2c);
	if(x2y2c.isEmpty()||x2y2c.size()==1){
		return 0;
	}

	int res=0;
	Map<Integer,Integer> y2c=x2y2c.get(point[0]);
    //System.out.println(y2c);
    if(y2c==null)
        return 0;
	for(Map.Entry<Integer,Integer> e:y2c.entrySet()){
		int len=Math.abs(e.getKey()-point[1]);
        if(len==0)
            continue;
		if(x2y2c.containsKey(point[0]+len)){
			Map<Integer,Integer> y2c_n=x2y2c.get(point[0]+len);
			if(y2c_n.containsKey(point[1])&&y2c_n.containsKey(e.getKey())){
				res+=e.getValue()*y2c_n.get(point[1])*y2c_n.get(e.getKey());
			}
		}
		if(x2y2c.containsKey(point[0]-len)){
			Map<Integer,Integer> y2c_n=x2y2c.get(point[0]-len);
			if(y2c_n.containsKey(point[1])&&y2c_n.containsKey(e.getKey())){
				res+=e.getValue()*y2c_n.get(point[1])*y2c_n.get(e.getKey());
			}
		}

	}
	return res;
    }	
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
