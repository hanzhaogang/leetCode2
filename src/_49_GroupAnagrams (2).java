package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {
	/*
	 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
	 */
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map=new HashMap<>();
		for(String str:strs) {
			int[] charCnts=new int[26];
			for(int i=0;i<str.length();i++) {
				char c=str.charAt(i);
				charCnts[c-'a']++;
			}
			StringBuilder sb=new StringBuilder();
			for(int i:charCnts) {
				sb.append(i);
				sb.append(",");
			}
			List<String> list;
			if(map.containsKey(sb.toString())) {
				list=map.get(sb.toString());
			}else {
				list=new ArrayList<>();
			}
			list.add(str);
			map.put(sb.toString(),list);
		}
		
		List<List<String>> res=new ArrayList<>();
		for(Map.Entry<String,List<String>> e:map.entrySet()) {
			res.add(e.getValue());
		}
		return res;
	}
}
