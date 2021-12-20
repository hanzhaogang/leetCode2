package leetCode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _451_sortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character,Integer> map=new TreeMap<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((e1,e2)-> {
			return e2.getValue()-e1.getValue();
		});
		for(Map.Entry<Character, Integer> e:map.entrySet()) {
			pq.offer(e);
		}
		StringBuilder sb=new StringBuilder();
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> e=pq.poll();
			for(int i=0;i<e.getValue();i++)
				sb.append(e.getKey());
		}
		
		return sb.toString();
    }
}
