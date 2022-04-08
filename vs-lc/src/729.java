import java.util.TreeMap;

public class 729 {
	
}

class MyCalendar {
    TreeMap<Integer,Integer> start2end;
    public MyCalendar() {
        start2end=new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey=start2end.floorKey(start);
	Integer ceilingKey=start2end.ceilingKey(start);
	if(floorKey==null && ceilingKey==null || floorKey==null && end<=ceilingKey || ceilingKey==null && start2end.get(floorKey)<=start || 
			floorKey!=null && ceilingKey!=null && start2end.get(floorKey)<=start && end<=ceilingKey){
		start2end.put(start, end);
		return true;
	}
	return false;
    }
}