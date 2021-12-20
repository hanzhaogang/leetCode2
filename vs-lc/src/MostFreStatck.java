import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFreStatck {
	
}


class FreqStack{
	Map<Integer,Integer> eleFreqMap;
	List<Deque<Integer>> stackList;
	
	public FreqStack() {
		eleFreqMap=new HashMap<>();
		stackList=new ArrayList<>();
	}
	
	public void push(int x) {
		eleFreqMap.put(x, eleFreqMap.getOrDefault(x,0)+1);
		int newFreq=eleFreqMap.get(x);
		if(stackList.size()<=newFreq) {
			Deque<Integer> s=new ArrayDeque<>();
			s.push(x);
			stackList.add(s);
		}else {
			Deque<Integer> s=stackList.get(newFreq);
			s.push(x);
		}
	}
	
	public int pop() {
		if(stackList.size()==0) return -1;
		
		Deque<Integer> s=stackList.get(stackList.size()-1);
		int res=s.pop();
		if(s.size()==0) {
			stackList.remove(stackList.size()-1);
		}
		return res;
	}
}