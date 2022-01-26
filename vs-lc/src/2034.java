import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
public class 2034 {
	
}
class StockPrice {
	TreeMap<Integer,Set<Integer>> price2stamp;
	Map<Integer,Integer> stamp2price;
	int[] current;
    public StockPrice() {
	price2stamp=new TreeMap<Integer,Set<Integer>>();
	stamp2price=new HashMap<Integer,Integer>();
	current=new int[2];
    }
    
    public void update(int timestamp, int price) {
	if(!stamp2price.containsKey(timestamp)){
		stamp2price.put(timestamp,price);
		
	}else{
		int old=stamp2price.get(timestamp);
		stamp2price.put(timestamp,price);
		Set<Integer> oldSet=price2stamp.get(old);
		oldSet.remove(timestamp);
		if(oldSet.isEmpty()){
			price2stamp.remove(old);
		}
	}
	Set<Integer> stamps=(price2stamp.containsKey(price))?price2stamp.get(price):new HashSet<>();
		stamps.add(timestamp);
		price2stamp.put(price,stamps);
	if(current[0]<=timestamp){
		current[0]=timestamp;
		current[1]=price;
	}

    }
    
    public int current() {
	return current[1];
    }
    
    public int maximum() {
	return price2stamp.lastKey();
    }
    
    public int minimum() {
	return price2stamp.firstKey();
    }
}