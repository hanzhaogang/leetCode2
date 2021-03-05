package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, 
 * where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.

    You may assume all letters are in lowercase.
    The dictionary is invalid, if a is prefix of b and b is appear before a.
    If the order is invalid, return an empty string.

    There may be multiple valid order of letters, 
    return the smallest in normal lexicographical order


Example 1:

Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"

Example 2:

Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"


 */
public class _269_alienDict {
	public static void main(String[] args) {
		_269_alienDict s=new _269_alienDict();
//		String[] words=new String[] {"wrt","wrf","er","ett","rftt"};
		String[] words=new String[] {"zy","zx"};
		System.out.println(s.alienOrder(words));
	}
	 public String alienOrder(String[] words) {
		 Map<Character,Set<Character>> graph=new HashMap<>();
		 for(String word:words) {
			 for(char c:word.toCharArray()) {
				 graph.put(c, new HashSet<Character>());
			 }
		 }
		 for(int i=0;i<words.length-1;i++) {
			 String preWord=words[i];
			 String sucWord=words[i+1];
			 for(int j=0;j<Math.min(preWord.length(), sucWord.length());j++) {
				 if(preWord.charAt(j)!=sucWord.charAt(j)) {
					 Set<Character> sucChars=graph.getOrDefault(preWord.charAt(j),
							 new HashSet<Character>());
					 sucChars.add(sucWord.charAt(j));
					 graph.put(preWord.charAt(j), sucChars);
					 break;
				 }
			 }
		 }
		 
		 int[] inDegrees=new int[26];
		 for(Map.Entry<Character, Set<Character>> e:graph.entrySet()) {
			 Set<Character> sucChars=e.getValue();
			 for(Character c:sucChars) {
				 inDegrees[c-'a']++;
			 }
		 }
		 
		 StringBuilder sb=new StringBuilder();
		 PriorityQueue<Character> pq=new PriorityQueue<>();
		 for(Map.Entry<Character, Set<Character>> e:graph.entrySet()) {
			 char c=e.getKey();
			 if(inDegrees[c-'a']==0) {
				 pq.offer(c);
			 }
		 }
		
		 while(!pq.isEmpty()) {
			 int size=pq.size();
			 for(int i=0;i<size;i++) {
				 char c=pq.poll();
				 sb.append(c);
				 Set<Character> sucChars=graph.get(c);
				 for(char sucChar:sucChars) {
					 inDegrees[sucChar-'a']--;
					 if(inDegrees[sucChar-'a']==0) {
						 pq.offer(sucChar);
					 }
				 }
			 }
		 }
		 if(sb.length()==graph.size())
			 return sb.toString();
		 else
			 return "";
	 }
}
