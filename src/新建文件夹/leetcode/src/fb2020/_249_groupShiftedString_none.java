package fb2020;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings (all lowercase letters), 
 * the task is to group them in such a way that all strings in a group are shifted versions of each other. 
 * Two string S and T are called shifted if, 

S.length = T.length 
and
S[i] = T[i] + K for 
1 <= i <= S.length  for a constant integer K

For example strings, {acd, dfg, wyz, yab, mop} are shifted versions of each other.

Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};

Output : a0 x(x-a)
         acd023 dfg023 wyz yab0(-(y-a)) mop
         bdfh moqs
All shifted strings are grouped together.

cad 0  -2 1
ayb 0  24 1
 */
public class _249_groupShiftedString_none {
	public List<List<String>> groupStrings(String[] strings) {
		Map<String,List<String>> map=new HashMap<>();
		for(String str:strings) {
			String rep=findRep(str);
			List<String> list=map.getOrDefault(rep, new ArrayList<String>());
			list.add(str);
			map.put(rep,list);
		}
		
		List<List<String>> res=new ArrayList<>();
		for(Map.Entry<String,List<String>> e:map.entrySet()) {
			res.add(e.getValue());
		}
		
		return res;
	}
	
	private String findRep(String str) {
		StringBuilder sb=new StringBuilder();
		
		return sb.toString();
	}
}
