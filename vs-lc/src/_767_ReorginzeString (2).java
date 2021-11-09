package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _767_ReorginzeString {
/*
 * Given a string S, check if the letters can be rearranged 
 * so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:

Input: S = "aaab"
Output: ""

Note:

    S will consist of lowercase letters and have length in range [1, 500].
 */
	public String reorganizeString(String S) {
		Map<Character,Integer> charCnts=new HashMap<>();
		for(int i=0;i<S.length();i++) {
			char c=S.charAt(i);
			charCnts.put(c, charCnts.containsKey(c)?charCnts.get(c)+1:1);
		}

		PriorityQueue<Pair676> pq= new PriorityQueue<>((p1,p2)-> {
			return p2.count-p1.count;
		});
		for(Map.Entry<Character, Integer> e:charCnts.entrySet()) {
			pq.offer(new Pair676(e.getKey(),e.getValue()));
		}
		
		StringBuilder sb=new StringBuilder();
		while(!pq.isEmpty()) {
			Pair676 p1=pq.poll();
			Pair676 p2=pq.poll();
			if(sb.length()==0||sb.charAt(sb.length()-1)!=(char)p1.c){
				sb.append(p1.c);
				if(p2!=null)
					sb.append(p2.c);
				if(1<p1.count--) {
					pq.offer(p1);
				}
				if(p2!=null&&1<p2.count--) {
					pq.offer(p2);
				}
			}else if(sb.charAt(sb.length()-1)==(char)p1.c) {
				if(p2==null)
					return "";
				
				sb.append(p2.c);
				pq.offer(p1);
				if(1<p2.count--)
					pq.offer(p2);
			}
		}
		return sb.toString();
    }
}

class Pair676{
	public Pair676(Character c,Integer count) {
		this.c=c;
		this.count=count;
	}
	public Character c;
	public Integer count;
}


class Solution767 {
    public String reorganizeString(String S) {
        if(S==null||S.length()==0) return "";
        
        //counts  letters
        int[] letterCounts=new int[26];
        for(char c:S.toCharArray()) letterCounts[c-'a']++;
        
        Queue<int[]> heap=new PriorityQueue<>((a1,a2)->
        		Integer.compare(a2[1],a1[1]));//max heap
        for(int i=0;i<26;i++) 
        	heap.add(new int[]{i,letterCounts[i]});
    
        //deterimine the ""
        if(S.length()-heap.peek()[1]<heap.peek()[1]-1) 
        	return "";
        
        StringBuilder sb=new StringBuilder();
        while(!heap.isEmpty()){
            int[] a=heap.remove();
            if(a[1]==0) 
            	continue;
            
            if(sb.length()==0||sb.charAt(sb.length()-1)!=(char)('a'+a[0])){
                sb.append((char)('a'+a[0]));
                if(1<a[1]--) 
                	heap.add(a);    
            }else{
                int[] b=heap.remove();
                sb.append((char)('a'+b[0]));
                heap.add(a);    
                if(1<b[1]--) heap.add(b);                
            }
            
        }
        return sb.toString();
    }
}
