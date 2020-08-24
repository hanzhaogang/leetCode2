package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1152_AnalyzeUserWebsiteVisitPattern {
	/*
	We are given some website visits: 
	the user with name username[i] 
	visited the website website[i] 
	at time timestamp[i].

	A 3-sequence is a list of websites of length 3 
	sorted in ascending order by the time of their visits. 
	 (The websites in a 3-sequence are not necessarily distinct.)

	Find the 3-sequence visited by the largest number of users. 
	If there is more than one solution, return the lexicographically smallest such 3-sequence.

	Example 1:

	Input: 
	username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], 
	timestamp = [1,2,3,4,5,6,7,8,9,10], 
	website = ["home","about","career","home","cart","maps","home","home","about","career"]

	Output: 
	["home","about","career"]

	Explanation: 
	The tuples in this example are:
	["joe", 1, "home"]
	["joe", 2, "about"]
	["joe", 3, "career"]
	["james", 4, "home"]
	["james", 5, "cart"]
	["james", 6, "maps"]
	["james", 7, "home"]
	["mary", 8, "home"]
	["mary", 9, "about"]
	["mary", 10, "career"]
	The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
	The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
	The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
	The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
	The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.

	Note:

	    3 <= N = username.length = timestamp.length = website.length <= 50
	    1 <= username[i].length <= 10
	    0 <= timestamp[i] <= 10^9
	    1 <= website[i].length <= 10
	    Both username[i] and website[i] contain only lowercase characters.
	    It is guaranteed that there is at least one user who visited at least 3 websites.
	    No user visits two websites at the same time.
	*/
	public static void main(String[] args) {
		_1152_AnalyzeUserWebsiteVisitPattern a=new _1152_AnalyzeUserWebsiteVisitPattern();
		String[] username= {"joe","joe","joe","james","james","james","james","mary","mary","mary"}; 
		int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
		String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
		List<String> list=a.mostVisitedPattern(username, timestamp, website);
		System.out.println(list);
	}
	
	public List<String> mostVisitedPattern(String[] username, 
											int[] timestamp, 
											String[] website) {
		int visitCount=timestamp.length;
		String[][] visits=new String[visitCount][3];
		for(int i=0;i<visitCount;i++) {
			visits[i]= new String[] {username[i],
								     String.valueOf(timestamp[i]),
									 website[i]};
		}
		
		Arrays.sort(visits,(a,b)->{
				return Integer.parseInt(a[1])-Integer.parseInt(b[1]); 
			});
		
		Map<String,List<String>> user2WebVisits=new HashMap<>();
		for(String[] visit:visits) {
			String usr=visit[0];
			List<String> list=user2WebVisits.getOrDefault(
						usr,new ArrayList<>());
			list.add(visit[2]);
			user2WebVisits.put(usr, list);
		}
		
		Map<String,Integer> pattern2Counts=new HashMap<>();
		for(Map.Entry<String,List<String>> e:user2WebVisits.entrySet()) {
			List<String> list=e.getValue();
			for(int i=0;i<list.size()-2;i++) {
				for(int j=1;j<list.size()-1;j++) {
					for(int k=2;k<list.size();k++) {
						String pattern=comp(list.get(i),list.get(j),
								list.get(k));
						pattern2Counts.put(pattern, 
								pattern2Counts.getOrDefault(pattern,0)+1);
					}
				}
			}
		}
		
		String targetPattern=null;
		int maxCount=0;
		for(Map.Entry<String,Integer> e:pattern2Counts.entrySet()) {
			String pattern=e.getKey();
			int count=e.getValue();
			if(maxCount<count) {
				maxCount=count;
				targetPattern=pattern;
			}else if(maxCount==count&&pattern.compareTo(targetPattern)<0) {
				targetPattern=pattern;
			}
		}
		
		return Arrays.asList(targetPattern.split(","));
	}
	
	private String comp(String s1,String s2,String s3) {
		StringBuilder sb=new StringBuilder();
		sb.append(s1);
		sb.append(",");
		sb.append(s2);
		sb.append(",");
		sb.append(s3);
		return sb.toString();
	}
}