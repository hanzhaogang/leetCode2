package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a non-empty string str and an integer k, 
 * rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.

Example 2:

str = "aaabc", k = 3 

abc,aa

Answer: ""

It is not possible to rearrange the string.

Example 3:

str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

acbacbad

aaadbbcc->abc,aadbc->abcadb,ac
The same letters are at least distance 2 from each other.


aaabbc  k=2
abc,aab->abcab

 */
public class _358_rearrangeStringKDistanceApart {
	public static void main(String[] args) {
		String str="aaadbbcc";
		int k=2;
//		String str="aaabc";
//		int k=3;
//		String str="aabbcc";
//		int k=3;
		_358_rearrangeStringKDistanceApart s=new _358_rearrangeStringKDistanceApart();
		System.out.println(s.rearrangeString(str, k));
	}
	public String rearrangeString(String str, int k) {
		Map<Character,Integer> char2count=new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			char2count.compute(c,(key,v)->(v==null?1:v+1));
		}
		
		StringBuilder sb=new StringBuilder();
		PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((e1,e2)-> {
										return e2.getValue()-e1.getValue();
								});
		pq.addAll(char2count.entrySet());
		
		List<Map.Entry<Character,Integer>> tempList=new ArrayList<>();
		while(k<=pq.size()) {
			for(int i=0;i<k;i++) {
				Map.Entry<Character, Integer> e=pq.poll();
				if(1<e.getValue()) {
					e.setValue(e.getValue()-1);
					tempList.add(e);
				}
				sb.append(e.getKey());
			}
			
			pq.addAll(tempList);
			tempList.clear();
		}
		
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> e=pq.poll();
			if(1<e.getValue()) {	
				return "null";
			}
			sb.append(e.getKey());
		}
		return sb.toString();
	}
}
